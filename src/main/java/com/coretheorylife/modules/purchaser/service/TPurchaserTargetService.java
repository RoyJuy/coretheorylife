package com.coretheorylife.modules.purchaser.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.purchaser.entity.TPurchaserTarget;
import com.coretheorylife.modules.purchaser.entity.TPurchaserTargetExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserTarget;

import java.util.List;
import java.util.Map;

public interface TPurchaserTargetService extends BaseService<TPurchaserTarget, TPurchaserTargetExample> {
    List<ExtTPurchaserTarget> queryList(Map<String, Object> keys);

    List<ExtTPurchaserTarget> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
