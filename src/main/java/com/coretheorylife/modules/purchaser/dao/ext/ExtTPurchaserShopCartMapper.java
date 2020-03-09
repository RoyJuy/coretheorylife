package com.coretheorylife.modules.purchaser.dao.ext;

import com.coretheorylife.modules.shop.entity.ext.ExtTShop;

import java.util.List;
import java.util.Map;

public interface ExtTPurchaserShopCartMapper {
    List<ExtTShop> queryList(Map<String, Object> keys);

    List<ExtTShop> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
