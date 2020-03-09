package com.coretheorylife.modules.purchaser.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.purchaser.entity.TPurchaserRate;
import com.coretheorylife.modules.purchaser.entity.TPurchaserRateExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserRate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface TPurchaserRateService extends BaseService<TPurchaserRate, TPurchaserRateExample> {

    List<ExtTPurchaserRate> queryList(Map<String, Object> keys);

    List<ExtTPurchaserRate> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    /**
     * 获取订单的评价
     *
     * @param orderId
     * @return
     */
    BigDecimal getOrderRate(Long orderId);

    boolean getOrderHasRate(Long orderId);

    BigDecimal selectAvgRateByShopId(Long shopId);
}
