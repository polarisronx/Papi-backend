package com.polaris.project.bizmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import static com.polaris.project.bizzmq.PapiMqConstant.*;

/**
 * 用于创建测试程序用到的交换机和队列（只用在程序启动前执行一次）
 */
public class MQInitMain {

    public static void main(String[] args) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("106.15.79.18");
            factory.setUsername("admin");
            factory.setPort(5672);
            factory.setPassword("123456");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(PAPI_EXCHANGE_NAME, "direct");
            // 创建队列，随机分配一个队列名称
            channel.queueDeclare(PAPI_QUEUE_NAME, true, false, false, null);
            channel.queueBind(PAPI_QUEUE_NAME, PAPI_EXCHANGE_NAME,  PAPI_ROUTING_KEY);
        } catch (Exception e) {

        }

    }
}
