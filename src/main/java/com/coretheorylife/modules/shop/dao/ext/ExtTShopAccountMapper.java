package com.coretheorylife.modules.shop.dao.ext;


import com.coretheorylife.modules.shop.entity.TShopAccount;
import com.coretheorylife.modules.shop.entity.ext.ExtTShopAccount;

import java.util.List;
import java.util.Map;

public interface ExtTShopAccountMapper {
    List<ExtTShopAccount> queryList(Map<String, Object> keys);

    List<ExtTShopAccount> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    int insertSelective(TShopAccount record);
}
