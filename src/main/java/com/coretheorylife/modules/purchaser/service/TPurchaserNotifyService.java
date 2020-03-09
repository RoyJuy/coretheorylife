package com.coretheorylife.modules.purchaser.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.purchaser.entity.TPurchaserNotify;
import com.coretheorylife.modules.purchaser.entity.TPurchaserNotifyExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserNotify;

import java.util.List;
import java.util.Map;

public interface TPurchaserNotifyService extends BaseService<TPurchaserNotify, TPurchaserNotifyExample> {

    List<ExtTPurchaserNotify> queryList(Map<String, Object> keys);

    List<ExtTPurchaserNotify> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    /**
     * 设置消息的已读
     * @param notifyId
     * @return
     */
    int readNotify(Long notifyId);
}
