package com.coretheorylife.modules.shop.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.shop.entity.TShopBank;
import com.coretheorylife.modules.shop.entity.TShopBankExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTShopBank;

import java.util.List;
import java.util.Map;

public interface TShopBankService extends BaseService<TShopBank, TShopBankExample> {

    int updateUnCheck(TShopBank record);

    List<ExtTShopBank> queryList(Map<String, Object> keys);

    List<ExtTShopBank> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
