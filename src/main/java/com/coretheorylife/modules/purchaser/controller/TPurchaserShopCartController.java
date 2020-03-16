package com.coretheorylife.modules.purchaser.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.AbstractController;
import com.coretheorylife.modules.purchaser.copier.TPurchaserShopCartCopier;
import com.coretheorylife.modules.purchaser.entity.TPurchaserShopCart;
import com.coretheorylife.modules.purchaser.entity.TPurchaserShopCartExample;
import com.coretheorylife.modules.purchaser.service.TPurchaserShopCartService;
import com.coretheorylife.modules.purchaser.vo.TPurchaserShopCartCVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserShopCartUVO;
import com.coretheorylife.modules.shop.copier.TShopCopier;
import com.coretheorylife.modules.shop.entity.ext.ExtTShop;
import com.coretheorylife.modules.shop.vo.TShopRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/purchaser/shopcart")
public class TPurchaserShopCartController extends AbstractController<TPurchaserShopCart, TPurchaserShopCartExample> {

    @Autowired
    private TPurchaserShopCartService tPurchaserShopCartService;

    /**
     * 查询列表
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
        List<ExtTShop> list = tPurchaserShopCartService.queryList(query);
        int total = tPurchaserShopCartService.queryTotal(query);
        List<TShopRVO> result = TShopCopier.INSTANCE.asTShopRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }


    /**
     * 更新购物车
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/update")
    public Result update(@RequestBody TPurchaserShopCartUVO t) {
        TPurchaserShopCart purchaserShopCart = TPurchaserShopCartCopier.INSTANCE.asTPurchaserShopCart(t);
        tPurchaserShopCartService.update(purchaserShopCart);
        return Result.ok();
    }

    /**
     * 添加购物车
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/save")
    public Result save(@RequestBody TPurchaserShopCartCVO t) {
        TPurchaserShopCart purchaserShopCart = TPurchaserShopCartCopier.INSTANCE.asTPurchaserShopCart(t);
        purchaserShopCart.setPurchaserId(getPurchaserId());
        tPurchaserShopCartService.save(purchaserShopCart);
        return Result.ok();
    }
}
