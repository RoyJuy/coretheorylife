package com.coretheorylife.modules.purchaser.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.purchaser.entity.TPurchaserTargetLog;
import com.coretheorylife.modules.purchaser.entity.TPurchaserTargetLogExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserTargetLog;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TPurchaserTargetLogService extends BaseService<TPurchaserTargetLog, TPurchaserTargetLogExample> {
    List<ExtTPurchaserTargetLog> queryList(Map<String, Object> keys);

    List<ExtTPurchaserTargetLog> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    /**
     * 注意 date的时间必须是00:00:00才行
     * @param targetId
     * @param date
     * @return
     */
    TPurchaserTargetLog queryOneDayRecord(Long targetId, Date date);

    int save(Long targetId, Long purchaserId);
}
