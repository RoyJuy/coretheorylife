package com.coretheorylife.modules.purchaser.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealth;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserHealth;

import java.util.List;
import java.util.Map;

public interface TPurchaserHealthService extends BaseService<TPurchaserHealth, TPurchaserHealthExample> {

    List<ExtTPurchaserHealth> queryList(Map<String, Object> keys);

    List<ExtTPurchaserHealth> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    /**
     * 根据用户id查询体侧数据
     *
     * @param purchaserId
     * @return
     */
    TPurchaserHealth queryObjectByPurchaserId(Long purchaserId);

    TPurchaserHealth save(ExtTPurchaserHealth t);

    TPurchaserHealth updateAfterSave(TPurchaserHealth t);
}
