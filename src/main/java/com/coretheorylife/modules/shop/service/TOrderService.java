package com.coretheorylife.modules.shop.service;

import com.coretheorylife.common.sf.entity.SFStatusChange;
import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.shop.entity.TOrder;
import com.coretheorylife.modules.shop.entity.TOrderExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTOrder;

import java.util.List;
import java.util.Map;

public interface TOrderService extends BaseService<TOrder, TOrderExample> {

    List<ExtTOrder> queryList(Map<String, Object> keys);

    List<ExtTOrder> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    /**
     * 根据店铺id或用户id查询订单
     *
     * @param keys
     * @return
     */
    List<ExtTOrder> queryListByShopIdOrUserId(Map<String, Object> keys);

    int queryTotalByShopIdOrUserId(Map<String, Object> keys);

    /**
     * 下单
     *
     * @param t
     * @return
     */
    int createOrder(ExtTOrder t);

    /**
     * 催单
     *
     * @param orderId
     * @return
     */
    int urgeOrder(Long orderId, Long purchaserId);

    /**
     * 用户取消订单 需要做shopId的分布式锁
     *
     * @param orderId
     * @param description
     * @return
     */
    int cancelOrder(Long orderId, Long purchaserId, String description);

    /**
     * 根据商品id获取店铺id
     * @param orderId
     * @return
     */
    long getShopIdByOrder(Long orderId);

    /**
     * 接受订单
     *
     * @param orderId 用于验证订单的商家和当前用户是不是同一个人
     * @param shopId
     * @return
     */
    int receiveOrder(Long orderId, Long shopId);

    /**
     * 拒绝接单
     *
     * @param orderId 需要做shopId的分布式锁
     * @param shopId
     * @return
     */
    int rejectOrder(Long orderId, Long shopId);

    /**
     * 用户订单持有检测
     * @param orderId
     * @param purchaserId
     */
    void purchaserOrderCheck(Long orderId, Long purchaserId);

    /**
     * 商家订单持有检测
     * @param orderId
     * @param shopId
     */
    void shopOrderCheck(Long orderId, Long shopId);

    /**
     * 返回优惠券
     * @param orderId
     */
    void returnDiscount(Long orderId);

    /**
     * 退还用户支付的钱
     * @param orderId
     */
    void returnMoney(Long orderId);

    /**
     * 商品月售
     * @param goodsId
     * @param number
     */
    void addGoodsMonthSell(Long goodsId, int number);

    /**
     * 扣除商品月售
     * @param orderId
     */
    void discountGoodsMonthSell(Long orderId);

    /**
     * 扣除商品月售
     * @param goodsId
     * @param number
     */
    void discountGoodsMonthSell(Long goodsId, int number);

    /**
     * 在线支付统一下单
     *
     * @param payType
     * @param purchaserId
     * @param orderId
     * @return
     */
    Map<String, Object> unifiedOrder(String payType, Long purchaserId, Long orderId);

    /**
     * 支付回调
     * @param outTradeNo
     */
    void paySuccess(String outTradeNo, String tradeNo);

    /**
     * 更改订单状态
     */
    void changeStatus(SFStatusChange sfStatusChange);

    /**
     * 根据订单号查订单
     * @param orderNo
     * @return
     */
    TOrder queryObjectByOrderNo(String orderNo);

    /**
     * 订单超时
     * @param orderId
     * @return
     */
    int orderDelayPay(Long orderId);

    /**
     * 订单超时未接受
     * @param orderId
     * @return
     */
    int orderDelayReceive(Long orderId);
}
