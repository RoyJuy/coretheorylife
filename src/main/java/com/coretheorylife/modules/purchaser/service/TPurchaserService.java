package com.coretheorylife.modules.purchaser.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.gym.entity.TGym;
import com.coretheorylife.modules.purchaser.entity.TPurchaser;
import com.coretheorylife.modules.purchaser.entity.TPurchaserExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface TPurchaserService extends BaseService<TPurchaser, TPurchaserExample> {

    List<ExtTPurchaser> queryList(Map<String, Object> keys);

    List<ExtTPurchaser> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    ExtTPurchaser queryObject(Long purchaserId);

    /**
     * 根据手机号查用户
     *
     * @param mobile
     * @return
     */
    TPurchaser queryByMobile(String mobile);

    /**
     * 用户注册
     *
     * @param TPurchaser
     * @return
     */
    int register(TPurchaser TPurchaser, String code);

    /**
     * 重置/设置密码
     *
     * @param TPurchaser
     * @param code
     * @return
     */
    int reSetPassword(TPurchaser TPurchaser, String code);

    /**
     * 上传头像
     *
     * @param shopId
     * @return
     */
    int uploadAvatar(Long shopId, HttpServletRequest request);

    /**
     * 上传头像
     *
     * @param shopId
     * @return
     */
    int uploadAvatarBase64(Long shopId, HttpServletRequest request);

    /**
     * 更新用户身份
     * @param purchaserId
     * @param property
     * @return
     */
    int updateProperty(Long purchaserId, Integer property);

    /**
     * 教练查询自己绑定的健身房
     * @param id
     * @return
     */
    TGym queryMyGym(Long id);

    /**
     * 查询我的教练
     * @param purchaserId
     * @return
     */
    TPurchaser queryMyCoach(Long purchaserId);

    /**
     * 重置/设置提现密码
     * @param tPurchaser
     * @param code
     * @return
     */
    int reSetWithdrawPassword(TPurchaser tPurchaser, String code);
}
