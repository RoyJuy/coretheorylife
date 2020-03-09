package com.coretheorylife.common.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Connor
 * 2019年12月4日 创建订单支付成功N分钟计时队列
 */
@Configuration
public class ReceiveOrderDelayConfig {

    public static final String DELAY_QUEUE_RECEIVE_ORDER = "queue.delay.receive.order";
    public static final String DELAY_EXCHANGE_RECEIVE_ORDER = "exchange.delay.receive.order";
    public static final String DELAY_ROUTING_KEY_RECEIVE_ORDER = "routing.delay.receive.order";

    @Bean
    public Queue immediateQueueReceiveOrderDelay() {
        // 第一个参数是创建的queue的名字，第二个参数是是否支持持久化
        return new Queue(ReceiveOrderDelayConfig.DELAY_QUEUE_RECEIVE_ORDER, true);
    }

    @Bean
    public CustomExchange delayExchangeReceiveOrderDelay() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(ReceiveOrderDelayConfig.DELAY_EXCHANGE_RECEIVE_ORDER, "x-delayed-message", true, false, args);
    }

    @Bean
    public Binding bindingNotifyReceiveOrderDelay() {
        return BindingBuilder.bind(immediateQueueReceiveOrderDelay()).to(delayExchangeReceiveOrderDelay()).with(ReceiveOrderDelayConfig.DELAY_ROUTING_KEY_RECEIVE_ORDER).noargs();
    }
}