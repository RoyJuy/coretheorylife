package com.coretheorylife.modules.purchaser.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.purchaser.entity.TPurchaserCoachGym;
import com.coretheorylife.modules.purchaser.entity.TPurchaserCoachGymExample;

public interface TPurchaserCoachGymService extends BaseService<TPurchaserCoachGym, TPurchaserCoachGymExample> {

    /**
     * 绑定用户和教练
     * @param coachId
     * @return
     */
    int bind(Long purchaserId, Long coachId);

    /**
     * 解绑
     */
    int unbind(Long purchaserId);

    /**
     * 根据用户id查询绑定关系
     * @return
     */
    TPurchaserCoachGym selectByPurchaserId(Long purchaserId);
}
