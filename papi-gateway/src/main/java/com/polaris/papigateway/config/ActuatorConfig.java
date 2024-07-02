package com.polaris.papigateway.config;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.client.naming.NacosNamingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;
import java.util.concurrent.TimeUnit;

import static com.polaris.common.util.constant.INSTANCE_METRICS_PREFIX;


/**
 * @author polaris
 * @version 1.0
 * ClassName ThreadPoolConfig
 * Package com.polaris.papigateway.config
 * Description
 * @create 2024-06-28 21:14
 */
@Component
@Slf4j
public class ActuatorConfig {
    @Value("${spring.profiles.active}")
    private String profile;

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private NacosNamingService nacosNamingService;
    @Scheduled(fixedDelay = 10000)
    public void scheduledTasks() throws NacosException{
        log.info("定时任务执行中...");
        // 执行定时任务
        List<Instance> instances = nacosNamingService.getAllInstances("papi-interface",profile);
        for(Instance instance : instances){
            String instanceIp = instance.getIp();
            if("dev".equals(profile)){
                instanceIp="127.0.0.1";
            }
            String instanceId = instance.getInstanceId();
            String url = instanceIp + ":" + instance.getPort() + "/api/metrics/";
            HttpResponse response = HttpRequest.get(url).execute();
            log.info("获取到实例"+instanceId+"的指标信息");
            HashMap<String, Object> map= new HashMap<>(JSONUtil.parseObj(response.body()));
            OptionalDouble average = map.values().stream().mapToDouble(o-> ((BigDecimal)o).doubleValue()).filter(d -> d > 0).average();
            if (average.isPresent()) {
                log.info("实例"+instanceId+"的繁忙程度评估均值：" + average.getAsDouble());
                stringRedisTemplate.opsForValue().set(INSTANCE_METRICS_PREFIX + instanceId, String.valueOf(average.getAsDouble()),100, TimeUnit.SECONDS);
            } else {
                log.error("实例"+instanceId+"的繁忙程度评估均值获取失败");
            }
        }
        log.info("定时任务执行结束...");
    }
}
