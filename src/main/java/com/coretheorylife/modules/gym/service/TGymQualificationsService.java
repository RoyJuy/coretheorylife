package com.coretheorylife.modules.gym.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.gym.entity.TGymQualifications;
import com.coretheorylife.modules.gym.entity.TGymQualificationsExample;

import javax.servlet.http.HttpServletRequest;

public interface TGymQualificationsService extends BaseService<TGymQualifications, TGymQualificationsExample> {

    /**
     * 初始化
     *
     * @param gymId
     * @return
     */
    TGymQualifications init(Long gymId);

    /**
     * 根据店铺和类型
     *
     * @param GymId
     * @return
     */
    TGymQualifications queryByGymId(Long GymId);

    /**
     * 上传图片
     *
     * @param GymId
     * @return
     */
    String uploadQualificationsBase64(Long GymId, HttpServletRequest request);
}