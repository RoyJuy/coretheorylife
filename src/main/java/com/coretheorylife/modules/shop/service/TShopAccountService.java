package com.coretheorylife.modules.shop.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.shop.entity.TShopAccount;
import com.coretheorylife.modules.shop.entity.TShopAccountExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTShopAccount;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface TShopAccountService extends BaseService<TShopAccount, TShopAccountExample> {

    List<ExtTShopAccount> queryList(Map<String, Object> keys);

    List<ExtTShopAccount> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    TShopAccount initAccount(Long shopId);

    int withDraw(BigDecimal money, Long cardId, Long shopId, String accountPassword);
}
