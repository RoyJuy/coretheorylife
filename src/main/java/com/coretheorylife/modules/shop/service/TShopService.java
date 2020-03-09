package com.coretheorylife.modules.shop.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.shop.entity.TShop;
import com.coretheorylife.modules.shop.entity.TShopExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTShop;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface TShopService extends BaseService<TShop, TShopExample> {

    List<ExtTShop> queryList(Map<String, Object> keys);

    List<ExtTShop> queryList();

    int queryTotal(Map<String, Object> keys);

    int queryTotal();

    List<ExtTShop> queryListByLocation(Map<String, Object> keys);

    List<ExtTShop> queryListByLocation();

    int queryTotalByLocation(Map<String, Object> keys);

    int queryTotalByLocation();

    /**
     * 更改店铺状态
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
    TShop queryByMobile(String mobile);

    /**
     * 用户注册
     * @param tShop
     * @return
     */
    int register(TShop tShop, String code);

    /**
     * 重置/设置密码
     * @param tShop
     * @param code
     * @return
     */
    int reSetPassword(TShop tShop, String code);

    /**
     * 重置/设置提现密码
     * @param tShop
     * @param code
     * @return
     */
    int reSetWithdrawPassword(TShop tShop, String code);

    /**
     * 上传头像
     * @param shopId
     * @return
     */
    int uploadAvatar(Long shopId, HttpServletRequest request);

    /**
     * 上传头像
     * @param shopId
     * @return
     */
    int uploadAvatarBase64(Long shopId, HttpServletRequest request);

    /**
     * 查询评分评价分
     * @param shopId
     * @return
     */
    BigDecimal queryAvgRate(Long shopId);
}
