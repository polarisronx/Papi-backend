package com.polaris.project.bizmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.polaris.project.bizzmq.PapiMqConstant.PAPI_EXCHANGE_NAME;
import static com.polaris.project.bizzmq.PapiMqConstant.PAPI_ROUTING_KEY;

@Component
public class AsyncInvokeProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param message
     */
    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(PAPI_EXCHANGE_NAME, PAPI_ROUTING_KEY, message);
    }

}
