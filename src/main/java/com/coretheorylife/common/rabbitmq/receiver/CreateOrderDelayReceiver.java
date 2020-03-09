package com.coretheorylife.common.rabbitmq.receiver;

import com.coretheorylife.common.rabbitmq.config.CreateOrderDelayConfig;
import com.coretheorylife.common.utils.LogUtil;
import com.coretheorylife.modules.shop.service.TOrderService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @author Connor
 * 2019年12月4日10:45:38
 * 创建订单延迟队列的消费者
 */
@Component
@Configuration
public class CreateOrderDelayReceiver {

    @Autowired
    private TOrderService tOrderService;

    @Transactional(rollbackFor = Exception.class)
    @RabbitListener(queues = CreateOrderDelayConfig.DELAY_QUEUE_CREATE_ORDER)
    public void get(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        LogUtil.debug(CreateOrderDelayReceiver.class, "收到订单超时延时消息:" + message);
        try {
            tOrderService.orderDelayPay(Long.valueOf(message));
            // 消息签收
            channel.basicAck(tag, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}