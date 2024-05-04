package com.polaris.project.utils;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;


/**
 * @author polaris
 * @version 1.0
 * ClassName MySequence
 * Package com.polaris.project.utils
 * Description 时间戳39位，工作机器4位，序列号10位，系统最大可用时限：2041-06-02 21:56:53，每毫秒可产生1024个序列号
 * @create 2024-05-04 16:26
 */
@Service
public class MySequence implements IdentifierGenerator {

    private static final Logger log = LoggerFactory.getLogger(MySequence.class);

    /**
     * 时间起始标记点，作为基准，取2024-01-01 00:00:00（一旦确定不能变动）
     */
    private final long twepoch = 1704038400000L;

    /**
     * 10位的机器id
     */
    private final long workerIdBits = 4L;
    /**
     * 12位的序列号 每毫秒内产生的id数: 2的12次方个
     */
    private final long sequenceBits = 10L;
    /**
     * 最大的工作机器ID
     */
    protected final long maxWorkerId = ~(-1L << workerIdBits);
    /**
     * 机器id左移动位
     */
    private final long workerIdShift = sequenceBits;
    /**
     * 时间戳左移动位
     */
    private final long timestampLeftShift = sequenceBits + workerIdBits;
    /**
     * 4095
     */
    private final long sequenceMask = ~(-1L << sequenceBits);

    /**
     * 所属机器id
     */
    private final long workerId;
    /**
     * 并发控制序列
     */
    private long sequence = 0L;

    /**
     * 上次生产 ID 时间戳
     */
    private long lastTimestamp = -1L;

    public MySequence() {
        this.workerId = getWorkerId();
    }

    /**
     * 有参构造器
     *
     * @param workerId     工作机器 ID
     */
    public MySequence(long workerId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("Worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        this.workerId = workerId;
    }

    /**
     * 基于网卡MAC地址计算余数作为机器id
     */
    protected long getWorkerId() {
        long id = 0L;
        try {
            NetworkInterface network = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
            if (null == network) {
                id = 1L;
            } else {
                byte[] mac = network.getHardwareAddress();
                if (null != mac) {
                    id = ((0x000000FF & (long) mac[mac.length - 2]) | (0x0000FF00 & (((long) mac[mac.length - 1]) << 8))) >> 6;
                    id = id % (maxWorkerId + 1);
                }
            }
        } catch (Exception e) {
            log.warn(() -> "getWorkerId: " + e.getMessage());
        }

        return id;
    }

    /**
     * 获取下一个 ID
     *
     */

    public synchronized long nextId() {
        long timestamp = timeGen();
        // 闰秒
        if (timestamp < lastTimestamp) {
            long offset = lastTimestamp - timestamp;
            if (offset <= 5) {
                try {
                    // 休眠双倍差值后重新获取，再次校验
                    wait(offset << 1);
                    timestamp = timeGen();
                    if (timestamp < lastTimestamp) {
                        throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", offset));
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", offset));
            }
        }

        if (lastTimestamp == timestamp) {
            // 相同毫秒内，序列号自增
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                // 同一毫秒的序列数已经达到最大
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            // 不同毫秒内，序列号置为 1 - 3 随机数
            sequence = ThreadLocalRandom.current().nextLong(1, 3);
        }

        lastTimestamp = timestamp;

        // 时间戳部分 | 机器标识部分 | 序列号部分
        return ((timestamp - twepoch) << timestampLeftShift)
                | (workerId << workerIdShift)
                | sequence;
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }

        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    @Override
    public Number nextId (Object entity){
        return this.nextId();
    }
}
