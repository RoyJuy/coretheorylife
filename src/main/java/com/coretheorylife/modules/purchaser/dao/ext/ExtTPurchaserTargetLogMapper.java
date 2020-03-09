package com.coretheorylife.modules.purchaser.dao.ext;

import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserTargetLog;

import java.util.List;
import java.util.Map;

public interface ExtTPurchaserTargetLogMapper {
    List<ExtTPurchaserTargetLog> queryList(Map<String, Object> keys);

    List<ExtTPurchaserTargetLog> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
