package com.coretheorylife.modules.shop.dao.ext;

import com.coretheorylife.modules.shop.entity.ext.ExtTShopAccountLog;

import java.util.List;
import java.util.Map;

public interface ExtTShopAccountLogMapper {
    List<ExtTShopAccountLog> queryList(Map<String, Object> keys);

    List<ExtTShopAccountLog> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
