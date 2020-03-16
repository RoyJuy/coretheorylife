package com.coretheorylife.modules.purchaser.service.impl;

import com.coretheorylife.modules.purchaser.common.GoodsInfo;
import com.coretheorylife.modules.purchaser.common.ShopCartInfo;
import com.coretheorylife.modules.purchaser.common.ShopInfo;
import com.coretheorylife.modules.purchaser.common.vo.ShopCartVo;
import com.coretheorylife.modules.purchaser.dao.ShopCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * PurchaserShopCartService
 *
 * @author zhuhaitao
 * @since 2020-03-16
 */
@Service
public class PurchaserShopCartService {
    @Autowired
    private ShopCartMapper shopCartMapper;

    public List<ShopCartVo> findShopCartByPurchaserId(long purchaserId) {

        // 获取购物车
        List<ShopCartInfo> shopCartInfos = shopCartMapper.findShopCartByPurchaseId(purchaserId);

        if (CollectionUtils.isEmpty(shopCartInfos)) {
            return Collections.emptyList();
        }

        // 获取所有商品
        List<Long> goodsIds = new ArrayList<>();

        shopCartInfos.forEach(shopCartInfo -> {
            goodsIds.add(shopCartInfo.getGoodsId());
        });

        List<GoodsInfo> goodsInfos = null;
        if (!CollectionUtils.isEmpty(goodsIds)) {
            goodsInfos = shopCartMapper.findGoodsByIds(goodsIds);
        }

        // 获取所有商品所在商铺的信息
        List<Long> shopIds = new ArrayList<>();
        if (goodsInfos != null) {
            goodsInfos.forEach(goodsInfo -> {
                shopIds.add(goodsInfo.getShopId());
            });
        }

        List<ShopInfo> shopInfos = null;
        if (!CollectionUtils.isEmpty(shopIds)) {
            shopInfos = shopCartMapper.findShopByIds(shopIds);
        }

        return buildShopCart(shopInfos, goodsInfos, shopCartInfos);


    }

    private List<ShopCartVo> buildShopCart(List<ShopInfo> shopInfos, List<GoodsInfo> goodsInfos, List<ShopCartInfo> shopCartInfos) {

        if (CollectionUtils.isEmpty(shopCartInfos)) {
            return Collections.emptyList();
        }

        Map<Long, GoodsInfo> goodsInfoMap = null;

        if (!CollectionUtils.isEmpty(goodsInfos)) {
            goodsInfoMap = goodsInfos.stream().collect(Collectors.toMap(GoodsInfo::getId, GoodsInfo -> GoodsInfo));
        }

        Map<Long, ShopInfo> shopInfoMap = null;

        if (!CollectionUtils.isEmpty(shopInfos)) {
            shopInfoMap = shopInfos.stream().collect(Collectors.toMap(ShopInfo::getId, ShopInfo -> ShopInfo));
        }

        List<ShopCartVo> shopCartVos = new ArrayList<>();

        for (ShopCartInfo shopCartInfo : shopCartInfos) {
            ShopCartVo shopCartVo = new ShopCartVo();
            shopCartVo.setNumber(shopCartInfo.getNumber());
            shopCartVo.setId(shopCartInfo.getId());

            shopCartVo.setGoodsInfo(goodsInfoMap.get(shopCartInfo.getGoodsId()));
            shopCartVo.setShopInfo(shopInfoMap.get(goodsInfoMap.get(shopCartInfo.getGoodsId()).getShopId()));
            shopCartVos.add(shopCartVo);
        }

        return shopCartVos;


    }
}
