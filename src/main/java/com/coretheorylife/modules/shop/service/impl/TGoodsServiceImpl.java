package com.coretheorylife.modules.shop.service.impl;

import com.coretheorylife.common.annotation.ZookeeperLock;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.exception.ResourceNotExistsException;
import com.coretheorylife.common.fileupload.FileEntity;
import com.coretheorylife.common.fileupload.FileUploadHelper;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.shop.dao.TGoodsMapper;
import com.coretheorylife.modules.shop.dao.ext.ExtTGoodsMapper;
import com.coretheorylife.modules.shop.entity.*;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoods;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoodsInclude;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoodsLabel;
import com.coretheorylife.modules.shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("tGoodsService")
public class TGoodsServiceImpl extends BaseServiceImpl<TGoods, TGoodsExample> implements TGoodsService {

    public static final String LOCK_PREFIX = "shop_goods_save";

    @Autowired
    private TGoodsMapper tGoodsMapper;
    @Autowired
    private ExtTGoodsMapper extTGoodsMapper;
    @Autowired
    private TGoodsLabelService tGoodsLabelService;
    @Autowired
    private TGoodsSelectService tGoodsSelectService;
    @Autowired
    private TGoodsIncludeService tGoodsIncludeService;
    @Autowired
    private TOrderLineService tOrderLineService;
    @Autowired
    private TGoodsNutritionService tGoodsNutritionService;
    @Autowired
    private FileUploadHelper fileUploadHelper;

    @Override
    public int save(TGoods t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return extTGoodsMapper.insertSelective(t);
    }

