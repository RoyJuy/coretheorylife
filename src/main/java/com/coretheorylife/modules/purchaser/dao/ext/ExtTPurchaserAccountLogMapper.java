package com.coretheorylife.modules.purchaser.dao.ext;

import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserAccountLog;

import java.util.List;
import java.util.Map;

public interface ExtTPurchaserAccountLogMapper {
    List<ExtTPurchaserAccountLog> queryList(Map<String, Object> keys);

    List<ExtTPurchaserAccountLog> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
