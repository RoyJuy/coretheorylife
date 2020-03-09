package com.coretheorylife.modules.purchaser.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.purchaser.entity.TPurchaserCoachGymLog;
import com.coretheorylife.modules.purchaser.entity.TPurchaserCoachGymLogExample;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TPurchaserCoachGymLogService extends BaseService<TPurchaserCoachGymLog, TPurchaserCoachGymLogExample> {
    /**
     * 查询某个时间段某个健身房人数增加或下降
     * 如果用于在该时间段内同时解绑或重新绑定
     * 那么不计算在该范围内
     * @param queryMap
     * @return
     */
    int queryPurchaseCountByGym(Map<String, Object> queryMap);

    /**
     * 查询某天健身房人数增长情况
     * @param gymId
     * @return
     */
    int queryGymIncrease(Long gymId, String createDate);

    /**
     * 查询某天健身房人数减少情况
     * @param gymId
     * @return
     */
    int queryGymFewer(Long gymId, String createDate);

    /**
     * 查询某天某个用户的记录
     * @param purchaserId
     * @param createDate
     * @return
     */
    List<TPurchaserCoachGymLog> queryList(Long purchaserId, Date createDate, Integer type);

    /**
     * 查询健身房获客图表
     * @param queryMap
     * @return
     */
    List<HashMap<String, Object>> queryPurchaseDateListByGym(Map<String, Object> queryMap);

    /**
     * 查询健身房获客图表
     * @param queryMap
     * @return
     */
    HashMap<String, Integer> queryPurchaseDateMapByGym(Map<String, Object> queryMap);

    /**
     * 查询健身房的echarts数据
     * @return
     */
    Map<String, Object> queryEcharts(String timeFrom, String timeTo, Long gymId);

}
