package com.coretheorylife.modules.purchaser.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.purchaser.copier.TPurchaserEnvelopeCopier;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserEnvelope;
import com.coretheorylife.modules.purchaser.service.TPurchaserEnvelopeService;
import com.coretheorylife.modules.purchaser.vo.TPurchaserEnvelopeRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/purchaser/envelope")
public class TPurchaserEnvelopeController extends BaseController {

    @Autowired
    private TPurchaserEnvelopeService tPurchaserEnvelopeService;

    /**
     * 查询红包列表
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
        List<ExtTPurchaserEnvelope> list = tPurchaserEnvelopeService.queryList(query);
        int total = tPurchaserEnvelopeService.queryTotal(query);
        List<TPurchaserEnvelopeRVO> result = TPurchaserEnvelopeCopier.INSTANCE.asTPurchaserEnvelopeRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }
}
