package com.coretheorylife.modules.gym.dao.ext;

import com.coretheorylife.modules.purchaser.entity.TPurchaser;

import java.util.List;

public interface ExtTGymCoachMapper {
    List<TPurchaser> selectCoachListByGymId(Long gymId);
}
