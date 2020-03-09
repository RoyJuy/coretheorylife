package com.coretheorylife.modules.shop.service;


import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.shop.entity.TShopToken;
import com.coretheorylife.modules.shop.entity.TShopTokenExample;

public interface TShopTokenService extends BaseService<TShopToken, TShopTokenExample> {

    TShopToken queryByToken(String token);

    TShopToken queryByUserId(Long userId);

    int deleteByToken(String token);

    TShopToken createToken(Long userId);
}
