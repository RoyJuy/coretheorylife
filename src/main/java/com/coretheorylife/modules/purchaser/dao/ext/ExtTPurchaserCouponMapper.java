package com.coretheorylife.modules.purchaser.dao.ext;

import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserCoupon;

import java.util.List;
import java.util.Map;

public interface ExtTPurchaserCouponMapper {

    List<ExtTPurchaserCoupon> queryList(Map<String, Object> keys);

    List<ExtTPurchaserCoupon> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
