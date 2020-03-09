package com.coretheorylife.modules.purchaser.dao.ext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ExtTPurchaserCoachGymLogMapper {
    /**
     * 查询某个时间段某个健身房人数增加或下降
     * 如果用于在该时间段内同时解绑或重新绑定
     * 那么不计算在该范围内
     * @param queryMap
     * @return
     */
    int queryPurchaseCountByGym(Map<String, Object> queryMap);

    /**
     * 查询健身房获客图表
     * @param queryMap
     * @return
     */
    List<HashMap<String, Object>> queryPurchaseDateListByGym(Map<String, Object> queryMap);
}
