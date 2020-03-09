package com.coretheorylife.modules.shop.dao.ext;

import com.coretheorylife.modules.shop.entity.ext.ExtTShopBank;

import java.util.List;
import java.util.Map;

public interface ExtTShopBankMapper {

    List<ExtTShopBank> queryList(Map<String, Object> keys);

    List<ExtTShopBank> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
