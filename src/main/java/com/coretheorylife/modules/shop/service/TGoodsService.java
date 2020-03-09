package com.coretheorylife.modules.shop.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.shop.entity.TGoods;
import com.coretheorylife.modules.shop.entity.TGoodsExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoods;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TGoodsService extends BaseService<TGoods, TGoodsExample> {

    List<TGoods> queryList();

    int save(ExtTGoods t);

    int update(ExtTGoods t);

    /**
     * 上架
     *
     * @param goodsId
     * @return
     */
    int shelf(Long goodsId);

    /**
     * 下架
     *
     * @param goodsId
     * @return
     */
    int obtained(Long goodsId);

    /**
     * 扣除库存
     *
     * @param orderId
     * @return
     */
    int returnStock(Long orderId);

    /**
     * 修改库存
     *
     * @param goodsId
     * @param number
     * @return
     */
    int subStock(Long goodsId, int number);

    /**
     * 归还库存
     *
     * @return
     */
    int returnStock(Long goodsId, int number);

    /**
     * 上传图片
     *
     * @param goodsId
     * @return
     */
    String uploadBase64(Long goodsId, HttpServletRequest request);

    /**
     * 店铺内筛选
     *
     * @param goodsName
     * @param shopId
     * @return
     */
    List<ExtTGoods> selectGoodByShopIdOrGoodsName(String goodsName, Long shopId);
}
