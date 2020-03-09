package com.coretheorylife.modules.purchaser.websocket.server;

import com.coretheorylife.common.utils.LogUtil;
import com.coretheorylife.config.MyEndpointConfigure;
import com.coretheorylife.common.sms.utils.SmsSender;
import com.coretheorylife.modules.purchaser.entity.TPurchaser;
import com.coretheorylife.modules.purchaser.entity.TPurchaserToken;
import com.coretheorylife.modules.purchaser.service.TPurchaserService;
import com.coretheorylife.modules.purchaser.service.TPurchaserTokenService;
import com.coretheorylife.modules.purchaser.websocket.entiry.PurchaserOrderSocketEntity;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Connor
 * 2019年5月14日12:50:36
 */
@ServerEndpoint(value = "/purchaser/socket/order/{token}", configurator = MyEndpointConfigure.class)
@Component
public class PurchaserWebSocketServer {

    private final static Map<String, Session> connections = new ConcurrentHashMap<>(100);

    public static final String PURCHASER_SOCKET_KEY_ = "PURCHASER_SOCKET_KEY_";

    @Autowired
    private TPurchaserTokenService tPurchaserTokenService;

    @Autowired
    private SmsSender smsSender;

    @Autowired
    private TPurchaserService tPurchaserService;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token) {
        TPurchaserToken tokenEntity = tPurchaserTokenService.queryByToken(token);
        if (tokenEntity == null || tokenEntity.getExpiredTime().getTime() < System.currentTimeMillis()) {
            try {
                PurchaserOrderSocketEntity purchaserOrderSocketEntity = new PurchaserOrderSocketEntity();
                purchaserOrderSocketEntity.setCode(400);
                purchaserOrderSocketEntity.setType(PurchaserOrderSocketEntity.TYPE_TOKEN_INVALID);
                purchaserOrderSocketEntity.setMessage("token失效");
                session.getBasicRemote().sendText(new Gson().toJson(purchaserOrderSocketEntity));
            } catch (IOException e) {
                LogUtil.debug(PurchaserWebSocketServer.class, "websocket IO异常");
            }
        } else {
            try {
                PurchaserOrderSocketEntity shopOrderSocketEntity = new PurchaserOrderSocketEntity();
                shopOrderSocketEntity.setCode(200);
                shopOrderSocketEntity.setMessage("连接成功");
                session.getBasicRemote().sendText(new Gson().toJson(shopOrderSocketEntity));
            } catch (IOException e) {
                LogUtil.debug(PurchaserWebSocketServer.class, "websocket IO异常");
            }
            connections.put(PURCHASER_SOCKET_KEY_ + tokenEntity.getPurchaserId() + "", session);
            LogUtil.debug(PurchaserWebSocketServer.class, "有新窗口开始监听:" + token + ",当前在线人数为" + +connections.size());
        }

    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(@PathParam("token") String token) {
        TPurchaserToken tokenEntity = tPurchaserTokenService.queryByToken(token);
        if (tokenEntity != null) {
            connections.remove(PURCHASER_SOCKET_KEY_ + tokenEntity.getPurchaserId() + "");
        }
        LogUtil.debug(PurchaserWebSocketServer.class, "有一连接关闭！当前在线人数为" + connections.size());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("token") String token) {
        LogUtil.debug(PurchaserWebSocketServer.class, "收到来自窗口" + token + "的信息:" + message);
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        LogUtil.debug(PurchaserWebSocketServer.class, "发生错误");
    }

    /**
     * 商家接单推送
     * @param orderId
     * @param purchaserId
     */
    public void sendReceiveOrder(Long orderId, Long purchaserId) {
        Session session = connections.get(PURCHASER_SOCKET_KEY_ + purchaserId + "");
        if (session == null) {
            return;
        }
        PurchaserOrderSocketEntity message = new PurchaserOrderSocketEntity();
        message.setCode(200);
        message.setMessage("商家已接单");
        message.setType(PurchaserOrderSocketEntity.TYPE_RECEIVE_ORDER);
        message.setOrderId(orderId);
        try {
            session.getBasicRemote().sendText(new Gson().toJson(message));
        } catch (IOException e) {
            LogUtil.debug(PurchaserWebSocketServer.class, "发送【接受订单】推送消息失败，重新发送短信");
        }
    }

    /**
     * 订单被拒绝推送
     * @param orderId
     * @param purchaserId
     */
    public void sendRejectOrder(Long orderId, Long purchaserId) {
        Session session = connections.get(PURCHASER_SOCKET_KEY_ + purchaserId + "");
        if (session == null) {
            TPurchaser tPurchaser = tPurchaserService.queryObject(purchaserId);
            smsSender.sendOrderRejectMessage(tPurchaser.getMobile());
            return;
        }
        PurchaserOrderSocketEntity message = new PurchaserOrderSocketEntity();
        message.setCode(200);
        message.setMessage("商家已接单");
        message.setType(PurchaserOrderSocketEntity.TYPE_RECEIVE_ORDER);
        message.setOrderId(orderId);
        try {
            session.getBasicRemote().sendText(new Gson().toJson(message));
        } catch (IOException e) {
            LogUtil.debug(PurchaserWebSocketServer.class, "发送【新订单】推送消息失败，重新发送短信");
            TPurchaser tPurchaser = tPurchaserService.queryObject(purchaserId);
            smsSender.sendOrderRejectMessage(tPurchaser.getMobile());
        }
    }

}

