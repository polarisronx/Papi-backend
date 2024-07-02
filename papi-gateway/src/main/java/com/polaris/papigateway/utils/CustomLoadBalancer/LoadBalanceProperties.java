package com.polaris.papigateway.utils.CustomLoadBalancer;

/**
 * @author polaris
 * @version 1.0
 * ClassName LoadBalanceProperties
 * Package com.polaris.papigateway.utils.CustomLoadBalancer
 * Description
 * @create 2024-06-30 8:28
 */
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 负载均衡配置项
 */
@Data
@ConfigurationProperties(prefix = "spring.cloud.gateway.loadbalancer")
public class LoadBalanceProperties {

    private LoadBalancerTypeEnum type = LoadBalancerTypeEnum.ROUND_ROBIN;

}
