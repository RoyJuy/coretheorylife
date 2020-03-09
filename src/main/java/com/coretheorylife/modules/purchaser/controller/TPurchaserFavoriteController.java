package com.coretheorylife.modules.purchaser.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.AbstractController;
import com.coretheorylife.modules.purchaser.copier.TPurchaserFavoriteCopier;
import com.coretheorylife.modules.purchaser.entity.TPurchaserFavorite;
import com.coretheorylife.modules.purchaser.entity.TPurchaserFavoriteExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserFavorite;
import com.coretheorylife.modules.purchaser.service.TPurchaserFavoriteService;
import com.coretheorylife.modules.purchaser.vo.TPurchaserFavoriteRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/purchaser/favorite")
public class TPurchaserFavoriteController extends AbstractController<TPurchaserFavorite, TPurchaserFavoriteExample> {

    @Autowired
    private TPurchaserFavoriteService tPurchaserFavoriteService;

    /**
     * 查询收藏列表
     *
     * @param params
     * @return
     */
    @WebLog
    @GetMapping("/list")
    public Result list(@RequestParam Map<String, Object> params) {
        params.put("deleteFlag", false);
        params.put("purchaserId", getPurchaserId());
        Query query = new Query(params);
        List<ExtTPurchaserFavorite> list = tPurchaserFavoriteService.queryList(query);
        int total = tPurchaserFavoriteService.queryTotal(query);
        List<TPurchaserFavoriteRVO> result = TPurchaserFavoriteCopier.INSTANCE.asTPurchaserFavoriteRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }

    /**
     * 收藏店铺
     *
     * @return
     */
    @WebLog
    @PostMapping("/save/{shopId}")
    public Result save(@PathVariable(value = "shopId") Long shopId) {
        TPurchaserFavorite tPurchaserFavorite = new TPurchaserFavorite();
        tPurchaserFavorite.setPurchaserId(getPurchaserId());
        tPurchaserFavorite.setShopId(shopId);
        tPurchaserFavoriteService.save(tPurchaserFavorite);
        return Result.ok();
    }
}
