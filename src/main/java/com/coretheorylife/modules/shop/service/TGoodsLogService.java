package com.coretheorylife.modules.shop.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.shop.entity.TGoodsLog;
import com.coretheorylife.modules.shop.entity.TGoodsLogExample;

public interface TGoodsLogService extends BaseService<TGoodsLog, TGoodsLogExample> {

    /**
     * 重置
     * @param goodsId
     * @param number
     * @param shopId
     */
    void resetStock(Long goodsId, int number, Long shopId);
}
