package com.polaris.papigateway.utils.CustomLoadBalancer;


import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import com.polaris.common.exception.ErrorCode;
import com.polaris.papigateway.utils.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.DefaultRequest;
import org.springframework.cloud.client.loadbalancer.DefaultResponse;
import org.springframework.cloud.client.loadbalancer.EmptyResponse;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.client.loadbalancer.RequestData;
import org.springframework.cloud.client.loadbalancer.RequestDataContext;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.loadbalancer.core.NoopServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.SelectedInstanceCallback;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.polaris.common.exception.ThrowUtils.throwIf;
import static com.polaris.common.util.constant.INSTANCE_METRICS_PREFIX;


/**
 * @author polaris
 * @version 1.0
 * ClassName CustomSpringCloudLoadBalancer
 * Package com.polaris.papigateway.utils.CustomLoadBalancer
 * Description  * 自定义 SpringCloud 负载均衡算法
 *  * 负载均衡算法的默认实现是 {@link org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer}
 * @date 2024-06-30 8:34
 */
@Slf4j
public class CustomLoadBalancer implements ReactorServiceInstanceLoadBalancer {
    private ConcurrentHashMap<String, Double> map = new ConcurrentHashMap<>();
    private StringRedisTemplate stringRedisTemplate;
    private final String serviceId;
    private final AtomicInteger position;
    private final LoadBalancerTypeEnum type;
    private final ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider;

    public CustomLoadBalancer (String serviceId,
                               StringRedisTemplate stringRedisTemplate,
                               LoadBalancerTypeEnum type,
                               ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider) {
        this(serviceId, new Random().nextInt(1000), type, serviceInstanceListSupplierProvider);
        this.stringRedisTemplate=stringRedisTemplate;
    }

