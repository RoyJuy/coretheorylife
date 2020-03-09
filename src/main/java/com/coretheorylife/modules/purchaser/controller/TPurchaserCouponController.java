package com.coretheorylife.modules.purchaser.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.purchaser.copier.TPurchaserCouponCopier;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserCoupon;
import com.coretheorylife.modules.purchaser.service.TPurchaserCouponService;
import com.coretheorylife.modules.purchaser.vo.TPurchaserCouponRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/purchaser/coupon")
public class TPurchaserCouponController extends BaseController {

    @Autowired
    private TPurchaserCouponService tPurchaserCouponService;

    /**
     * 查询优惠券列表
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
        List<ExtTPurchaserCoupon> list = tPurchaserCouponService.queryList(query);
        int total = tPurchaserCouponService.queryTotal(query);
        List<TPurchaserCouponRVO> result = TPurchaserCouponCopier.INSTANCE.asTPurchaserCouponRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }
}
