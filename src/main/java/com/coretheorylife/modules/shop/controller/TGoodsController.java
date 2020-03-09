package com.coretheorylife.modules.shop.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.AbstractController;
import com.coretheorylife.modules.shop.copier.TGoodsCopier;
import com.coretheorylife.modules.shop.entity.TGoods;
import com.coretheorylife.modules.shop.entity.TGoodsExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoods;
import com.coretheorylife.modules.shop.service.TGoodsService;
import com.coretheorylife.modules.shop.vo.TGoodsCVO;
import com.coretheorylife.modules.shop.vo.TGoodsUVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/shop/goods")
public class TGoodsController extends AbstractController<TGoods, TGoodsExample> {

    @Autowired
    private TGoodsService tGoodsService;

    /**
     * 保存商品
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/save")
    public Result save(@RequestBody TGoodsCVO t) {
        ExtTGoods tGoods = TGoodsCopier.INSTANCE.asTGoods(t);
        tGoods.setShopId(getShopId());
        tGoodsService.save(tGoods);
        return Result.ok();
    }

    /**
     * 更新商品
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/update")
    public Result update(@RequestBody TGoodsUVO t) {
        ExtTGoods tGoods = TGoodsCopier.INSTANCE.asTGoods(t);
        tGoods.setShopId(getShopId());
        tGoodsService.update(tGoods);
        return Result.ok();
    }

    /**
     * 上架商品 上架和下架是分开的接口
     *
     * @return
     */
    @WebLog
    @PostMapping("/shelf/{goodsId}")
    public Result shelf(@PathVariable("goodsId") Long goodsId) {
        tGoodsService.shelf(goodsId);
        return Result.ok();
    }

    /**
     * 下架商品 上架和下架是分开的接口
     *
     * @return
     */
    @WebLog
    @PostMapping("/obtained/{goodsId}")
    public Result obtained(@PathVariable("goodsId") Long goodsId) {
        tGoodsService.obtained(goodsId);
        return Result.ok();
    }

    /**
     * 上传图片
     *
     * @return
     */
    @WebLog
    @PostMapping("/uploadBase64")
    public Result uploadBase64(HttpServletRequest request, Long goodsId) {
        String url = tGoodsService.uploadBase64(goodsId, request);
        return Result.ok(url);
    }
}
