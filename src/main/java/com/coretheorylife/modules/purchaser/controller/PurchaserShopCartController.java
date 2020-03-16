package com.coretheorylife.modules.purchaser.controller;

import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.AbstractController;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.purchaser.service.impl.PurchaserShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * PurchaserShopCartController
 *
 * @author zhuhaitao
 * @since 2020-03-16
 */
@RestController
public class PurchaserShopCartController extends BaseController {

    @Autowired
    private PurchaserShopCartService purchaserShopCartService;

    @RequestMapping(value = "/v1/purchaser_shop_carts", method = RequestMethod.GET)
    public Result findPurchaserShopCarts(){
        return Result.ok(purchaserShopCartService.findShopCartByPurchaserId(getPurchaserId()));
    }
}
