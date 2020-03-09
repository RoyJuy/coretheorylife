package com.coretheorylife.modules.shop.dao.ext;

import com.coretheorylife.modules.shop.entity.TShop;
import com.coretheorylife.modules.shop.entity.ext.ExtTShop;

import java.util.List;
import java.util.Map;

public interface ExtTShopMapper {
    List<ExtTShop> queryList(Map<String, Object> keys);

    List<ExtTShop> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    int insertSelective(TShop record);

    List<ExtTShop> queryListByLocation(Map<String, Object> keys);

    List<ExtTShop> queryListByLocation();

    int queryTotalByLocation(Map<String, Object> keys);

    int queryTotalByLocation();
}
