package com.coretheorylife.modules.purchaser.service.impl;

import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.purchaser.dao.TPurchaserCouponMapper;
import com.coretheorylife.modules.purchaser.dao.ext.ExtTPurchaserCouponMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserCoupon;
import com.coretheorylife.modules.purchaser.entity.TPurchaserCouponExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserCoupon;
import com.coretheorylife.modules.purchaser.service.TPurchaserCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tPurchaserCouponService")
public class TPurchaserCouponServiceImpl extends BaseServiceImpl<TPurchaserCoupon, TPurchaserCouponExample> implements TPurchaserCouponService {

    @Autowired
    private TPurchaserCouponMapper tPurchaserCouponMapper;

    @Autowired
    private ExtTPurchaserCouponMapper extTPurchaserCouponMapper;

    @Override
    public int save(TPurchaserCoupon t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tPurchaserCouponMapper.insertSelective(t);
    }

    @Override
    public int update(TPurchaserCoupon t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getPurchaserId());
        return tPurchaserCouponMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TPurchaserCoupon t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TPurchaserCoupon queryObject(Long id) {
        return tPurchaserCouponMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ExtTPurchaserCoupon> queryList(Map<String, Object> keys) {
        return extTPurchaserCouponMapper.queryList(keys);
    }

    @Override
    public List<ExtTPurchaserCoupon> queryList() {
        return extTPurchaserCouponMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTPurchaserCouponMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTPurchaserCouponMapper.queryTotal();
    }
}
