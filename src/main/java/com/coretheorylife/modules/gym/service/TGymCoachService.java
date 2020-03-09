package com.coretheorylife.modules.gym.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.gym.entity.TGymCoach;
import com.coretheorylife.modules.gym.entity.TGymCoachExample;
import com.coretheorylife.modules.purchaser.entity.TPurchaser;

import java.util.List;

public interface TGymCoachService extends BaseService<TGymCoach, TGymCoachExample> {

    /**
     * 绑定健身房和教练
     * @param gymId
     * @return
     */
    int bind(Long gymId, Long id);

    /**
     * 解绑
     */
    int unbind(Long id);

    /**
     * 根据教练id查询所绑定的健身房
     * @param coachId
     * @return
     */
    TGymCoach selectByCoachId(Long coachId);

    List<TPurchaser> selectCoachListByGymId(Long gymId);
}
