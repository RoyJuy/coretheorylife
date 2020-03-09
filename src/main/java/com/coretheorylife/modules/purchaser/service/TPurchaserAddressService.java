package com.coretheorylife.modules.purchaser.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.purchaser.entity.TPurchaserAddress;
import com.coretheorylife.modules.purchaser.entity.TPurchaserAddressExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserAddress;

import java.util.List;
import java.util.Map;

public interface TPurchaserAddressService extends BaseService<TPurchaserAddress, TPurchaserAddressExample> {

    int updateUnCheck(TPurchaserAddress record);

    List<ExtTPurchaserAddress> queryList(Map<String, Object> keys);

    List<ExtTPurchaserAddress> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
