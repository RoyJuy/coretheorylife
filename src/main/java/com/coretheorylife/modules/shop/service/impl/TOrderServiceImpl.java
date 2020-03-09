package com.coretheorylife.modules.shop.service.impl;

import com.coretheorylife.common.annotation.ZookeeperLock;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.exception.ResourceNotExistsException;
import com.coretheorylife.common.pay.service.PayService;
import com.coretheorylife.common.rabbitmq.producer.CreateOrderDelayProducer;
import com.coretheorylife.common.rabbitmq.producer.ReceiveOrderDelayProducer;
import com.coretheorylife.common.rabbitmq.receiver.CreateOrderDelayReceiver;
import com.coretheorylife.common.rabbitmq.receiver.ReceiveOrderDelayReceiver;
import com.coretheorylife.common.sf.entity.CreateOrderQueryResult;
import com.coretheorylife.common.sf.entity.CreateOrderResult;
import com.coretheorylife.common.sf.entity.SFStatusChange;
import com.coretheorylife.common.sf.service.SFOrderService;
import com.coretheorylife.common.sf.utils.SFResultUtils;
import com.coretheorylife.common.utils.LogUtil;
import com.coretheorylife.common.utils.SnowflakeIdGenerator;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.purchaser.entity.*;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserAccountLog;
import com.coretheorylife.modules.purchaser.service.*;
import com.coretheorylife.modules.purchaser.websocket.server.PurchaserWebSocketServer;
import com.coretheorylife.modules.shop.dao.TOrderMapper;
import com.coretheorylife.modules.shop.dao.ext.ExtTOrderMapper;
import com.coretheorylife.modules.shop.entity.*;
import com.coretheorylife.modules.shop.entity.ext.*;
import com.coretheorylife.modules.shop.service.*;
import com.coretheorylife.modules.shop.websocket.server.ShopWebSocketServer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

@Service("tOrderService")
public class TOrderServiceImpl extends BaseServiceImpl<TOrder, TOrderExample> implements TOrderService {

    public static final BigDecimal USER_SHIP_FEE = new BigDecimal("5");

    public static final Integer PACKAGE_WEIGHT = 50;

    public static final String LOCK_PREFIX = "order_stock";

    public static final String LOCK_PREFIX_GOODS = "goods_month_sell";

    /**
     * 订单超时未支付的超时时间
     */
    public static int PAY_TIMEOUT = 15;

    public int getPayTimeout() {
        return PAY_TIMEOUT;
    }

    @Value("${order.payTimeout}")
    public void setPayTimeout(int payTimeout) {
        PAY_TIMEOUT = payTimeout;
    }

    /**
     * 订单超时未支付的超时时间
     */
    private static int RECEIVER_TIMEOUT = 5;

    public int getReceiverTimeout() {
        return RECEIVER_TIMEOUT;
    }

    @Value("${order.receiverTimeout}")
    public void setReceiverTimeout(int receiverTimeout) {
        RECEIVER_TIMEOUT = receiverTimeout;
    }

    @Autowired
    private TOrderLineService tOrderLineService;
    @Autowired
    private TOrderMapper tOrderMapper;
    @Autowired
    private ExtTOrderMapper extTOrderMapper;
    @Autowired
    private TGoodsService tGoodsService;
    @Autowired
    private TPurchaserCouponService tPurchaserCouponService;
    @Autowired
    private TPurchaserEnvelopeService tPurchaserEnvelopeService;
    @Autowired
    private TShopService tShopService;
    @Autowired
    private ShopWebSocketServer shopWebSocketServer;
    @Autowired
    private TGoodsSelectService tGoodsSelectService;
    @Autowired
    private PurchaserWebSocketServer purchaserWebSocketServer;
    @Autowired
    private TPurchaserAddressService tPurchaserAddressService;
    @Autowired
    private TOrderLogService tOrderLogService;
    @Autowired
    private CreateOrderDelayProducer createOrderDelayProducer;
    @Autowired
    private PayService payService;
    @Autowired
    private TPurchaserAccountLogService tPurchaserAccountLogService;
    @Autowired
    private ReceiveOrderDelayProducer receiveOrderDelayProducer;
    @Autowired
    private SFOrderService sfOrderService;
    @Autowired
    private TShopAccountService tShopAccountService;
    @Autowired
    private TShopAccountLogService tShopAccountLogService;
    @Autowired
    private TShopShipLogService tShopShipLogService;
    @Autowired
    private TPurchaserHealthLogService tPurchaserHealthLogService;
    @Autowired
    private TPurchaserHealthService tPurchaserHealthService;
    @Autowired
    private TPurchaserHealthExamService tPurchaserHealthExamService;
    @Override
    public List<ExtTOrder> queryList(Map<String, Object> keys) {
        return extTOrderMapper.queryList(keys);
    }

    @Override
    public List<ExtTOrder> queryList() {
        return extTOrderMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTOrderMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTOrderMapper.queryTotal();
    }

    @Override
    public List<ExtTOrder> queryListByShopIdOrUserId(Map<String, Object> keys) {
        return extTOrderMapper.queryListByShopIdOrUserId(keys);
    }

