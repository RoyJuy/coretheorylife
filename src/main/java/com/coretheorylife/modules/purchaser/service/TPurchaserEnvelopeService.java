package com.coretheorylife.modules.purchaser.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.purchaser.entity.TPurchaserEnvelope;
import com.coretheorylife.modules.purchaser.entity.TPurchaserEnvelopeExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserEnvelope;

import java.util.List;
import java.util.Map;

public interface TPurchaserEnvelopeService extends BaseService<TPurchaserEnvelope, TPurchaserEnvelopeExample> {

    List<ExtTPurchaserEnvelope> queryList(Map<String, Object> keys);

    List<ExtTPurchaserEnvelope> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
