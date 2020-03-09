package com.coretheorylife.modules.sys.service;


import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.sys.entity.TUserToken;
import com.coretheorylife.modules.sys.entity.TUserTokenExample;

public interface TUserTokenService extends BaseService<TUserToken, TUserTokenExample> {

    TUserToken queryByToken(String token);

    TUserToken queryByUserId(Long userId);

    int deleteByToken(String token);

    TUserToken createToken(Long userId);
}
