package com.coretheorylife.modules.job;

import com.coretheorylife.modules.shop.entity.TGoods;
import com.coretheorylife.modules.shop.service.TGoodsLogService;
import com.coretheorylife.modules.shop.service.TGoodsService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class OrderJob {

    @Autowired
    private TGoodsService tGoodsService;

    @Autowired
    private TGoodsLogService tGoodsLogService;

    /**
     * 重置库存
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @XxlJob("resetStock")
    public ReturnT<String> resetStock(String nothing) {
        List<TGoods> list = tGoodsService.queryList();
        for (TGoods tGoods : list) {
            tGoodsLogService.resetStock(tGoods.getId(), tGoods.getMonthSell(), tGoods.getShopId());
            tGoods.setMonthSell(0);
            tGoodsService.update(tGoods);
        }
        return ReturnT.SUCCESS;
    }

}