    @Override
    public int queryTotalByShopIdOrUserId(Map<String, Object> keys) {
        return extTOrderMapper.queryTotalByShopIdOrUserId(keys);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    @ZookeeperLock(lockPathPrefix = LOCK_PREFIX, fieldName = "shopId")
    public int createOrder(ExtTOrder t) {
        TShop tShop = tShopService.queryObject(t.getShopId());
        if (tShop == null) {
            throw new ResourceNotExistsException("店铺走丢了~");
        }
        if (tShop.getDeleteFlag() == true) {
            throw new InvalidParameterException("店铺已失效");
        } else if (tShop.getStatus() != ExtTShop.STATUS_OPEN) {
            throw new InvalidParameterException("来晚了~店铺已关闭");
        }
        if (t.getShipType() == ExtTOrder.SHIP_TYPE_TIMING && t.getShipTime() == null) {
            throw new InvalidParameterException("定时配送请写具体时间");
        }
        // 验证优惠券是否有效
        TPurchaserCoupon tShopCoupon = null;
        if (t.getPurchaserCouponId() != null) {
            tShopCoupon = tPurchaserCouponService.queryObject(t.getPurchaserCouponId());
            if (tShopCoupon == null || tShopCoupon.getDeleteFlag()) {
                throw new ResourceNotExistsException("优惠券走丢了~请重新选择");
            }
            if (tShopCoupon.getBeginTime().getTime() > new Date().getTime()) {
                throw new InvalidParameterException("你太着急了~优惠券目前不可使用");
            }
            if (tShopCoupon.getEndTime().getTime() < new Date().getTime()) {
                throw new InvalidParameterException("来晚了~优惠券已过期");
            }
            if (!tShopCoupon.getShopId().equals(t.getShopId())) {
                throw new InvalidParameterException("该优惠券不是该店铺的");
            }
            tShopCoupon.setDeleteFlag(true);
            tPurchaserCouponService.update(tShopCoupon);
        }
        // 验证红包是否可用
        TPurchaserEnvelope tUserEnvelope = null;
        if (t.getPurchaserEnvelopeId() != null) {
            tUserEnvelope = tPurchaserEnvelopeService.queryObject(t.getPurchaserEnvelopeId());
            if (tUserEnvelope == null || tUserEnvelope.getDeleteFlag()) {
                throw new ResourceNotExistsException("红包走丢了~请重新选择");
            }
            if (tUserEnvelope.getBeginTime().getTime() > new Date().getTime()) {
                throw new InvalidParameterException("你太着急了~红包目前不可使用");
            }
            if (tUserEnvelope.getEndTime().getTime() < new Date().getTime()) {
                throw new InvalidParameterException("来晚了~红包已过期");
            }
            tUserEnvelope.setDeleteFlag(true);
            tPurchaserEnvelopeService.update(tUserEnvelope);
        }
        // 先保存才会有ID返回
        save(t);
        TGoods tGoods;
        // 总价
        BigDecimal price = BigDecimal.ZERO;
        // 包装费
        BigDecimal packageFee = BigDecimal.ZERO;
        // 实付价格
        BigDecimal payPrice = BigDecimal.ZERO;
        // 满减标记
        boolean subFlag = true;
        List<ExtTGoodsSelect> tGoodsSelects;
        Long tGoodsLabelId = null;
        int chooseed = 0;
        List<OrderLineSpecificationEntity> lineSpecificationEntities;
        OrderLineSpecificationEntity orderLineSpecificationEntity;
        int weight = 0;
        boolean healthFlag = false;
        TPurchaserHealth tPurchaserHealth = tPurchaserHealthService.queryObjectByPurchaserId(t.getPurchaserId());
        if (tPurchaserHealth != null) {
            healthFlag = true;
        }
        BigDecimal allProtein = BigDecimal.ZERO;
        BigDecimal allCarbohydrate = BigDecimal.ZERO;
        BigDecimal allKacl = BigDecimal.ZERO;
        BigDecimal allAdipose = BigDecimal.ZERO;
        // 循环订单行
        for (ExtTOrderLine extTOrderLine : t.getOrderLines()) {
            lineSpecificationEntities = new ArrayList<>();
            // 查询商品的规格
            tGoodsSelects = tGoodsSelectService.queryList(extTOrderLine.getGoodsId());
            for (ExtTGoodsSelect extTGoodsSelect : tGoodsSelects) {
                // 如果循环进来那么证明有规格
                if (extTOrderLine.gettGoodsSelectIds() == null || extTOrderLine.gettGoodsSelectIds().isEmpty()) {
                    throw new InvalidParameterException("请选择规格");
                }
                // 如果需要计算健康记录 这里计算规格的蛋白质等数据
                if (healthFlag) {
                    allProtein = allProtein.add(extTGoodsSelect.getProtein());
                    allCarbohydrate = allCarbohydrate.add(extTGoodsSelect.getCarbohydrate());
                    allKacl = allKacl.add(extTGoodsSelect.getKacl());
                    allAdipose = allAdipose.add(extTGoodsSelect.getAdipose());
                }
                // 额外的重量
                weight += extTGoodsSelect.getWeight();
                // 循环每一个规格
                if (tGoodsLabelId == null) {
                    tGoodsLabelId = extTGoodsSelect.getGoodsLabelId();
                } else if (!tGoodsLabelId.equals(extTGoodsSelect.getGoodsLabelId())) {
                    // 更换完成
                    tGoodsLabelId = extTGoodsSelect.getGoodsLabelId();
                    if (chooseed == 0) {
                        throw new InvalidParameterException("请选择规格");
                    } else {
                        chooseed = 0;
                    }
                    if (extTOrderLine.gettGoodsSelectIds().contains(extTGoodsSelect.getId())) {
                        orderLineSpecificationEntity = new OrderLineSpecificationEntity();
                        orderLineSpecificationEntity.setKey(extTGoodsSelect.getTglName());
                        orderLineSpecificationEntity.setValue(extTGoodsSelect.getName());
                        lineSpecificationEntities.add(orderLineSpecificationEntity);
                        chooseed++;
                        // 这里的意思就是用户选择了某个规格 那么价格要加上规格额外的金额
                        price = price.add(extTGoodsSelect.getPrice());
                        payPrice = payPrice.add(extTGoodsSelect.getPrice());
                    }
                    continue;
                }
                // 如果用户选择了规格+1 每个规格只能选一个
                if (extTOrderLine.gettGoodsSelectIds().contains(extTGoodsSelect.getId())) {
                    orderLineSpecificationEntity = new OrderLineSpecificationEntity();
                    orderLineSpecificationEntity.setKey(extTGoodsSelect.getTglName());
                    orderLineSpecificationEntity.setValue(extTGoodsSelect.getName());
                    lineSpecificationEntities.add(orderLineSpecificationEntity);
                    chooseed++;
                    if (chooseed > 1) {
                        throw new InvalidParameterException("每个规格只能选择一个");
                    }
                    // 这里的意思就是用户选择了某个规格 那么价格要加上规格额外的金额
                    price = price.add(extTGoodsSelect.getPrice());
                    payPrice = payPrice.add(extTGoodsSelect.getPrice());
                }
            }
            if (tGoodsSelects.size() > 0 && chooseed == 0) {
                throw new InvalidParameterException("请选择正确的规格");
            }
            extTOrderLine.setSpecification(new Gson().toJson(lineSpecificationEntities));
            tGoods = tGoodsService.queryObject(extTOrderLine.getGoodsId());
            if (tGoods == null) {
                throw new ResourceNotExistsException("商品不存在");
            }
            if (tGoods.getNowStock() < extTOrderLine.getNumber()) {
                throw new InvalidParameterException(tGoods.getName() + "库存不足，订单创建失败");
            }
            weight += tGoods.getWeight();
            tGoods.setNowStock(tGoods.getNowStock() - extTOrderLine.getNumber());
            if (tGoods.getId() != null && extTOrderLine.getNumber() > 0) {
                int i = tGoodsService.subStock(tGoods.getId(), extTOrderLine.getNumber());
                if (i == 0) {
                    throw new InvalidParameterException(tGoods.getName() + "库存不足，订单创建失败");
                }
            }
            if (extTOrderLine.getNumber() < tGoods.getMinBuy()) {
                throw new InvalidParameterException("小于该商品的最小购买量");
            }
            if (tGoods.getStatus() != ExtTGoods.STATUS_SHELF) {
                throw new ResourceNotExistsException(tGoods.getName() + "商品已下架，请重新下单");
            }
            if (healthFlag) {
                allProtein = allProtein.add(tGoods.getProtein());
                allCarbohydrate = allCarbohydrate.add(tGoods.getCarbohydrate());
                allKacl = allKacl.add(tGoods.getKacl());
                allAdipose = allAdipose.add(tGoods.getAdipose());
            }
            // 计算商品价格
            if (tGoods.getDiscountRate().compareTo(BigDecimal.ONE) == -1) {
                subFlag = false;
                // 这个商品打折了
                extTOrderLine.setDiscountRate(tGoods.getDiscountRate());
                // 如果商品的数量大于最小折扣数量，那么超出部分需要单独计算不打折的价格，并且后续无法计算满减
                if (extTOrderLine.getNumber() <= tGoods.getMaxDiscount()) {
                    // 如果没超过 全部按照折扣价格算 那么折扣数量就是订单行的数量
                    extTOrderLine.setDiscountNumber(extTOrderLine.getNumber());
                    payPrice = payPrice.add(new BigDecimal(new DecimalFormat("#.00").format(tGoods.getDiscountRate().multiply(tGoods.getPrice().multiply(new BigDecimal(extTOrderLine.getNumber()))))));
                } else {
                    // 如果超过了。那么就是最大折扣数量
                    // 价格分为两部分，打折部分，和不打折部分
                    extTOrderLine.setDiscountNumber(tGoods.getMaxDiscount());
                    payPrice = payPrice.add(new BigDecimal(new DecimalFormat("#.00").format(tGoods.getPrice().multiply(new BigDecimal(tGoods.getMaxDiscount())).multiply(tGoods.getDiscountRate()))));
                    payPrice = payPrice.add(tGoods.getPrice().multiply(new BigDecimal(extTOrderLine.getNumber() - tGoods.getMaxDiscount())));
                }
            } else {
                payPrice = payPrice.add(tGoods.getPrice().multiply(new BigDecimal(extTOrderLine.getNumber())));
            }
            // 计算包装费用
            packageFee = packageFee.add(tGoods.getPackageFee().multiply(new BigDecimal(extTOrderLine.getNumber())));
            price = price.add(tGoods.getPrice().multiply(new BigDecimal(extTOrderLine.getNumber())));
            extTOrderLine.setOrderId(t.getId());
            tOrderLineService.save(extTOrderLine);

            addGoodsMonthSell(extTOrderLine.getGoodsId(), extTOrderLine.getNumber());
        }
        // 记录用户饮食记录
        TPurchaserHealthLog tPurchaserHealthLog = tPurchaserHealthLogService.queryByTime(null, t.getPurchaserId(), false);
        // 先查到当天用户的记录，然后直接在这个基础上更新即可
        tPurchaserHealthLog.setId(null);
        tPurchaserHealthLog.setProtein(allProtein);
        tPurchaserHealthLog.setCarbohydrate(allCarbohydrate);
        tPurchaserHealthLog.setAdipose(allAdipose);
        tPurchaserHealthLog.setKacl(allKacl);
        tPurchaserHealthLog.setAllDayAdipose(tPurchaserHealthLog.getAllDayAdipose().add(allAdipose));
        tPurchaserHealthLog.setAllDayKacl(tPurchaserHealthLog.getAllDayKacl().add(allKacl));
        tPurchaserHealthLog.setAllDayCarbohydrate(tPurchaserHealthLog.getAllDayCarbohydrate().add(allCarbohydrate));
        tPurchaserHealthLog.setAllDayProtein(tPurchaserHealthLog.getAllDayProtein().add(allProtein));
        BigDecimal kcl = BigDecimal.ZERO;
        tPurchaserHealthLog.setPurchaserId(t.getPurchaserId());
        tPurchaserHealthLog.setLogTime(new Date());
        tPurchaserHealthLog.setOrderId(t.getId());
        // 标准重新设置
        if (healthFlag) {
            if (tPurchaserHealth.getExamer()) {
                // 是体测用户
                TPurchaserHealthExam tPurchaserHealthExam = tPurchaserHealthExamService.queryObjectByPurchaserId(t.getPurchaserId());
                tPurchaserHealthLog.setAllProtein(tPurchaserHealthExam.getProteinNeed());
                tPurchaserHealthLog.setAllCarbohydrate(tPurchaserHealthExam.getCarbohydrateNeed());
                tPurchaserHealthLog.setAllAdipose(tPurchaserHealthExam.getAdiposeNeed());
                kcl = kcl.add(tPurchaserHealthExam.getProteinNeed().multiply(new BigDecimal("4")));
                kcl = kcl.add(tPurchaserHealthExam.getCarbohydrateNeed().multiply(new BigDecimal("4")));
                kcl = kcl.add(tPurchaserHealthExam.getAdiposeNeed().multiply(new BigDecimal("9")));
                tPurchaserHealthLog.setAllKacl(kcl);
            } else {
                tPurchaserHealthLog.setAllProtein(tPurchaserHealth.getProteinNeed());
                tPurchaserHealthLog.setAllCarbohydrate(tPurchaserHealth.getCarbohydrateNeed());
                tPurchaserHealthLog.setAllAdipose(tPurchaserHealth.getFatNeed());
                kcl = kcl.add(tPurchaserHealth.getProteinNeed().multiply(new BigDecimal("4")));
                kcl = kcl.add(tPurchaserHealth.getCarbohydrateNeed().multiply(new BigDecimal("4")));
                kcl = kcl.add(tPurchaserHealth.getFatNeed().multiply(new BigDecimal("9")));
                tPurchaserHealthLog.setAllKacl(kcl);
            }
        } else {
            tPurchaserHealthLog.setAllProtein(BigDecimal.ZERO);
            tPurchaserHealthLog.setAllCarbohydrate(BigDecimal.ZERO);
            tPurchaserHealthLog.setAllAdipose(BigDecimal.ZERO);
            tPurchaserHealthLog.setAllKacl(BigDecimal.ZERO);
        }
        tPurchaserHealthLogService.save(tPurchaserHealthLog);
        if (tShop.getMinPrice().compareTo(BigDecimal.ZERO) == 1) {
            if (payPrice.compareTo(tShop.getMinPrice()) == -1) {
                throw new InvalidParameterException("未达到店铺起送价格");
            }
        }
        // 包装无条件增加50克
        weight += PACKAGE_WEIGHT;
        if (weight > 3000) {
            throw new InvalidParameterException("您的商品超重啦，请分多次购买~");
        }

        FullReductionEntity nowReduction = null;
        LinkedList<FullReductionEntity> fullReductionEntities = null;

        if (tShopCoupon != null) {
            // 如果使用了优惠券
            // 实际支付减去优惠券
            payPrice = payPrice.subtract(tShopCoupon.getAmount());
            // 和满减互斥
            if (!tShopCoupon.getShared()) {
                subFlag = false;
            }
        }
        if (tUserEnvelope != null) {
            // 如果使用了红包 红包无条件减去金额
            payPrice = payPrice.subtract(tUserEnvelope.getAmount());
        }
        if (subFlag) {
            if (tShop.getFullReduction() == null || "".equals(tShop.getFullReduction())) {
                // 没有满减优惠
            } else {
                fullReductionEntities = new Gson().fromJson(tShop.getFullReduction(), new TypeToken<LinkedList<FullReductionEntity>>() {
                }.getType());
                for (FullReductionEntity fullReductionEntity : fullReductionEntities) {
                    if (fullReductionEntity.getFull().compareTo(price) <= 0) {
                        // 如果满减第一梯队小于price
                        if (nowReduction != null) {
                            nowReduction.setFlag(false);
                        }
                        nowReduction = fullReductionEntity;
                        nowReduction.setFlag(true);
                    } else {
                        break;
                    }
                }
                if (nowReduction != null) {
                    // 这里计算满减的金额
                    payPrice = payPrice.subtract(nowReduction.getSub());
                }
            }
        }
        TPurchaserAddress tPurchaserAddress = tPurchaserAddressService.queryObject(t.getPurchaserAddressId());
        if (tPurchaserAddress == null) {
            throw new InvalidParameterException("地址不存在");
        }
        // 配送费
        // 配送方式
        if (tShop.getShipSelf()) {
            t.setShipFee(tShop.getShopShipFee());
            t.setShipPlatform(ExtTOrder.SHIP_TYPE_SHOP_SELF);
        } else {
            CreateOrderQueryResult createOrderResult = sfOrderService.createOrderQuery(t.getShipPrefix() + t.getShipSuffix(), tPurchaserAddress.getLongitude(), tPurchaserAddress.getLatitude(), weight, t.getShipType() == ExtTOrder.SHIP_TYPE_NOW ? 0 : 1, (int) t.getShipTime().getTime() / 1000, tShop.getName(), tShop.getOrderPhone(), tShop.getAddress() + tShop.getAddressDetailes(), tShop.getLongitude(), tShop.getLatitude());
            if (createOrderResult == null) {
                throw new ResourceNotExistsException("配送服务器出小差了~");
            }
            if (createOrderResult.getError_code() != 0) {
                String resStr = SFResultUtils.getMsgByCode(createOrderResult.getError_code());
                throw new ResourceNotExistsException(resStr);
            }
            t.setShipFee(new BigDecimal(createOrderResult.getResult().getCharge_price_list().getShop_pay_price()).divide(new BigDecimal("100")));
            t.setShipPlatform(ExtTOrder.SHIP_TYPE_SF);
        }
        // 用户固定5，总价是顺丰返回的总价
        payPrice = payPrice.add(packageFee).add(TOrderServiceImpl.USER_SHIP_FEE);
        // 总价不包含用户支付配送费
        price = price.add(packageFee);
        if (t.getPrice().compareTo(price) != 0) {
            throw new InvalidParameterException("商品价格发生变化，请重新下单");
        }
        if (t.getPayPrice().compareTo(payPrice) != 0) {
            throw new InvalidParameterException("优惠信息发生变化，请重新下单");
        }
        if (payPrice.compareTo(BigDecimal.ZERO) == -1) {
            // 如果需要支付的金额小于0
            payPrice = BigDecimal.ZERO;
            // 粗大事了，免单了
        }
        t.setPrice(price);
        t.setOrderTime(new Date());
        SnowflakeIdGenerator idWorker = new SnowflakeIdGenerator(10, 20);
        t.setOrderNo(idWorker.nextId() + "");
        t.setPayPrice(payPrice);
        t.setPackageFee(packageFee);
        t.setDiscountFee(nowReduction == null ? BigDecimal.ZERO : nowReduction.getSub());
        t.setDiscountDescription(fullReductionEntities == null ? "[]" : new Gson().toJson(fullReductionEntities));
        t.setShipPrefix(tPurchaserAddress.getAddressPrefix());
        t.setShipSuffix(tPurchaserAddress.getAddressSuffix());
        t.setShipLongitude(tPurchaserAddress.getLongitude());
        t.setShipLatitude(tPurchaserAddress.getLatitude());
        t.setReceiverName(tPurchaserAddress.getNickName());
        t.setReceiverMobile(tPurchaserAddress.getMobile());
        t.setOrderCount(tOrderLogService.queryCountByShopId(t.getShopId()));
        t.setPayTimeout(getPayTimeout());
        t.setReceiverTimeout(getReceiverTimeout());
        t.setSendShipFee(tShop.getSendShipFee());
        t.setShopShipFee(tShop.getShopShipFee());
        t.setShipSelf(tShop.getShipSelf());
        t.setWeight(weight);
        update(t);
        TOrderLog tOrderLog = new TOrderLog();
        tOrderLog.setBeforeShipStatus(ExtTOrder.SHIP_STATUS_WAIT_ORDER);
        tOrderLog.setNowShipStatus(ExtTOrder.SHIP_STATUS_WAIT_ORDER);
        tOrderLog.setBeforeStatus(ExtTOrder.STATUS_WAIT_PAY);
        tOrderLog.setNowStatus(ExtTOrder.STATUS_WAIT_PAY);
        tOrderLog.setDescription("用户下单");
        tOrderLog.setCode(ExtTOrderLog.CREATE_ORDER);
        tOrderLog.setShopId(t.getShopId());
        tOrderLog.setPurchaserId(t.getPurchaserId());
        tOrderLog.setOrderId(t.getId());
        tOrderLog.setCreateOrderFlag(true);
        tOrderLogService.save(tOrderLog);
        createOrderDelayProducer.send(t.getId().toString(), getPayTimeout() * 60 * 1000);
        return 1;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int cancelOrder(Long orderId, Long purchaserId, String description) {
        purchaserOrderCheck(orderId, purchaserId);
        TOrder tOrder = queryObject(orderId);
        TOrderLog tOrderLog = new TOrderLog();
        boolean pay = false;
        if (tOrder.getStatus() == ExtTOrder.STATUS_WAIT_PAY) {
            tOrderLog.setNowStatus(ExtTOrder.STATUS_PURCHASER_CANCEL);
        } else {
            pay = true;
            tOrderLog.setNowStatus(ExtTOrder.STATUS_PURCHASER_CANCEL_AFTER_PAY);
        }
        if (tOrder.getStatus() != ExtTOrder.STATUS_PAY_SUCCESS) {
            throw new InvalidParameterException("订单已经在制作中或已完成，如有疑问请致电商家");
        }
        tOrderLog.setBeforeShipStatus(tOrder.getShipStatus());
        tOrderLog.setNowShipStatus(tOrder.getShipStatus());
        tOrderLog.setBeforeStatus(tOrder.getStatus());
        tOrderLog.setDescription("用户取消订单");
        tOrderLog.setCode(ExtTOrderLog.CANCEL_ORDER);
        tOrderLog.setShopId(tOrder.getShopId());
        tOrderLog.setPurchaserId(tOrder.getPurchaserId());
        tOrderLog.setOrderId(tOrder.getId());
        tOrderLog.setCreateOrderFlag(false);
        tOrderLogService.save(tOrderLog);
        tOrder.setStatus(tOrderLog.getNowStatus());
        // 退还用户的优惠券
        returnDiscount(orderId);
        if (pay) {
            returnMoney(orderId);
            // 是支付过的订单才推送
            shopWebSocketServer.sendCancelOrder(tOrder.getShopId(), orderId);
        }
        // 返还库存
        tGoodsService.returnStock(orderId);
        discountGoodsMonthSell(orderId);
        // 删除饮食记录
        tPurchaserHealthLogService.deleteByOrderId(orderId);
        return update(tOrder);
    }

    @Override
    public long getShopIdByOrder(Long orderId) {
        TOrder tOrder = queryObject(orderId);
        if (tOrder == null) {
            throw new InvalidParameterException("店铺走丢了~");
        }
        return tOrder.getShopId();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int receiveOrder(Long orderId, Long shopId) {
        shopOrderCheck(orderId, shopId);
        TOrder tOrder = queryObject(orderId);
        if (tOrder.getStatus() != ExtTOrder.STATUS_PAY_SUCCESS) {
            throw new InvalidParameterException("已接单或订单已取消");
        }
        TOrderLog tOrderLog = new TOrderLog();
        tOrderLog.setBeforeShipStatus(tOrder.getShipStatus());
        tOrderLog.setNowShipStatus(ExtTOrder.SHIP_STATUS_IN_ORDER);
        tOrderLog.setBeforeStatus(tOrder.getStatus());
        tOrderLog.setNowStatus(ExtTOrder.STATUS_IN_ORDER);
        tOrderLog.setDescription("商家接单");
        tOrderLog.setCode(ExtTOrderLog.RECEIVE_ORDER);
        tOrderLog.setShopId(tOrder.getShopId());
        tOrderLog.setPurchaserId(tOrder.getPurchaserId());
        tOrderLog.setOrderId(tOrder.getId());
        tOrderLog.setCreateOrderFlag(false);
        tOrderLogService.save(tOrderLog);

        tOrder.setStatus(ExtTOrder.STATUS_IN_ORDER);
        tOrder.setShipStatus(ExtTOrder.SHIP_STATUS_IN_ORDER);

        TShop tShop = tShopService.queryObject(tOrder.getShopId());
        CreateOrderResult createOrderResult = sfOrderService.createOrder(tOrder, tShop);
        if (createOrderResult == null) {
            throw new ResourceNotExistsException("配送服务器出小差了~");
        }
        if (createOrderResult.getError_code() != 0) {
            String resStr = SFResultUtils.getMsgByCode(createOrderResult.getError_code());
            throw new ResourceNotExistsException(resStr);
        }
        // SF 距离 单号更新
        tOrder.setSfOrderId(createOrderResult.getResult().getSf_order_id());
        tOrder.setShipDistance(createOrderResult.getResult().getDelivery_distance_meter());
        tOrder.setShipFee(new BigDecimal(createOrderResult.getResult().getReal_pay_money()).divide(new BigDecimal("100")));
        tOrder.setShipPlatform(ExtTOrder.SHIP_TYPE_SF);

        // 保存顺丰配送日志
        TShopShipLog tShopShipLog = new TShopShipLog();
        tShopShipLog.setShopId(tOrder.getShopId());
        tShopShipLog.setOrderId(tOrder.getId());
        tShopShipLog.setShopOrderId(tOrder.getOrderNo());
        tShopShipLog.setSfOrderId(createOrderResult.getResult().getSf_order_id());
        tShopShipLog.setSfBillId(createOrderResult.getResult().getSf_bill_id());
        tShopShipLog.setPushTime(createOrderResult.getResult().getPush_time());
        tShopShipLog.setTotalPrice(new BigDecimal(createOrderResult.getResult().getTotal_price()).divide(new BigDecimal("100")));
        tShopShipLog.setDeliveryDistanceMeter(new BigDecimal(createOrderResult.getResult().getDelivery_distance_meter()));
        tShopShipLog.setWeightGram(createOrderResult.getResult().getWeight_gram());
        tShopShipLog.setStartTime(createOrderResult.getResult().getStart_time());
        tShopShipLog.setExpectTime(createOrderResult.getResult().getExpect_time());
        tShopShipLog.setTotalPayMoney(new BigDecimal(createOrderResult.getResult().getTotal_pay_money()).divide(new BigDecimal("100")));
        tShopShipLog.setRealPayMoney(new BigDecimal(createOrderResult.getResult().getReal_pay_money()).divide(new BigDecimal("100")));
        tShopShipLog.setCouponsTotalFee(new BigDecimal(createOrderResult.getResult().getCoupons_total_fee()).divide(new BigDecimal("100")));
        tShopShipLog.setSettlementType(createOrderResult.getResult().getSettlement_type());
        tShopShipLogService.save(tShopShipLog);

        purchaserWebSocketServer.sendReceiveOrder(orderId, tOrder.getPurchaserId());
        return update(tOrder);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int rejectOrder(Long orderId, Long shopId) {
        shopOrderCheck(orderId, shopId);
        TOrder tOrder = queryObject(orderId);
        if (tOrder.getStatus() != ExtTOrder.STATUS_PAY_SUCCESS) {
            throw new InvalidParameterException("已接单或订单已取消");
        }

        TOrderLog tOrderLog = new TOrderLog();
        tOrderLog.setBeforeShipStatus(tOrder.getShipStatus());
        tOrderLog.setNowShipStatus(tOrder.getShipStatus());
        tOrderLog.setBeforeStatus(tOrder.getStatus());
        tOrderLog.setNowStatus(ExtTOrder.STATUS_SHOP_CANCEL);
        tOrderLog.setDescription("商家拒绝订单");
        tOrderLog.setCode(ExtTOrderLog.REJECT_ORDER);
        tOrderLog.setShopId(tOrder.getShopId());
        tOrderLog.setPurchaserId(tOrder.getPurchaserId());
        tOrderLog.setOrderId(tOrder.getId());
        tOrderLog.setCreateOrderFlag(false);
        tOrderLogService.save(tOrderLog);
        tOrder.setStatus(ExtTOrder.STATUS_SHOP_CANCEL);
        // 退还用户的优惠券
        returnDiscount(orderId);
        purchaserWebSocketServer.sendRejectOrder(orderId, tOrder.getPurchaserId());
        returnMoney(orderId);
        // 返还库存
        tGoodsService.returnStock(orderId);
        // 删除月售
        discountGoodsMonthSell(orderId);
        // 删除饮食记录
        tPurchaserHealthLogService.deleteByOrderId(orderId);
        return update(tOrder);
    }

    @Override
    public void purchaserOrderCheck(Long orderId, Long purchaserId) {
        TOrder tOrder = queryObject(orderId);
        if (tOrder == null) {
            throw new ResourceNotExistsException("找不到指定的订单");
        }
        if (!tOrder.getPurchaserId().equals(purchaserId)) {
            throw new InvalidParameterException("只能操作自己的订单");
        }
    }

    @Override
    public void shopOrderCheck(Long orderId, Long shopId) {
        TOrder tOrder = queryObject(orderId);
        if (tOrder == null) {
            throw new ResourceNotExistsException("找不到指定的订单");
        }
        if (!tOrder.getShopId().equals(shopId)) {
            throw new InvalidParameterException("只能操作自己的订单");
        }
    }

    @Override
    public void returnDiscount(Long orderId) {
        TOrder tOrder = queryObject(orderId);
        if (tOrder == null) {
            return;
        }
        if (tOrder.getPurchaserCouponId() != null) {
            TPurchaserCoupon tPurchaserCoupon = tPurchaserCouponService.queryObject(tOrder.getPurchaserCouponId());
            if (tPurchaserCoupon != null) {
                tPurchaserCoupon.setDeleteFlag(false);
                tPurchaserCouponService.update(tPurchaserCoupon);
            }
        }
        if (tOrder.getPurchaserEnvelopeId() != null) {
            TPurchaserEnvelope tPurchaserEnvelope = tPurchaserEnvelopeService.queryObject(tOrder.getPurchaserEnvelopeId());
            {
                if (tPurchaserEnvelope != null) {
                    tPurchaserEnvelope.setDeleteFlag(false);
                    tPurchaserEnvelopeService.update(tPurchaserEnvelope);
                }
            }
        }

    }

    @Override
    public void returnMoney(Long orderId) {
        // TODO 退款
    }

    @ZookeeperLock(lockPathPrefix = LOCK_PREFIX_GOODS)
    @Override
    public void addGoodsMonthSell(Long goodsId, int number) {
        TGoods tGoods = tGoodsService.queryObject(goodsId);
        tGoods.setMonthSell(tGoods.getMonthSell() + number);
        tGoodsService.update(tGoods);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void discountGoodsMonthSell(Long orderId) {
        List<TOrderLine> list = tOrderLineService.queryListByOrderId(orderId);
        for (TOrderLine tOrderLine : list) {
            if (tOrderLine.getGoodsId() != null && tOrderLine.getNumber() > 0) {
                discountGoodsMonthSell(tOrderLine.getGoodsId(), tOrderLine.getNumber());
            }
        }
    }

    @ZookeeperLock(lockPathPrefix = LOCK_PREFIX_GOODS)
    @Override
    public void discountGoodsMonthSell(Long goodsId, int number) {
        TGoods tGoods = tGoodsService.queryObject(goodsId);
        tGoods.setMonthSell(tGoods.getMonthSell() - number);
        tGoodsService.update(tGoods);
    }

    @Override
    public Map<String, Object> unifiedOrder(String payType, Long purchaserId, Long orderId) {
        return payService.unifiedOrder(payType, purchaserId, orderId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void paySuccess(String outTradeNo, String tradeNo) {
        TPurchaserAccountLog tPurchaserAccountLog = tPurchaserAccountLogService.queryByOrderNo(outTradeNo);
        if (tPurchaserAccountLog == null) {
            // 记录错误
        } else {
            // 日志变成已审核
            tPurchaserAccountLog.setStatus(ExtTPurchaserAccountLog.STATUS_SUCCESS);
            tPurchaserAccountLog.setPrepayId(tradeNo);
            tPurchaserAccountLogService.update(tPurchaserAccountLog);
            // 订单更改状态
            TOrder tOrder = queryObject(tPurchaserAccountLog.getOrderId());
            TShop tShop = tShopService.queryObject(tOrder.getShopId());
            if (tShop.getAutoReceive()) {
                // 商家自动接单
                receiveOrder(tOrder.getId(), tOrder.getShopId());
            }
            tOrder.setStatus(ExtTOrder.STATUS_PAY_SUCCESS);
            update(tOrder);
            // 接单开始计时
            receiveOrderDelayProducer.send(tOrder.getId() + "", tOrder.getReceiverTimeout());
            // 推送订单状态
            shopWebSocketServer.sendNewOrder(tOrder.getShopId(), tOrder.getOrderCount() + "");
        }
    }

    @Override
    public void changeStatus(SFStatusChange sfStatusChange) {
        TOrder tOrder = queryObjectByOrderNo(sfStatusChange.getShop_order_id());
        TOrderLog tOrderLog = new TOrderLog();
        tOrderLog.setBeforeShipStatus(tOrder.getShipStatus());
        tOrderLog.setBeforeStatus(tOrder.getStatus());
        tOrderLog.setDescription("订单状态改变");
        tOrderLog.setCode(ExtTOrderLog.ORDER_STATUS_CHANGE);
        tOrderLog.setShopId(tOrder.getShopId());
        tOrderLog.setPurchaserId(tOrder.getPurchaserId());
        tOrderLog.setOrderId(tOrder.getId());
        tOrderLog.setCreateOrderFlag(false);
        // 2:订单取消 10-配送员确认;12:配送员到店;15:配送员配送中 17配送员点击完成
        switch (sfStatusChange.getOrder_status()) {
            case "2":
                // TODO 客服介入
                tOrder.setShipStatus(ExtTOrder.SHIP_STATUS_EXCEPTION);
                tOrder.setStatus(ExtTOrder.STATUS_WAITING_OTHER_SHIP);
                tOrderLog.setNowShipStatus(ExtTOrder.SHIP_STATUS_EXCEPTION);
                tOrderLog.setNowStatus(ExtTOrder.STATUS_WAITING_OTHER_SHIP);
                break;
            case "10":
                tOrder.setShipPerson(sfStatusChange.getOperator_name());
                tOrder.setShipNumber(sfStatusChange.getOperator_phone());
                tOrder.setShipStatus(ExtTOrder.SHIP_STATUS_ASSIGNED_DELIVERY_PERSON);
                tOrder.setStatus(ExtTOrder.STATUS_IN_ORDER);
                tOrderLog.setNowShipStatus(ExtTOrder.SHIP_STATUS_ASSIGNED_DELIVERY_PERSON);
                tOrderLog.setNowStatus(ExtTOrder.STATUS_IN_ORDER);
                break;
            case "12":
                tOrder.setShipStatus(ExtTOrder.SHIP_STATUS_IN_SHOP);
                tOrder.setStatus(ExtTOrder.STATUS_IN_ORDER);
                tOrderLog.setNowShipStatus(ExtTOrder.SHIP_STATUS_IN_SHOP);
                tOrderLog.setNowStatus(ExtTOrder.STATUS_IN_ORDER);
                break;
            case "15":
                tOrder.setShipStatus(ExtTOrder.SHIP_STATUS_IN_SEND);
                tOrder.setStatus(ExtTOrder.STATUS_IN_ORDER);
                tOrderLog.setNowShipStatus(ExtTOrder.SHIP_STATUS_IN_SEND);
                tOrderLog.setNowStatus(ExtTOrder.STATUS_IN_ORDER);
                break;
            case "17":
                tOrder.setShipStatus(ExtTOrder.SHIP_STATUS_SEND);
                tOrder.setStatus(ExtTOrder.STATUS_SUCCESS);
                tOrderLog.setNowShipStatus(ExtTOrder.SHIP_STATUS_SEND);
                tOrderLog.setNowStatus(ExtTOrder.STATUS_SUCCESS);
                // 订单结算
                // 订单总价 100 满100减60  用户支付金额为40 + 5 配送距离为4KM，那么平台提成为15块，给顺丰7块，商家的收入为40 - 15 = 25
                BigDecimal rate = new BigDecimal("0.1");
                if (tOrder.getShipDistance() > 3000) {
                    // 如果大于3000米是15%的抽成
                    rate = new BigDecimal("0.15");
                }
                BigDecimal sysMoney = tOrder.getPrice().multiply(rate);
                // 商家的钱 等于 已支付 减去 系统抽成
                BigDecimal shopMoney = tOrder.getPayPrice().subtract(TOrderServiceImpl.USER_SHIP_FEE).subtract(sysMoney);
                TShopAccount tShopAccount = tShopAccountService.initAccount(tOrder.getShopId());
                TShopAccountLog tShopAccountLog = new TShopAccountLog();
                tShopAccountLog.setShopId(tOrder.getShopId());
                tShopAccountLog.setType(ExtTShopAccountLog.TYPE_SETTLEMENT);
                tShopAccountLog.setAmount(BigDecimal.ZERO);
                tShopAccountLog.setNotSettleAmount(shopMoney);
                tShopAccountLog.setAmountAfter(tShopAccount.getAmount());
                tShopAccountLog.setNotSettleAmountAfter(tShopAccount.getNotSettleAmount().add(shopMoney));
                tShopAccountLog.setSfOrderId(tOrder.getSfOrderId());
                tShopAccountLog.setShipDistance(tOrder.getShipDistance());
                tShopAccountLog.setSysAmount(sysMoney);
                tShopAccountLogService.save(tShopAccountLog);
                break;
        }
        update(tOrder);
        tOrderLogService.save(tOrderLog);
        shopWebSocketServer.sendOrderStatusChange(tOrder.getShopId(), tOrder.getId(), tOrderLog.getBeforeStatus(), tOrderLog.getNowStatus(), tOrderLog.getBeforeShipStatus(), tOrderLog.getNowShipStatus());
    }

    @Override
    public TOrder queryObjectByOrderNo(String orderNo) {
        TOrderExample example = new TOrderExample();
        TOrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        List<TOrder> list = tOrderMapper.selectByExample(example);
        return list.get(0);
    }

    @Override
    public int orderDelayPay(Long orderId) {
        TOrder tOrder = queryObject(orderId);
        if (tOrder.getStatus() == ExtTOrder.STATUS_WAIT_PAY) {
            // 如果超出时间了还是待付款，那么取消订单
            tOrder.setStatus(ExtTOrder.STATUS_PURCHASER_CANCEL);
            tOrder.setShipStatus(ExtTOrder.SHIP_STATUS_CANCEL);
            update(tOrder);
            // 退还用户的优惠券
            returnDiscount(tOrder.getId());

            TOrderLog tOrderLog = new TOrderLog();
            tOrderLog.setBeforeShipStatus(tOrder.getShipStatus());
            tOrderLog.setNowShipStatus(ExtTOrder.SHIP_STATUS_CANCEL);
            tOrderLog.setBeforeStatus(tOrder.getStatus());
            tOrderLog.setNowStatus(ExtTOrder.STATUS_PURCHASER_CANCEL);
            tOrderLog.setDescription("订单超时取消");
            tOrderLog.setCode(ExtTOrderLog.PAY_TIME_OUT);
            tOrderLog.setShopId(tOrder.getShopId());
            tOrderLog.setPurchaserId(tOrder.getPurchaserId());
            tOrderLog.setOrderId(tOrder.getId());
            tOrderLog.setCreateOrderFlag(false);
            tOrderLogService.save(tOrderLog);
            LogUtil.debug(CreateOrderDelayReceiver.class, "订单超时被自动取消");
            // 删除饮食记录
            tPurchaserHealthLogService.deleteByOrderId(orderId);
        }
        return 1;
    }

    @Override
    public int orderDelayReceive(Long orderId) {
        TOrder tOrder = queryObject(orderId);
        if (tOrder.getStatus() == ExtTOrder.STATUS_WAIT_PAY) {
            // 如果超出时间了还是待付款，那么取消订单
            tOrder.setStatus(ExtTOrder.STATUS_PURCHASER_CANCEL_AFTER_PAY);
            tOrder.setShipStatus(ExtTOrder.SHIP_STATUS_CANCEL);
            update(tOrder);
            // 退还用户的优惠券
            returnDiscount(tOrder.getId());

            TOrderLog tOrderLog = new TOrderLog();
            tOrderLog.setBeforeShipStatus(tOrder.getShipStatus());
            tOrderLog.setNowShipStatus(ExtTOrder.SHIP_STATUS_CANCEL);
            tOrderLog.setBeforeStatus(tOrder.getStatus());
            tOrderLog.setNowStatus(ExtTOrder.STATUS_PURCHASER_CANCEL_AFTER_PAY);
            tOrderLog.setDescription("订单超时未接单取消");
            tOrderLog.setCode(ExtTOrderLog.PAY_TIME_OUT_AFTER_PAY);
            tOrderLog.setShopId(tOrder.getShopId());
            tOrderLog.setPurchaserId(tOrder.getPurchaserId());
            tOrderLog.setOrderId(tOrder.getId());
            tOrderLog.setCreateOrderFlag(false);
            tOrderLogService.save(tOrderLog);
            LogUtil.debug(ReceiveOrderDelayReceiver.class, "订单超时未接单取消");
            // 删除饮食记录
            tPurchaserHealthLogService.deleteByOrderId(orderId);
            returnMoney(orderId);
        }
        return 1;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int urgeOrder(Long orderId, Long purchaserId) {
        purchaserOrderCheck(orderId, purchaserId);
        TOrder tOrder = queryObject(orderId);
        if (tOrder.getUpdateTime() != null && new Date().getTime() - tOrder.getUpdateTime().getTime() < 5 * 60 * 1000) {
            throw new InvalidParameterException("五分钟内不能重复催单");
        }
        if (tOrder.getStatus() == ExtTOrder.STATUS_PAY_SUCCESS) {
            return 1;
        }
        if (tOrder.getStatus() == ExtTOrder.STATUS_MAKE_DONE) {
            throw new InvalidParameterException("商品已经在配送中了，请耐心等待，如果有问题，请联系骑手");
        }
        if (tOrder.getStatus() == ExtTOrder.STATUS_IN_ORDER) {
            tOrder.setUrgeFlag(true);
            tOrder.setUrgeTime(new Date());
        }
        shopWebSocketServer.sendUrgeOrder(tOrder.getShopId(), orderId);
        TOrderLog tOrderLog = new TOrderLog();
        tOrderLog.setBeforeShipStatus(tOrder.getShipStatus());
        tOrderLog.setNowShipStatus(tOrder.getShipStatus());
        tOrderLog.setBeforeStatus(tOrder.getStatus());
        tOrderLog.setNowStatus(tOrder.getStatus());
        tOrderLog.setDescription("用户催单");
        tOrderLog.setCode(ExtTOrderLog.URGE_ORDER);
        tOrderLog.setShopId(tOrder.getShopId());
        tOrderLog.setPurchaserId(tOrder.getPurchaserId());
        tOrderLog.setOrderId(tOrder.getId());
        tOrderLog.setCreateOrderFlag(false);
        tOrderLogService.save(tOrderLog);
        return update(tOrder);
    }

    @Override
    public int save(TOrder t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return extTOrderMapper.insertSelective(t);
    }

    @Override
    public int update(TOrder t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getShopId());
        return tOrderMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TOrder t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TOrder queryObject(Long id) {
        return tOrderMapper.selectByPrimaryKey(id);
    }
}
