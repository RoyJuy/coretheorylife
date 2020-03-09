package com.coretheorylife.modules.shop.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.shop.entity.TOrderLog;
import com.coretheorylife.modules.shop.entity.TOrderLogExample;

public interface TOrderLogService extends BaseService<TOrderLog, TOrderLogExample> {
    /**
     * 查询是今天的第几个订单
     * @param shopId
     * @return
     */
    int queryCountByShopId(Long shopId);
}
