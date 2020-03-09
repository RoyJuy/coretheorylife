package com.coretheorylife.modules.purchaser.dao.ext;

import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserNotify;

import java.util.List;
import java.util.Map;

public interface ExtTPurchaserNotifyMapper {
    List<ExtTPurchaserNotify> queryList(Map<String, Object> keys);

    List<ExtTPurchaserNotify> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
