package com.coretheorylife.modules.shop.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.purchaser.copier.TPurchaserRateCopier;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserRate;
import com.coretheorylife.modules.purchaser.service.TPurchaserRateService;
import com.coretheorylife.modules.purchaser.vo.TPurchaserRateRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shop/rate")
public class TShopRateController extends BaseController {

    @Autowired
    private TPurchaserRateService tPurchaserRateService;

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
        params.put("shopId", getShopId());
        Query query = new Query(params);
        List<ExtTPurchaserRate> list = tPurchaserRateService.queryList(query);
        int total = tPurchaserRateService.queryTotal(query);
        List<TPurchaserRateRVO> result = TPurchaserRateCopier.INSTANCE.asTPurchaserRateRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }
}
