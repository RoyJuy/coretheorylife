package com.coretheorylife.modules.purchaser.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthLog;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthLogExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtHealthTools;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserHealthLog;

import java.util.List;

public interface TPurchaserHealthLogService extends BaseService<TPurchaserHealthLog, TPurchaserHealthLogExample> {

    /**
     * 根据时间查询当天的目标完成度
     * @param time
     * @return
     */
    ExtTPurchaserHealthLog queryByTime(String time, Long purchaserId, boolean hasOrder);

    /**
     * 根据订单id删除
     * @param orderId
     * @return
     */
    int deleteByOrderId(Long orderId);

    /**
     * 健康管理
     * @param time
     * @param purchaserId
     * @param hasOrder
     * @return
     */
    List<ExtHealthTools> queryTools(String time, Long purchaserId, boolean hasOrder);
}
