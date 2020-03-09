package com.coretheorylife.modules.purchaser.dao.ext;

import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserRate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ExtTPurchaserRateMapper {
    List<ExtTPurchaserRate> queryList(Map<String, Object> keys);

    List<ExtTPurchaserRate> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    BigDecimal selectAvgRateByShopId(Long shopId);
}
