package com.coretheorylife.modules.gym.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.gym.entity.TGym;
import com.coretheorylife.modules.gym.entity.TGymExample;
import com.coretheorylife.modules.gym.entity.ext.ExtTGym;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface TGymService extends BaseService<TGym, TGymExample> {

    List<ExtTGym> queryList(Map<String, Object> keys);

    List<ExtTGym> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    List<ExtTGym> queryListByLocation(Map<String, Object> keys);

    List<ExtTGym> queryListByLocation();

    int queryTotalByLocation(Map<String, Object> keys);

    int queryTotalByLocation();

    /**
     * 更改状态
     * @param shopId
     * @param status
     * @return
     */
    int updateStatus(Long shopId, int status);

    /**
     * 根据手机号查用户
     * @param mobile
     * @return
     */
    TGym queryByMobile(String mobile);

    /**
     * 重置/设置密码
     * @param TGym
     * @param code
     * @return
     */
    int reSetPassword(TGym TGym, String code);

    /**
     * 重置/设置提现密码
     * @param TGym
     * @param code
     * @return
     */
    int reSetWithdrawPassword(TGym TGym, String code);

    /**
     * 上传头像
     * @param shopId
     * @return
     */
    int uploadAvatarBase64(Long shopId, HttpServletRequest request);
}
