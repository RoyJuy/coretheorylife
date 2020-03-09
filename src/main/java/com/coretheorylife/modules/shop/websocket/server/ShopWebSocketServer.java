package com.coretheorylife.modules.shop.websocket.server;

import com.coretheorylife.common.rabbitmq.entity.WebSocketOrderDelayEntity;
import com.coretheorylife.common.rabbitmq.producer.WebSocketOrderDelayProducer;
import com.coretheorylife.common.utils.LogUtil;
import com.coretheorylife.common.utils.RedisUtils;
import com.coretheorylife.common.utils.SnowflakeIdGenerator;
import com.coretheorylife.config.MyEndpointConfigure;
import com.coretheorylife.common.sms.utils.SmsSender;
import com.coretheorylife.modules.shop.entity.TShop;
import com.coretheorylife.modules.shop.entity.TShopToken;
import com.coretheorylife.modules.shop.service.TShopService;
import com.coretheorylife.modules.shop.service.TShopTokenService;
import com.coretheorylife.modules.shop.websocket.entiry.ShopOrderSocketEntity;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Connor
 * 2019年5月14日12:50:36
 */
@ServerEndpoint(value = "/shop/socket/order/{token}", configurator = MyEndpointConfigure.class)
@Component
public class ShopWebSocketServer {

    private final static Map<String, Session> connections = new ConcurrentHashMap<>(100);

    public static final String SHOP_SOCKET_KEY = "SHOP_SOCKET_KEY_";

    public static final String SHOP_REDIS_KEY = "CORE_THEORY_SHOP_REDIS_KEY_";

    @Autowired
    private TShopTokenService tShopTokenService;

    @Autowired
    private SmsSender smsSender;

    @Autowired
    private TShopService tShopService;

