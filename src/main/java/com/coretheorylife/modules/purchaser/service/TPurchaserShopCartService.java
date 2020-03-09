package com.coretheorylife.modules.purchaser.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.purchaser.entity.TPurchaserShopCart;
import com.coretheorylife.modules.purchaser.entity.TPurchaserShopCartExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserShopCart;
import com.coretheorylife.modules.shop.entity.ext.ExtTShop;

import java.util.List;
import java.util.Map;

public interface TPurchaserShopCartService extends BaseService<TPurchaserShopCart, TPurchaserShopCartExample> {

    List<ExtTShop> queryList(Map<String, Object> keys);

    List<ExtTShop> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
