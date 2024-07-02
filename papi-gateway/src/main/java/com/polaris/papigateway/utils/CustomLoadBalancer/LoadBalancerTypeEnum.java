package com.polaris.papigateway.utils.CustomLoadBalancer;

/**
 * @author polaris
 * @version 1.0
 * ClassName LoadBalancerTypeEnum
 * Package com.polaris.papigateway.utils.CustomLoadBalancer
 * Description
 * @create 2024-06-30 8:28
 */
public enum LoadBalancerTypeEnum {
    /**
     * 根据请求头中的设置获取对应实例
     */
    HEADER,
    /**
     * 在本地部署的实例中轮询
     */
    GATEWAY,
    /**
     * 轮循
     */
    ROUND_ROBIN,
    /**
     * 根据实例负载分配
     */
    LOAD,
    /**
     * 随机
     */
    RANDOM;
}