    @Autowired
    private WebSocketOrderDelayProducer webSocketOrderDelayProducer;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token) {
        TShopToken tokenEntity = tShopTokenService.queryByToken(token);
        if (tokenEntity == null || tokenEntity.getExpiredTime().getTime() < System.currentTimeMillis()) {
            try {
                ShopOrderSocketEntity shopOrderSocketEntity = new ShopOrderSocketEntity();
                shopOrderSocketEntity.setCode(400);
                shopOrderSocketEntity.setType(ShopOrderSocketEntity.TYPE_TOKEN_INVALID);
                shopOrderSocketEntity.setMessage("token失效");
                session.getBasicRemote().sendText(new Gson().toJson(shopOrderSocketEntity));
            } catch (IOException e) {
                LogUtil.debug(ShopWebSocketServer.class, "websocket IO异常");
            }
        } else {
            try {
                ShopOrderSocketEntity shopOrderSocketEntity = new ShopOrderSocketEntity();
                shopOrderSocketEntity.setCode(200);
                shopOrderSocketEntity.setMessage("连接成功");
                session.getBasicRemote().sendText(new Gson().toJson(shopOrderSocketEntity));
            } catch (IOException e) {
                LogUtil.debug(ShopWebSocketServer.class, "websocket IO异常");
            }
            connections.put(SHOP_SOCKET_KEY + tokenEntity.getShopId() + "", session);
            LogUtil.debug(ShopWebSocketServer.class, "有新窗口开始监听:" + token + ",当前在线人数为" + +connections.size());
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(@PathParam("token") String token) {
        TShopToken tokenEntity = tShopTokenService.queryByToken(token);
        if (tokenEntity != null) {
            connections.remove(SHOP_SOCKET_KEY + tokenEntity.getShopId() + "");
        }
        LogUtil.debug(ShopWebSocketServer.class, "有一连接关闭！当前在线人数为" + connections.size());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("token") String token) {
        LogUtil.debug(ShopWebSocketServer.class, "收到来自窗口" + token + "的信息:" + message);
        if (message.equals("HeartbeatClient")) {
            // 客户端的心跳包消息
            sendHeartbeat(session);
        } else if (message.equals("HeartbeatServer")) {
            // 服务器主动发送心跳包 客户端的回复 服务器不需要处理
        } else {
            // 客户端收到消息的确认，服务器删除掉redis
            redisUtils.delete(SHOP_REDIS_KEY + message);
        }
    }

    private void sendWebsocketMessageConfirm(String messageId) {
        redisUtils.set(SHOP_REDIS_KEY + messageId, 0);
        WebSocketOrderDelayEntity webSocketOrderDelayEntity = new WebSocketOrderDelayEntity();
        webSocketOrderDelayEntity.setTimes(1);
        webSocketOrderDelayEntity.setMessageId(messageId);
        webSocketOrderDelayProducer.send(new Gson().toJson(webSocketOrderDelayEntity), 10000);
    }

    public void sendHeartbeat(Session session) {
        Map<String, Object> map = new HashMap<>();
        map.put("type", ShopOrderSocketEntity.TYPE_HEARTBEAT_CLIENT);
        try {
            session.getBasicRemote().sendText(new Gson().toJson(map));
        } catch (IOException e) {
            LogUtil.debug(ShopWebSocketServer.class, "发送心跳包消息失败");
        }
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        LogUtil.debug(ShopWebSocketServer.class, "发生错误");
    }

    public void sendNewOrder(Long shopId, String orderNo) {
        Session session = connections.get(SHOP_SOCKET_KEY + shopId + "");
        if (session == null) {
            TShop tShop = tShopService.queryObject(shopId);
            smsSender.sendOrderTips(tShop.getMobile(), orderNo);
            return;
        }
        ShopOrderSocketEntity message = new ShopOrderSocketEntity();
        String messageId = new SnowflakeIdGenerator(10, 20).nextId() + "";
        message.setMessageId(messageId);
        sendWebsocketMessageConfirm(messageId);
        message.setCode(200);
        message.setMessage("你有一个新订单" + orderNo + "，请及时接单");
        message.setType(ShopOrderSocketEntity.TYPE_NEW_ORDER);
        try {
            session.getBasicRemote().sendText(new Gson().toJson(message));
        } catch (IOException e) {
            LogUtil.debug(ShopWebSocketServer.class, "发送【新订单】推送消息失败，重新发送短信");
            TShop tShop = tShopService.queryObject(shopId);
            smsSender.sendOrderTips(tShop.getMobile(), orderNo);
        }
    }

    public void sendUrgeOrder(Long shopId, Long orderId) {
        Session session = connections.get(SHOP_SOCKET_KEY + shopId + "");
        if (session == null) {
            // 如果商家断开了就不管了，催单不是那么重要
            return;
        }
        ShopOrderSocketEntity message = new ShopOrderSocketEntity();
        String messageId = new SnowflakeIdGenerator(10, 20).nextId() + "";
        message.setMessageId(messageId);
        sendWebsocketMessageConfirm(messageId);
        message.setCode(200);
        message.setMessage("用户进行了催单，请及时完成");
        message.setType(ShopOrderSocketEntity.TYPE_URGE_ORDER);
        message.setOrderId(orderId);
        try {
            session.getBasicRemote().sendText(new Gson().toJson(message));
        } catch (IOException e) {
            LogUtil.debug(ShopWebSocketServer.class, "发送【催单】推送消息失败");
        }
    }

    public void sendCancelOrder(Long shopId, Long orderId) {
        Session session = connections.get(SHOP_SOCKET_KEY + shopId + "");
        if (session == null) {
            // 如果商家断开了就不管了，催单不是那么重要
            return;
        }
        ShopOrderSocketEntity message = new ShopOrderSocketEntity();
        String messageId = new SnowflakeIdGenerator(10, 20).nextId() + "";
        message.setMessageId(messageId);
        sendWebsocketMessageConfirm(messageId);
        message.setCode(200);
        message.setMessage("用户取消了订单");
        message.setType(ShopOrderSocketEntity.TYPE_CANCEL_ORDER);
        message.setOrderId(orderId);
        try {
            session.getBasicRemote().sendText(new Gson().toJson(message));
        } catch (IOException e) {
            LogUtil.debug(ShopWebSocketServer.class, "发送【取消定单】推送消息失败");
        }
    }

    public void sendOrderStatusChange(Long shopId, Long orderId, int from, int to, int fromShip, int toShip) {
        Session session = connections.get(SHOP_SOCKET_KEY + shopId + "");
        if (session == null) {
            // 如果商家断开了就不管了，催单不是那么重要
            return;
        }
        ShopOrderSocketEntity message = new ShopOrderSocketEntity();
        String messageId = new SnowflakeIdGenerator(10, 20).nextId() + "";
        message.setMessageId(messageId);
        sendWebsocketMessageConfirm(messageId);
        message.setCode(200);
        message.setMessage("订单状态改变");
        message.setType(ShopOrderSocketEntity.TYPE_STATUS_CHANGE);
        message.setOrderId(orderId);
        message.setFromStatus(from);
        message.setToStatus(to);
        message.setFromShipStatus(fromShip);
        message.setToShipStatus(toShip);
        try {
            session.getBasicRemote().sendText(new Gson().toJson(message));
        } catch (IOException e) {
            LogUtil.debug(ShopWebSocketServer.class, "发送【顺丰回调】推送消息失败");
        }
    }
}

