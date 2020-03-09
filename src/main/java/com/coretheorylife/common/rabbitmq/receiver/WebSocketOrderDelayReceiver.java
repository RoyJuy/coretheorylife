package com.coretheorylife.common.rabbitmq.receiver;

import com.coretheorylife.common.rabbitmq.config.WebSocketOrderDelayConfig;
import com.coretheorylife.common.rabbitmq.entity.WebSocketOrderDelayEntity;
import com.coretheorylife.common.rabbitmq.producer.WebSocketOrderDelayProducer;
import com.coretheorylife.common.utils.LogUtil;
import com.coretheorylife.common.utils.RedisUtils;
import com.coretheorylife.modules.shop.websocket.server.ShopWebSocketServer;
import com.google.gson.Gson;
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
 * socket消息回复的消费者
 */
@Component
@Configuration
public class WebSocketOrderDelayReceiver {

    @Autowired
    private WebSocketOrderDelayProducer webSocketOrderDelayProducer;

    @Autowired
    private RedisUtils redisUtils;

    @RabbitListener(queues = WebSocketOrderDelayConfig.DELAY_QUEUE_WEBSOCKET_ORDER)
    public void get(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        LogUtil.debug(WebSocketOrderDelayReceiver.class, "收到socket消息回复延时消息:" + message);
        try {
            WebSocketOrderDelayEntity receiveMessage = new Gson().fromJson(message, WebSocketOrderDelayEntity.class);
            if (redisUtils.get(ShopWebSocketServer.SHOP_REDIS_KEY) != null) {
                if (receiveMessage.getTimes() >= 3) {
                    // DO NOTHING
                    LogUtil.debug(WebSocketOrderDelayReceiver.class, "socket消息无人接收");
                } else {
                    int delay;
                    if (receiveMessage.getTimes() == 1) {
                        delay = 30000;
                    } else {
                        delay = 60000;
                    }
                    receiveMessage.setTimes(receiveMessage.getTimes() + 1);
                    webSocketOrderDelayProducer.send(new Gson().toJson(receiveMessage), delay);
                }
            }
            // 消息签收
            channel.basicAck(tag, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}