    @Override
    public int update(TGoods t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getShopId());
        return tGoodsMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TGoods t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TGoods queryObject(Long id) {
        return tGoodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TGoods> queryList() {
        TGoodsExample example = new TGoodsExample();
        TGoodsExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteFlagEqualTo(false);
        criteria.andMonthSellGreaterThan(0);
        return tGoodsMapper.selectByExample(example);
    }


    @ZookeeperLock(lockPathPrefix = LOCK_PREFIX, fieldName = "shopId")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int save(ExtTGoods t) {
        int totalWeight = 0;
        BigDecimal totalProtein = BigDecimal.ZERO;
        BigDecimal totalCarbohydrate = BigDecimal.ZERO;
        BigDecimal totalAdipose = BigDecimal.ZERO;
        BigDecimal totalKacl = BigDecimal.ZERO;
        save((TGoods) t);
        TGoodsNutrition tGoodsNutrition;
        for (ExtTGoodsInclude tGoodsInclude : t.gettGoodsIncludes()) {
            tGoodsInclude.setShopGoodsId(t.getId());
            tGoodsInclude.setShopId(t.getShopId());
            tGoodsInclude.setGoodsNutritionId(tGoodsInclude.getGoodsNutritionId());
            tGoodsNutrition = tGoodsNutritionService.queryObject(tGoodsInclude.getGoodsNutritionId());
            if (tGoodsNutrition == null) {
                throw new ResourceNotExistsException("找不到指定的食物组成");
            }
            totalProtein = totalProtein.add(tGoodsNutrition.getProtein().multiply(new BigDecimal(tGoodsInclude.getWeight())));
            totalCarbohydrate = totalCarbohydrate.add(tGoodsNutrition.getCarbohydrate().multiply(new BigDecimal(tGoodsInclude.getWeight())));
            totalAdipose = totalAdipose.add(tGoodsNutrition.getAdipose().multiply(new BigDecimal(tGoodsInclude.getWeight())));
            totalKacl = totalKacl.add(tGoodsNutrition.getKacl().multiply(new BigDecimal(tGoodsInclude.getWeight())));
            totalWeight += tGoodsInclude.getWeight();
            tGoodsIncludeService.save(tGoodsInclude);
        }
        t.setWeight(totalWeight);
        t.setProtein(totalProtein);
        t.setCarbohydrate(totalCarbohydrate);
        t.setAdipose(totalAdipose);
        t.setKacl(totalKacl);

        if (t.getGoodsLabels() != null) {
            for (ExtTGoodsLabel goodsLabel : t.getGoodsLabels()) {
                // 保存商品规格
                goodsLabel.setGoodsId(t.getId());
                tGoodsLabelService.save(goodsLabel);
                if (goodsLabel != null) {
                    if (goodsLabel.getGoodsSelects() == null || goodsLabel.getGoodsSelects().isEmpty()) {
                        throw new InvalidParameterException("选择规则后必须填写规格属性");
                    }
                    // 保存规格属性
                    for (TGoodsSelect tGoodsSelect : goodsLabel.getGoodsSelects()) {
                        tGoodsSelect.setGoodsLabelId(goodsLabel.getId());
                        tGoodsNutrition = tGoodsNutritionService.queryObject(tGoodsSelect.getGoodsNutritionId());
                        if (tGoodsNutrition == null) {
                            throw new ResourceNotExistsException("找不到指定的食物组成");
                        }
                        t.setWeight(tGoodsSelect.getWeight());
                        t.setProtein(tGoodsNutrition.getProtein().multiply(new BigDecimal(tGoodsSelect.getWeight())));
                        t.setCarbohydrate(tGoodsNutrition.getCarbohydrate().multiply(new BigDecimal(tGoodsSelect.getWeight())));
                        t.setAdipose(tGoodsNutrition.getAdipose().multiply(new BigDecimal(tGoodsSelect.getWeight())));
                        t.setKacl(tGoodsNutrition.getKacl().multiply(new BigDecimal(tGoodsSelect.getWeight())));
                        tGoodsSelectService.save(tGoodsSelect);
                    }
                }
            }
        }
        return 1;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int update(ExtTGoods t) {
        int totalWeight = 0;
        BigDecimal totalProtein = BigDecimal.ZERO;
        BigDecimal totalCarbohydrate = BigDecimal.ZERO;
        BigDecimal totalAdipose = BigDecimal.ZERO;
        BigDecimal totalKacl = BigDecimal.ZERO;
        TGoodsNutrition tGoodsNutrition;
        tGoodsIncludeService.deleteByGoodsId(t.getId());
        // 这里先无脑删除商品组成，然后再重新保存商品组成
        if (t.gettGoodsIncludes() != null) {
            for (ExtTGoodsInclude tGoodsInclude : t.gettGoodsIncludes()) {
                tGoodsInclude.setShopGoodsId(t.getId());
                tGoodsInclude.setShopId(t.getShopId());
                tGoodsIncludeService.save(tGoodsInclude);

                tGoodsNutrition = tGoodsNutritionService.queryObject(tGoodsInclude.getGoodsNutritionId());
                if (tGoodsNutrition == null) {
                    throw new ResourceNotExistsException("找不到指定的食物组成");
                }
                totalProtein = totalProtein.add(tGoodsNutrition.getProtein().multiply(new BigDecimal(tGoodsInclude.getWeight())));
                totalCarbohydrate = totalCarbohydrate.add(tGoodsNutrition.getCarbohydrate().multiply(new BigDecimal(tGoodsInclude.getWeight())));
                totalAdipose = totalAdipose.add(tGoodsNutrition.getAdipose().multiply(new BigDecimal(tGoodsInclude.getWeight())));
                totalKacl = totalKacl.add(tGoodsNutrition.getKacl().multiply(new BigDecimal(tGoodsInclude.getWeight())));
                totalWeight += tGoodsInclude.getWeight();
            }
        }
        t.setWeight(totalWeight);
        t.setProtein(totalProtein);
        t.setCarbohydrate(totalCarbohydrate);
        t.setAdipose(totalAdipose);
        t.setKacl(totalKacl);
        update((TGoods) t);
        tGoodsLabelService.deleteByGoodsId(t.getId());
        if (t.getGoodsLabels() != null) {
            for (ExtTGoodsLabel goodsLabel : t.getGoodsLabels()) {
                // 保存商品规格
                goodsLabel.setGoodsId(t.getId());
                tGoodsLabelService.save(goodsLabel);
                if (goodsLabel != null) {
                    if (goodsLabel.getGoodsSelects() == null || goodsLabel.getGoodsSelects().isEmpty()) {
                        throw new InvalidParameterException("选择规则后必须填写规格属性");
                    }
                    // 保存规格属性
                    for (TGoodsSelect tGoodsSelect : goodsLabel.getGoodsSelects()) {
                        tGoodsSelect.setGoodsLabelId(goodsLabel.getId());
                        tGoodsNutrition = tGoodsNutritionService.queryObject(tGoodsSelect.getGoodsNutritionId());
                        if (tGoodsNutrition == null) {
                            throw new ResourceNotExistsException("找不到指定的食物组成");
                        }
                        t.setWeight(tGoodsSelect.getWeight());
                        t.setProtein(tGoodsNutrition.getProtein().multiply(new BigDecimal(tGoodsSelect.getWeight())));
                        t.setCarbohydrate(tGoodsNutrition.getCarbohydrate().multiply(new BigDecimal(tGoodsSelect.getWeight())));
                        t.setAdipose(tGoodsNutrition.getAdipose().multiply(new BigDecimal(tGoodsSelect.getWeight())));
                        t.setKacl(tGoodsNutrition.getKacl().multiply(new BigDecimal(tGoodsSelect.getWeight())));
                        tGoodsSelectService.save(tGoodsSelect);
                    }
                }
            }
        }
        return 1;
    }

    @Override
    public int shelf(Long goodsId) {
        TGoods tGoods = new TGoods();
        tGoods.setId(goodsId);
        tGoods.setStatus(ExtTGoods.STATUS_SHELF);
        return update(tGoods);
    }

    @Override
    public int obtained(Long goodsId) {
        TGoods tGoods = new TGoods();
        tGoods.setId(goodsId);
        tGoods.setStatus(ExtTGoods.STATUS_OBTAINED);
        return update(tGoods);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int returnStock(Long orderId) {
        List<TOrderLine> list = tOrderLineService.queryListByOrderId(orderId);
        for (TOrderLine tOrderLine : list) {
            if (tOrderLine.getGoodsId() != null && tOrderLine.getNumber() > 0) {
                returnStock(tOrderLine.getGoodsId(), tOrderLine.getNumber());
            }
        }
        return 1;
    }

    @Override
    public int subStock(Long goodsId, int number) {
        ExtTGoods tGoods = new ExtTGoods();
        tGoods.setNumber(number);
        tGoods.setId(goodsId);
        return extTGoodsMapper.subStock(tGoods);
    }

    @Override
    public int returnStock(Long goodsId, int number) {
        ExtTGoods tGoods = new ExtTGoods();
        tGoods.setNumber(number);
        tGoods.setId(goodsId);
        return extTGoodsMapper.returnStock(tGoods);
    }

    @Override
    public String uploadBase64(Long goodsId, HttpServletRequest request) {
        Map<String, FileEntity> map = fileUploadHelper.uploadBase64(request, "goods", TShopServiceImpl.class);
        String url = null;
        for (String key : map.keySet()) {
            url = map.get(key).getCompleteSavePath();
        }
        if (url != null) {
            TGoods tGoods = new TGoods();
            tGoods.setId(goodsId);
            tGoods.setPic(url);
            update(tGoods);
            return url;
        }
        return "";
    }

    @Override
    public List<ExtTGoods> selectGoodByShopIdOrGoodsName(String goodsName, Long shopId) {
        Map<String, Object> map = new HashMap<>();
        map.put("key", goodsName);
        map.put("status", ExtTGoods.STATUS_SHELF);
        map.put("deleteFlag", false);
        map.put("shopId", shopId);
        return extTGoodsMapper.selectGoodByShopIdOrGoodsName(map);
    }
}
