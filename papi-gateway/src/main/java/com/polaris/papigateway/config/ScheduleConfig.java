package com.polaris.papigateway.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author polaris
 * @version 1.0
 * ClassName AsyncConfig
 * Package com.polaris.papigateway.config
 * Description
 * @create 2024-06-30 11:00
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer{

    @Bean
    public Executor scheduledTaskExecutor() {
        return Executors.newScheduledThreadPool(3); //指定线程池大小
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(scheduledTaskExecutor());
    }
}


