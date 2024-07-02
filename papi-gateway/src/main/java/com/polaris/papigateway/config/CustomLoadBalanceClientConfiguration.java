package com.polaris.papigateway.config;

/**
 * @author polaris
 * @version 1.0
 * ClassName CustomLoadBalanceClientConfiguration
 * Package com.polaris.papigateway.utils.CustomLoadBalancer
 * Description
 * @create 2024-06-30 8:24
 */

import com.polaris.papigateway.utils.CustomLoadBalancer.CustomLoadBalancer;
import com.polaris.papigateway.utils.CustomLoadBalancer.LoadBalanceProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * 自定义负载均衡客户端配置
 *
 */
@SuppressWarnings("all")
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(LoadBalanceProperties.class)
public class CustomLoadBalanceClientConfiguration {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Bean
    @ConditionalOnBean(LoadBalancerClientFactory.class)
    public ReactorLoadBalancer<ServiceInstance> customLoadBalancer(LoadBalanceProperties loadBalanceProperties,
                                                                   StringRedisTemplate stringRedisTemplate,
                                                                   Environment environment,
                                                                   LoadBalancerClientFactory loadBalancerClientFactory) {
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return new CustomLoadBalancer(name, stringRedisTemplate, loadBalanceProperties.getType(),
                loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class));
    }

}
