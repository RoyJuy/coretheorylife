package com.coretheorylife.modules.shop.dao.ext;

import com.coretheorylife.modules.shop.entity.ext.ExtTShopShipLog;

import java.util.List;
import java.util.Map;

public interface ExtTShopShipLogMapper {
    List<ExtTShopShipLog> queryList(Map<String, Object> keys);

    List<ExtTShopShipLog> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
