package com.coretheorylife.modules.purchaser.service.impl;

import com.coretheorylife.common.annotation.ZookeeperLock;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.purchaser.dao.TPurchaserRateMapper;
import com.coretheorylife.modules.purchaser.dao.ext.ExtTPurchaserRateMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserRate;
import com.coretheorylife.modules.purchaser.entity.TPurchaserRateExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserRate;
import com.coretheorylife.modules.purchaser.service.TPurchaserRateService;
import com.coretheorylife.modules.shop.entity.TOrder;
import com.coretheorylife.modules.shop.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tPurchaserRateService")
public class TPurchaserRateServiceImpl extends BaseServiceImpl<TPurchaserRate, TPurchaserRateExample> implements TPurchaserRateService {

    @Autowired
    private TPurchaserRateMapper tPurchaserRateMapper;

    @Autowired
    private ExtTPurchaserRateMapper extTPurchaserRateMapper;

    private static final String LOCK_PREFIX = "purchaser_rate_save";

    @Autowired
    private TOrderService tOrderService;

    @Transactional(rollbackFor = Exception.class)
    @ZookeeperLock(lockPathPrefix = LOCK_PREFIX, fieldName = "orderId")
    @Override
    public int save(TPurchaserRate t) {
        tOrderService.purchaserOrderCheck(t.getOrderId(), t.getPurchaserId());
        if (getOrderHasRate(t.getOrderId())) {
            throw new InvalidParameterException("该订单已经评价过了，如果需要修改评价，请使用修改评价功能");
        }
        TOrder tOrder = tOrderService.queryObject(t.getOrderId());
        if (!tOrder.getPurchaserId().equals(t.getPurchaserId())) {
            throw new InvalidParameterException("只能评价自己的订单");
        }
        tOrder.setHasRate(true);
        tOrderService.update(tOrder);

        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tPurchaserRateMapper.insertSelective(t);
    }

    @Override
    public int update(TPurchaserRate t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getPurchaserId());
        return tPurchaserRateMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TPurchaserRate t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TPurchaserRate queryObject(Long id) {
        return tPurchaserRateMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ExtTPurchaserRate> queryList(Map<String, Object> keys) {
        return extTPurchaserRateMapper.queryList(keys);
    }

    @Override
    public List<ExtTPurchaserRate> queryList() {
        return extTPurchaserRateMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTPurchaserRateMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTPurchaserRateMapper.queryTotal();
    }

    @Override
    public BigDecimal getOrderRate(Long orderId) {
        TPurchaserRateExample example = new TPurchaserRateExample();
        TPurchaserRateExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteFlagEqualTo(false);
        criteria.andOrderIdEqualTo(orderId);
        List<TPurchaserRate> list = tPurchaserRateMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0).getRate();
    }

    @Override
    public boolean getOrderHasRate(Long orderId) {
        return getOrderRate(orderId) == null ? false : true;
    }

    @Override
    public BigDecimal selectAvgRateByShopId(Long shopId) {
        return extTPurchaserRateMapper.selectAvgRateByShopId(shopId);
    }
}
