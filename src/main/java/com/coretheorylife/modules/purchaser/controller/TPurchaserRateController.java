package com.coretheorylife.modules.purchaser.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.AbstractController;
import com.coretheorylife.modules.purchaser.copier.TPurchaserRateCopier;
import com.coretheorylife.modules.purchaser.entity.TPurchaserRate;
import com.coretheorylife.modules.purchaser.entity.TPurchaserRateExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserRate;
import com.coretheorylife.modules.purchaser.service.TPurchaserRateService;
import com.coretheorylife.modules.purchaser.vo.TPurchaserRateCVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserRateRVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserRateUVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/purchaser/rate")
public class TPurchaserRateController extends AbstractController<TPurchaserRate, TPurchaserRateExample> {

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
        params.put("purchaserId", getPurchaserId());
        Query query = new Query(params);
        List<ExtTPurchaserRate> list = tPurchaserRateService.queryList(query);
        int total = tPurchaserRateService.queryTotal(query);
        List<TPurchaserRateRVO> result = TPurchaserRateCopier.INSTANCE.asTPurchaserRateRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }

    /**
     * 更新评价
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/update")
    public Result update(@RequestBody TPurchaserRateUVO t) {
        TPurchaserRate purchaserRate = TPurchaserRateCopier.INSTANCE.asTPurchaserRate(t);
        tPurchaserRateService.update(purchaserRate);
        return Result.ok();
    }

    /**
     * 保存评价
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/save")
    public Result save(@RequestBody TPurchaserRateCVO t) {
        TPurchaserRate purchaserRate = TPurchaserRateCopier.INSTANCE.asTPurchaserRate(t);
        purchaserRate.setPurchaserId(getPurchaserId());
        tPurchaserRateService.save(purchaserRate);
        return Result.ok();
    }
}
