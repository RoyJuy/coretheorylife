package com.coretheorylife.modules.purchaser.dao.ext;

import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserBank;

import java.util.List;
import java.util.Map;

public interface ExtTPurchaserBankMapper {
    List<ExtTPurchaserBank> queryList(Map<String, Object> keys);

    List<ExtTPurchaserBank> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
