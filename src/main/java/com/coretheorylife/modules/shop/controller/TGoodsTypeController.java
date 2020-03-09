package com.coretheorylife.modules.shop.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.AbstractController;
import com.coretheorylife.modules.shop.copier.TGoodsTypeCopier;
import com.coretheorylife.modules.shop.entity.TGoodsType;
import com.coretheorylife.modules.shop.entity.TGoodsTypeExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoodsType;
import com.coretheorylife.modules.shop.service.TGoodsTypeService;
import com.coretheorylife.modules.shop.vo.TGoodsTypeCVO;
import com.coretheorylife.modules.shop.vo.TGoodsTypeRVO;
import com.coretheorylife.modules.shop.vo.TGoodsTypeUVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shop/goods/type")
public class TGoodsTypeController extends AbstractController<TGoodsType, TGoodsTypeExample> {

    @Autowired
    private TGoodsTypeService tGoodsTypeService;

    /**
     * 查询货架列表
     *
     * @param params
     * @return
     */
    @WebLog
    @GetMapping("/list")
    public Result list(@RequestParam Map<String, Object> params) {
        params.put("deleteFlag", false);
        params.put("shopId", getShopId());
        Query query = new Query(params);
        List<ExtTGoodsType> list = tGoodsTypeService.queryList(query);
        int total = tGoodsTypeService.queryTotal(query);
        List<TGoodsTypeRVO> result = TGoodsTypeCopier.INSTANCE.asTGoodsTypeRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }

    /**
     * 查询所有产品列表
     *
     * @param params
     * @return
     */
    @WebLog
    @GetMapping("/allList")
    public Result allList(@RequestParam Map<String, Object> params) {
        params.put("deleteFlag", false);
        params.put("shopId", getShopId());
        // 设置这个是为了sql中left join货物，用于显示没有商品在的货架
        params.put("isShop", true);
        List<ExtTGoodsType> list = tGoodsTypeService.queryAllGoodByShopId(params);
        List<TGoodsTypeRVO> result = TGoodsTypeCopier.INSTANCE.asTGoodsTypeRVOListExt(list);
        return Result.ok(result);
    }

    /**
     * 保存货架
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/save")
    public Result save(@RequestBody TGoodsTypeCVO t) {
        TGoodsType tGoodsType = TGoodsTypeCopier.INSTANCE.asTGoodsType(t);
        tGoodsType.setShopId(getShopId());
        tGoodsTypeService.save(tGoodsType);
        return Result.ok();
    }

    /**
     * 更新货架
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/update")
    public Result update(@RequestBody TGoodsTypeUVO t) {
        TGoodsType tGoodsType = TGoodsTypeCopier.INSTANCE.asTGoodsType(t);
        tGoodsTypeService.update(tGoodsType);
        return Result.ok();
    }
}