    public CustomLoadBalancer (String serviceId,
                               int seedPosition,
                               LoadBalancerTypeEnum type,
                               ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider) {
        this.serviceId = serviceId;
        this.position = new AtomicInteger(seedPosition);
        this.type = type;
        this.serviceInstanceListSupplierProvider = serviceInstanceListSupplierProvider;
    }

    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        ServiceInstanceListSupplier supplier = serviceInstanceListSupplierProvider.getIfAvailable(NoopServiceInstanceListSupplier::new);
        return supplier.get(request).next().map(serviceInstances -> processInstanceResponse(request, supplier, serviceInstances));
    }

    private Response<ServiceInstance> processInstanceResponse(Request request,
                                                              ServiceInstanceListSupplier supplier,
                                                              List<ServiceInstance> serviceInstances) {
        Response<ServiceInstance> serviceInstanceResponse = getInstanceResponse(request, serviceInstances);
        if (supplier instanceof SelectedInstanceCallback && serviceInstanceResponse.hasServer()) {
            ((SelectedInstanceCallback) supplier).selectedServiceInstance(serviceInstanceResponse.getServer());
        }
        return serviceInstanceResponse;
    }

    private Response<ServiceInstance> getInstanceResponse(Request request, List<ServiceInstance> instances) {
        if (instances.isEmpty()) {
            if (log.isWarnEnabled()) {
                log.warn("No servers available for service: " + serviceId);
            }
            return new EmptyResponse();
        }

        if (Objects.equals(type, LoadBalancerTypeEnum.ROUND_ROBIN)){
            return this.getRoundRobinInstance(instances);
        }else if (Objects.equals(type, LoadBalancerTypeEnum.RANDOM)){
            return this.getRandomInstance(instances);
        }else if (Objects.equals(type, LoadBalancerTypeEnum.GATEWAY)){
            return this.getInstanceInLocalhost(instances);
        }else if (Objects.equals(type, LoadBalancerTypeEnum.HEADER)){
            return this.getInstanceFilterByHeader(request, instances);
        }else if (Objects.equals(type, LoadBalancerTypeEnum.LOAD)){
            return this.getInstanceFilterByLoad(request,instances,stringRedisTemplate);
        }
        return this.getRoundRobinInstance(instances);
    }

    /**
     * 根据请求头信息选取：如获取网关所在ip部署的实例
     *
     * @param instances 实例
     * @return {@link Response }<{@link ServiceInstance }>
     * @author : polaris
     */
    private Response<ServiceInstance> getInstanceFilterByHeader (Request request, List<ServiceInstance> instances) {

        //把request转为默认的DefaultRequest，从request中拿到请求的ip信息，再选择ip一样的微服务
        DefaultRequest<RequestDataContext> defaultRequest = Convert.convert(new TypeReference<DefaultRequest<RequestDataContext>>() {}, request);
        RequestDataContext context = defaultRequest.getContext();
        RequestData clientRequest = context.getClientRequest();
        HttpHeaders headers = clientRequest.getHeaders();
        String requestIp = IpUtils.getIpAddressFromHttpHeaders(headers);
        log.debug("请求头中携带的ip需求:{}", requestIp);

        //由header提供的IP来过滤服务，如果没有符合条件的则按默认轮询
        List<ServiceInstance> instancesFilterByHeader = instances.stream().filter(instance1 -> StringUtils.equals(instance1.getHost(), requestIp)).collect(Collectors.toList());
        instancesFilterByHeader.forEach(instance ->log.debug("注册服务：{}，ip：{}", instance.getInstanceId(), instance.getHost()));
        return getRoundRobinInstance(instancesFilterByHeader.isEmpty()? instances : instancesFilterByHeader);
    }


    /**
     * 获取本地ip上部署的实例
     *
     * @param instances 实例
     * @return {@link Response }<{@link ServiceInstance }>
     * @author : polaris
     */
    private Response<ServiceInstance> getInstanceInLocalhost(List<ServiceInstance> instances) {
        //获取本机ip
        String hostIp = IpUtils.getHostIp();
        log.debug("本机Ip:{}", hostIp);

        List<ServiceInstance> instancesInLocalhost = instances.stream().filter(instance1 -> StringUtils.equals(instance1.getHost(), hostIp)).collect(Collectors.toList());
        instancesInLocalhost.forEach(instance ->log.debug("注册服务：{}，ip：{}", instance.getInstanceId(), instance.getHost()));
        return getRoundRobinInstance(instancesInLocalhost.isEmpty()? instances : instancesInLocalhost);
    }

    /**
     * 使用随机算法
     * 参考{link {@link org.springframework.cloud.loadbalancer.core.RandomLoadBalancer}}
     *
     * @param instances 实例
     * @return {@link Response }<{@link ServiceInstance }>
     * @author : polaris
     */
    private Response<ServiceInstance> getRandomInstance(List<ServiceInstance> instances) {
        int index = ThreadLocalRandom.current().nextInt(instances.size());
        ServiceInstance instance = instances.get(index);
        return new DefaultResponse(instance);
    }

    /**
     * 使用RoundRobin机制获取节点
     *
     * @param instances 实例
     * @return {@link Response }<{@link ServiceInstance }>
     * @author : polaris
     */
    private Response<ServiceInstance> getRoundRobinInstance(List<ServiceInstance> instances) {
        // 每一次计数器都自动+1，实现轮询的效果
        int pos = this.position.incrementAndGet() & Integer.MAX_VALUE;
        ServiceInstance instance = instances.get(pos % instances.size());
        return new DefaultResponse(instance);
    }
    /**
     * 根据负载情况选择实例
     *
     * @param instances 实例
     * @return {@link Response }<{@link ServiceInstance }>
     * @author : polaris
     */
    private Response<ServiceInstance> getInstanceFilterByLoad(Request request, List<ServiceInstance> instances, StringRedisTemplate stringRedisTemplate) {
        DefaultRequest<RequestDataContext> defaultRequest = Convert.convert(new TypeReference<DefaultRequest<RequestDataContext>>() {}, request);
        RequestDataContext context = defaultRequest.getContext();
        RequestData clientRequest = context.getClientRequest();
        HttpMethod httpMethod = clientRequest.getHttpMethod();
        List<ServiceInstance> interfaceInstances = instances.stream().filter(instance -> instance.getHost().equals("papi-interface")).collect(Collectors.toList());
        if (httpMethod.equals(HttpMethod.POST)){ // get请求默认轮询
            for(ServiceInstance instance:interfaceInstances){
                String metrics = stringRedisTemplate.opsForValue().get(INSTANCE_METRICS_PREFIX + instance.getInstanceId());
                throwIf(metrics == null, ErrorCode.SYSTEM_ERROR,"Instance metrics not found");
                map.put(instance.getInstanceId(), Double.parseDouble(metrics));
            }
            instances.sort((o1, o2) -> Double.compare(map.get(o2.getInstanceId()), map.get(o1.getInstanceId())));
        }
        log.info("LoadBalance Strategy:Load; Request executed by instance {}", instances.get(0).getInstanceId());
        return new DefaultResponse(instances.get(0));
    }
}
