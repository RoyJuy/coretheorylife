package com.coretheorylife.modules.purchaser.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.purchaser.entity.TPurchaserCoupon;
import com.coretheorylife.modules.purchaser.entity.TPurchaserCouponExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserCoupon;

import java.util.List;
import java.util.Map;


public interface TPurchaserCouponService extends BaseService<TPurchaserCoupon, TPurchaserCouponExample> {

    List<ExtTPurchaserCoupon> queryList(Map<String, Object> keys);

    List<ExtTPurchaserCoupon> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
