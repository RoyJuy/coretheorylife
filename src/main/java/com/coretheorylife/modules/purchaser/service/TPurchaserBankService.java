package com.coretheorylife.modules.purchaser.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.purchaser.entity.TPurchaserBank;
import com.coretheorylife.modules.purchaser.entity.TPurchaserBankExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserBank;

import java.util.List;
import java.util.Map;

public interface TPurchaserBankService extends BaseService<TPurchaserBank, TPurchaserBankExample> {

    int updateUnCheck(TPurchaserBank record);

    List<ExtTPurchaserBank> queryList(Map<String, Object> keys);

    List<ExtTPurchaserBank> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
