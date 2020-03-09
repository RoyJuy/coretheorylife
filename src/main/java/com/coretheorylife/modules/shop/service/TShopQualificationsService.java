package com.coretheorylife.modules.shop.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.shop.entity.TShopQualifications;
import com.coretheorylife.modules.shop.entity.TShopQualificationsExample;

import javax.servlet.http.HttpServletRequest;

public interface TShopQualificationsService extends BaseService<TShopQualifications, TShopQualificationsExample> {

    /**
     * 初始化
     *
     * @param shopId
     * @param type
     * @return
     */
    TShopQualifications init(Long shopId, int type);

    /**
     * 初始化主体资质
     *
     * @param shopId
     * @return
     */
    TShopQualifications initQualificationsMain(Long shopId);

    /**
     * 初始化行业资质
     *
     * @param shopId
     * @return
     */
    TShopQualifications initQualificationsIndustry(Long shopId);

    /**
     * 根据店铺和类型查询资质
     * @param shopId
     * @param type
     * @return
     */
    TShopQualifications queryByShopIdAndType(Long shopId, int type);

    /**
     * 上传图片
     * @param shopId
     * @return
     */
    String uploadQualificationsBase64(Long shopId, HttpServletRequest request);
}