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
 * 2019年12月4日 创建订单15分钟未支付的延迟队列
 */
@Configuration
public class CreateOrderDelayConfig {

    public static final String DELAY_QUEUE_CREATE_ORDER = "queue.delay.create.order";
    public static final String DELAY_EXCHANGE_CREATE_ORDER = "exchange.delay.create.order";
    public static final String DELAY_ROUTING_KEY_CREATE_ORDER = "routing.delay.create.order";

    @Bean
    public Queue immediateQueueCreateOrderDelay() {
        // 第一个参数是创建的queue的名字，第二个参数是是否支持持久化
        return new Queue(CreateOrderDelayConfig.DELAY_QUEUE_CREATE_ORDER, true);
    }

    @Bean
    public CustomExchange delayExchangeCreateOrderDelay() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(CreateOrderDelayConfig.DELAY_EXCHANGE_CREATE_ORDER, "x-delayed-message", true, false, args);
    }

    @Bean
    public Binding bindingNotifyCreateOrderDelayConfig() {
        return BindingBuilder.bind(immediateQueueCreateOrderDelay()).to(delayExchangeCreateOrderDelay()).with(CreateOrderDelayConfig.DELAY_ROUTING_KEY_CREATE_ORDER).noargs();
    }
}