package com.polaris.papigateway;

import com.polaris.papigateway.config.CustomLoadBalanceClientConfiguration;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
@EnableDubbo
@EnableDiscoveryClient
@EnableScheduling
@LoadBalancerClients(defaultConfiguration = CustomLoadBalanceClientConfiguration.class)
public class PapiGatewayApplication {

    public static void main (String[] args){
        SpringApplication.run(PapiGatewayApplication.class, args);
    }

}
