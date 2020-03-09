package com.coretheorylife.modules.gym.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.gym.entity.TGymReservation;
import com.coretheorylife.modules.gym.entity.TGymReservationExample;
import com.coretheorylife.modules.gym.entity.ext.ExtTGymReservation;

import java.util.List;
import java.util.Map;

public interface TGymReservationService extends BaseService<TGymReservation, TGymReservationExample> {

    /**
     * 预约健身房
     * @param tGymReservation
     * @return
     */
    int reserve(TGymReservation tGymReservation);

    /**
     * 修改预约
     * @param tGymReservation
     * @return
     */
    int updateReservation(TGymReservation tGymReservation);

    /**
     * 给某个预约指定教练
     * @param id
     * @return
     */
    int assignationCoach(Long id, Long coachId);

    /**
     * 更改某个预约单的教练
     * @param id
     * @param coachId
     * @return
     */
    int changeCoach(Long id, Long coachId);

    /**
     * 预约签到
     * @param id
     * @return
     */
    int signIn(Long id);

    /**
     * 预约过期
     * @param id
     * @return
     */
    int expired(Long id);

    /**
     * 用户取消预约
     * @param id
     * @return
     */
    int purchaserCancel(Long id, String remark);

    /**
     * 健身房取消预约
     * @param id
     * @return
     */
    int gymCancel(Long id, String remark);

    /**
     * 更改状态
     * @param id
     * @param status
     * @return
     */
    int changeStatus(Long id, int status);

    /**
     * 用户预约记录
     * @param queryMap
     * @return
     */
    List<ExtTGymReservation> queryList(Map<String, Object> queryMap);

    /**
     * 用户预约记录
     * @param queryMap
     * @return
     */
    int queryTotal(Map<String, Object> queryMap);
}
