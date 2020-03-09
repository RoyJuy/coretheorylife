package com.coretheorylife.modules.shop.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.shop.entity.TShopShipLog;
import com.coretheorylife.modules.shop.entity.TShopShipLogExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTShopShipLog;

import java.util.List;
import java.util.Map;

public interface TShopShipLogService extends BaseService<TShopShipLog, TShopShipLogExample> {
    List<ExtTShopShipLog> queryList(Map<String, Object> keys);

    List<ExtTShopShipLog> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
