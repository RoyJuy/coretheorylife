package com.coretheorylife.modules.purchaser.dao.ext;

import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserAddress;

import java.util.List;
import java.util.Map;

public interface ExtTPurchaserAddressMapper {
    List<ExtTPurchaserAddress> queryList(Map<String, Object> keys);

    List<ExtTPurchaserAddress> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
