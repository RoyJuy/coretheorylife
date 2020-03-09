package com.coretheorylife.modules.purchaser.controller;

import com.coretheorylife.common.annotation.AuthIgnore;
import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.AbstractController;
import com.coretheorylife.modules.shop.copier.TGoodsNutritionCopier;
import com.coretheorylife.modules.shop.entity.TGoodsNutrition;
import com.coretheorylife.modules.shop.entity.TGoodsNutritionExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoodsNutrition;
import com.coretheorylife.modules.shop.service.TGoodsNutritionService;
import com.coretheorylife.modules.shop.vo.TGoodsNutritionRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/purchaser/nutrition")
public class TPurchaserNutritionController extends AbstractController<TGoodsNutrition, TGoodsNutritionExample> {

    @Autowired
    private TGoodsNutritionService tGoodsNutritionService;

    /**
     * 查询食物组成列表
     *
     * @param params
     * @return
     */
    @AuthIgnore
    @WebLog
    @GetMapping("/list")
    public Result list(@RequestParam Map<String, Object> params) {
        params.put("deleteFlag", false);
        Query query = new Query(params);
        List<ExtTGoodsNutrition> list = tGoodsNutritionService.queryList(query);
        int total = tGoodsNutritionService.queryTotal(query);
        List<TGoodsNutritionRVO> result = TGoodsNutritionCopier.INSTANCE.asTGoodsNutritionRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }
}
