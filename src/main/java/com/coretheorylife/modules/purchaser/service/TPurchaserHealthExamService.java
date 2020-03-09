package com.coretheorylife.modules.purchaser.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthExam;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthExamExample;

public interface TPurchaserHealthExamService extends BaseService<TPurchaserHealthExam, TPurchaserHealthExamExample> {

    /**
     * 根据用户id查询体侧数据
     * @param purchaseId
     * @return
     */
    TPurchaserHealthExam queryObjectByPurchaserId(Long purchaseId);
}
