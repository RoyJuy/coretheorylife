package com.coretheorylife.modules.purchaser.controller;

import com.coretheorylife.common.annotation.AuthIgnore;
import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.utils.DateUtils;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.AbstractController;
import com.coretheorylife.modules.shop.copier.TGoodsCopier;
import com.coretheorylife.modules.shop.copier.TGoodsTypeCopier;
import com.coretheorylife.modules.shop.copier.TShopCopier;
import com.coretheorylife.modules.shop.entity.TShop;
import com.coretheorylife.modules.shop.entity.TShopExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoods;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoodsType;
import com.coretheorylife.modules.shop.entity.ext.ExtTShop;
import com.coretheorylife.modules.shop.service.TGoodsService;
import com.coretheorylife.modules.shop.service.TGoodsTypeService;
import com.coretheorylife.modules.shop.service.TShopService;
import com.coretheorylife.modules.shop.vo.TGoodsRVO;
import com.coretheorylife.modules.shop.vo.TGoodsTypeRVO;
import com.coretheorylife.modules.shop.vo.TShopRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/purchaser/shop")
public class TPurchaserShopController extends AbstractController<TShop, TShopExample> {

    @Autowired
    private TShopService tShopService;

    @Autowired
    private TGoodsService tGoodsService;

    @Autowired
    private TGoodsTypeService tGoodsTypeService;

    /**
     * 查询用户列表
     *
     * @param params
     * @return
     */
    @AuthIgnore
    @WebLog
    @GetMapping("/list")
    public Result list(@RequestParam Map<String, Object> params) {
        if (params.get("latitude") == null || params.get("longitude") == null) {
            throw new InvalidParameterException("经度和纬度不能为空");
        }
        params.put("deleteFlag", false);
        params.put("status", ExtTShop.STATUS_OPEN + ", " + ExtTShop.STATUS_REST);
        params.put("goodsStatus", ExtTGoods.STATUS_SHELF);
        params.put("countDateFrom", DateUtils.getMonthBegin());
        Query query = new Query(params);
        List<ExtTShop> list = tShopService.queryListByLocation(query);
        int total = tShopService.queryTotalByLocation(query);
        List<TShopRVO> result = TShopCopier.INSTANCE.asTShopRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }

    @AuthIgnore
    @WebLog
    @GetMapping("/selectGoods")
    public Result selectGoods(@NotNull(message = "shopId不能为空") Long shopId, String goodsName) {
        if (goodsName == null || goodsName.equals("")) {
            return Result.ok(new ArrayList<>());
        }
        List<ExtTGoods> list = tGoodsService.selectGoodByShopIdOrGoodsName(goodsName, shopId);
        List<TGoodsRVO> rvo = TGoodsCopier.INSTANCE.asTGoodsRVOList(list);
        return Result.ok(rvo);
    }

    /**
     * 查询所有产品列表
     *
     * @return
     */
    @AuthIgnore
    @WebLog
    @GetMapping("/shopDetail")
    public Result shopDetail(@RequestParam Map<String, Object> params) {
        params.put("deleteFlag", false);
        params.put("shopId", params.get("shopId") == null ? 0L : params.get("shopId"));
        // 设置这个是为了sql中left join货物，用于显示没有商品在的货架
        params.put("isShop", params.get("shopId") == null);
        List<ExtTGoodsType> list = tGoodsTypeService.queryAllGoodByShopId(params);
        List<TGoodsTypeRVO> result = TGoodsTypeCopier.INSTANCE.asTGoodsTypeRVOListExt(list);
        return Result.ok(result);
    }
}
