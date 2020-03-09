package com.coretheorylife.common.rabbitmq.producer;

import com.coretheorylife.common.rabbitmq.config.CreateOrderDelayConfig;
import com.coretheorylife.common.utils.LogUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Connor
 * 2019年12月4日10:45:38
 * 创建订单延迟队列的生产者
 */
@Component
public class CreateOrderDelayProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String message, int delay) {
        rabbitTemplate.setMandatory(true);
        LogUtil.debug(CreateOrderDelayProducer.class, "订单id为" + message + "的订单开始了超时计时");
        this.rabbitTemplate.convertAndSend(CreateOrderDelayConfig.DELAY_EXCHANGE_CREATE_ORDER, CreateOrderDelayConfig.DELAY_ROUTING_KEY_CREATE_ORDER, message, messagePost -> {
            messagePost.getMessageProperties().setDelay(delay);
            return messagePost;
        });
    }
}