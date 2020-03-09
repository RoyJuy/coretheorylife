package com.coretheorylife.modules.purchaser.dao.ext;

import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserEnvelope;

import java.util.List;
import java.util.Map;

public interface ExtTPurchaserEnvelopeMapper {

    List<ExtTPurchaserEnvelope> queryList(Map<String, Object> keys);

    List<ExtTPurchaserEnvelope> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
