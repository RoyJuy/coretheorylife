package com.coretheorylife.common.rabbitmq.producer;

import com.coretheorylife.common.rabbitmq.config.ReceiveOrderDelayConfig;
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
public class ReceiveOrderDelayProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String message, int delay) {
        rabbitTemplate.setMandatory(true);
        LogUtil.debug(ReceiveOrderDelayProducer.class, "订单id为" + message + "的订单开始了超时不接单计时");
        this.rabbitTemplate.convertAndSend(ReceiveOrderDelayConfig.DELAY_EXCHANGE_RECEIVE_ORDER, ReceiveOrderDelayConfig.DELAY_ROUTING_KEY_RECEIVE_ORDER, message, messagePost -> {
            messagePost.getMessageProperties().setDelay(delay);
            return messagePost;
        });
    }
}