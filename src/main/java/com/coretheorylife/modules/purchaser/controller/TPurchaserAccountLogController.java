package com.coretheorylife.modules.purchaser.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.purchaser.copier.TPurchaserAccountLogCopier;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserAccountLog;
import com.coretheorylife.modules.purchaser.service.TPurchaserAccountLogService;
import com.coretheorylife.modules.purchaser.vo.TPurchaserAccountLogRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/purchaser/account/log")
public class TPurchaserAccountLogController extends BaseController {

    @Autowired
    private TPurchaserAccountLogService tPurchaserAccountLogService;

    /**
     * 查询日志列表
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
        List<ExtTPurchaserAccountLog> list = tPurchaserAccountLogService.queryList(query);
        int total = tPurchaserAccountLogService.queryTotal(query);
        List<TPurchaserAccountLogRVO> result = TPurchaserAccountLogCopier.INSTANCE.asTPurchaserAccountLogRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }
}
