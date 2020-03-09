package com.coretheorylife.modules.purchaser.dao.ext;

import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserHealth;

import java.util.List;
import java.util.Map;

public interface ExtTPurchaserHealthMapper {
    List<ExtTPurchaserHealth> queryList(Map<String, Object> keys);

    List<ExtTPurchaserHealth> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
