package com.coretheorylife.common.algorithm;

import com.coretheorylife.modules.purchaser.entity.TPurchaserHealth;
import com.coretheorylife.modules.purchaser.service.TPurchaserHealthService;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoods;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoodsNutrition;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoodsType;
import com.coretheorylife.modules.shop.entity.ext.ExtTShop;
import com.coretheorylife.modules.shop.service.TGoodsTypeService;
import com.coretheorylife.modules.shop.service.TShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author Connor
 * 根据用户热量需求推荐对应食物套餐
 */
@Component
public class RecommendUtils {

    @Autowired
    private TPurchaserHealthService tPurchaserHealthService;

    @Autowired
    private TShopService tShopService;

    @Autowired
    private TGoodsTypeService tGoodsTypeService;

    public List<ExtTGoods> getRecommendList(Long purchaserId, BigDecimal longitude, BigDecimal latitude, int number, int distance, BigDecimal rate) {
        TPurchaserHealth tPurchaserHealth = tPurchaserHealthService.queryObjectByPurchaserId(purchaserId);
        BigDecimal allKcl = new BigDecimal("2000");
        if (tPurchaserHealth != null) {
            allKcl = tPurchaserHealth.getKclNeed();
        }
        allKcl = allKcl.multiply(rate);
        // 先获取最近没有超出范围的商家
        Map<String, Object> shopQuery = new HashMap<>();
        // distance 公里以内推荐商家
        shopQuery.put("distance", distance);
        shopQuery.put("latitude", latitude);
        shopQuery.put("longitude", longitude);
        shopQuery.put("status", ExtTShop.STATUS_OPEN);
        shopQuery.put("offset", 0);
        shopQuery.put("limit", 10);
        shopQuery.put("deleteFlag", false);
        shopQuery.put("status", ExtTShop.STATUS_OPEN + ", " + ExtTShop.STATUS_REST);
        shopQuery.put("goodsStatus", ExtTGoods.STATUS_SHELF);
        List<ExtTShop> shops = tShopService.queryListByLocation(shopQuery);
        // 然后在商家的商品中选择符合要求的
        if (shops == null || shops.isEmpty()) {
            return new ArrayList<>();
        }
        Map<String, Object> goodsQuery = new HashMap<>();
        goodsQuery.put("deleteFlag", false);
        goodsQuery.put("status", ExtTGoods.STATUS_SHELF);
        BigDecimal kcal;
        List<ExtTGoods> conformGoods = new ArrayList<>();
        for (ExtTShop extTShop : shops) {
            if (extTShop.getDistance().compareTo(new BigDecimal(distance)) == 1) {
                continue;
            }
            goodsQuery.put("shopId", extTShop.getId());
            List<ExtTGoodsType> tGoodsTypes = tGoodsTypeService.queryAllGoodByShopId(goodsQuery);
            for (ExtTGoodsType extTGoodsType : tGoodsTypes) {
                for (ExtTGoods extTGoods : extTGoodsType.getGoods()) {
                    kcal = extTGoods.getKacl();
                    // 记录每种食物的热量
                    if (tPurchaserHealth.getTarget() == NutritionUtils.SPORT_TYPE_LOSS_FAT) {
                        // 如果总需摄入比当前卡路里乘0.9大
                        // 并且当前卡路里没有总摄入大
                        if (kcal.multiply(new BigDecimal("0.9")).compareTo(allKcl) < 1 && kcal.compareTo(allKcl) < 1) {
                            conformGoods.add(extTGoods);
                        }
                    } else {
                        // 如果当前卡路里的0.9比总需要小 并且1.1比总需要大
                        if (kcal.multiply(new BigDecimal(0.9)).compareTo(allKcl) < 1 && kcal.multiply(new BigDecimal(1.1)).compareTo(allKcl) == 1) {
                            conformGoods.add(extTGoods);
                        }
                    }
                }
            }
        }
        Random random = new Random();
        if (conformGoods.size() <= number) {
            return conformGoods;
        }
        List<ExtTGoods> returnList = new ArrayList<>();
        Set<Integer> checkSet = new HashSet<>();
        int count = 0;
        for (int i = 0; i < number; i++) {
            int id = random.nextInt(conformGoods.size());
            checkSet.add(id);
            count++;
            while(count > checkSet.size()) {
                // 证明生成了重复的随机数
                count = checkSet.size();
                id = random.nextInt(conformGoods.size());
                checkSet.add(id);
                count++;
            }
            returnList.add(conformGoods.get(i));
        }
        return returnList;
    }
}
