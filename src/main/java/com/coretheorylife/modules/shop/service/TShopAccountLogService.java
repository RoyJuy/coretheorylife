package com.coretheorylife.modules.shop.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.shop.entity.TShopAccountLog;
import com.coretheorylife.modules.shop.entity.TShopAccountLogExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTShopAccountLog;

import java.util.List;
import java.util.Map;

public interface TShopAccountLogService extends BaseService<TShopAccountLog, TShopAccountLogExample> {

    List<ExtTShopAccountLog> queryList(Map<String, Object> keys);

    List<ExtTShopAccountLog> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();
}
