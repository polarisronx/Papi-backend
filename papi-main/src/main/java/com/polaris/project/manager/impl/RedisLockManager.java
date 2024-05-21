package com.polaris.project.manager.impl;


import com.polaris.common.exception.BusinessException;
import com.polaris.common.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @author polaris
 * @className RedisLockManager
 **/
@Component
@Slf4j
public class RedisLockManager {

    @Resource
    public RedissonClient redissonClient;

    /**
     * redisson分布式锁
     *
     * @param lockName     锁名称
     * @param supplier     供应商
     * @param errorCode    错误代码
     * @param errorMessage 错误消息
     * @return {@link T}
     */
    public <T> T redissonDistributedLocks(String lockName, Supplier<T> supplier, ErrorCode errorCode, String errorMessage) {
        RLock rLock = redissonClient.getLock(lockName);
        try {
            if (rLock.tryLock(0, -1, TimeUnit.MILLISECONDS)) {
                return supplier.get();
            }
            throw new BusinessException(errorCode.getCode(), errorMessage);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, e.getMessage());
        } finally {
            if (rLock.isHeldByCurrentThread()) {
                log.info("unLock: " + Thread.currentThread().getId());
                rLock.unlock();
            }
        }
    }
    /**
     * redisson分布式锁
     *
     * @param lockName     锁名称
     * @param supplier     供应商
     * @param errorMessage 错误消息
     * @return {@link T}
     */
    public <T> T redissonDistributedLocks(String lockName, Supplier<T> supplier, String errorMessage) {
        return redissonDistributedLocks(lockName, supplier, ErrorCode.OPERATION_ERROR, errorMessage);
    }





















}
