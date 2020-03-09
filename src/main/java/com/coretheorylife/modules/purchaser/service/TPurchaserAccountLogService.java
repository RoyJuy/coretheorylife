package com.coretheorylife.modules.purchaser.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.purchaser.entity.TPurchaserAccountLog;
import com.coretheorylife.modules.purchaser.entity.TPurchaserAccountLogExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserAccountLog;

import java.util.List;
import java.util.Map;

public interface TPurchaserAccountLogService extends BaseService<TPurchaserAccountLog, TPurchaserAccountLogExample> {

    List<ExtTPurchaserAccountLog> queryList(Map<String, Object> keys);

    List<ExtTPurchaserAccountLog> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    TPurchaserAccountLog queryByOrderNo(String orderNo);

    TPurchaserAccountLog queryOrderPayByOrderId(Long orderId);
}
