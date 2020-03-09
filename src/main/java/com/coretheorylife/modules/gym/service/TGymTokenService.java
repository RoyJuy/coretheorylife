package com.coretheorylife.modules.gym.service;


import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.gym.entity.TGymToken;
import com.coretheorylife.modules.gym.entity.TGymTokenExample;

public interface TGymTokenService extends BaseService<TGymToken, TGymTokenExample> {

    TGymToken queryByToken(String token);

    TGymToken queryByUserId(Long userId);

    int deleteByToken(String token);

    TGymToken createToken(Long userId);
}
