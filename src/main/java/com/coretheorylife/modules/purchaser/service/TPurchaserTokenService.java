package com.coretheorylife.modules.purchaser.service;


import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.purchaser.entity.TPurchaserToken;
import com.coretheorylife.modules.purchaser.entity.TPurchaserTokenExample;

public interface TPurchaserTokenService extends BaseService<TPurchaserToken, TPurchaserTokenExample> {

    TPurchaserToken queryByToken(String token);

    TPurchaserToken queryByUserId(Long userId);

    int deleteByToken(String token);

    TPurchaserToken createToken(Long userId);
}
