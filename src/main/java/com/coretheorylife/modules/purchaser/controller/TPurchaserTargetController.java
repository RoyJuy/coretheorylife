package com.coretheorylife.modules.purchaser.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.DateUtils;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.AbstractController;
import com.coretheorylife.modules.purchaser.copier.TPurchaserTargetCopier;
import com.coretheorylife.modules.purchaser.copier.TPurchaserTargetLogCopier;
import com.coretheorylife.modules.purchaser.entity.TPurchaserTarget;
import com.coretheorylife.modules.purchaser.entity.TPurchaserTargetExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserTarget;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserTargetLog;
import com.coretheorylife.modules.purchaser.service.TPurchaserTargetLogService;
import com.coretheorylife.modules.purchaser.service.TPurchaserTargetService;
import com.coretheorylife.modules.purchaser.vo.TPurchaserTargetCVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserTargetLogRVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserTargetRVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserTargetUVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/purchaser/target")
public class TPurchaserTargetController extends AbstractController<TPurchaserTarget, TPurchaserTargetExample> {

    @Autowired
    private TPurchaserTargetService tPurchaserTargetService;

    @Autowired
    private TPurchaserTargetLogService tPurchaserTargetLogService;

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
        query.put("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        List<ExtTPurchaserTarget> list = tPurchaserTargetService.queryList(query);
        int total = tPurchaserTargetService.queryTotal(query);
        List<TPurchaserTargetRVO> result = TPurchaserTargetCopier.INSTANCE.asTPurchaserTargetRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }

    /**
     * 更新目标
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/update")
    public Result update(@RequestBody TPurchaserTargetUVO t) {
        TPurchaserTarget purchaserTarget = TPurchaserTargetCopier.INSTANCE.asTPurchaserTarget(t);
        tPurchaserTargetService.update(purchaserTarget);
        return Result.ok();
    }

    /**
     * 保存目标
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/save")
    public Result save(@RequestBody TPurchaserTargetCVO t) {
        TPurchaserTarget purchaserTarget = TPurchaserTargetCopier.INSTANCE.asTPurchaserTarget(t);
        purchaserTarget.setPurchaserId(getPurchaserId());
        tPurchaserTargetService.save(purchaserTarget);
        return Result.ok();
    }

    @WebLog
    @PostMapping("/saveLog/{targetId}")
    public Result saveLog(@PathVariable(value = "targetId") Long targetId) {
        TPurchaserTarget target = new TPurchaserTarget();
        target.setId(targetId);
        target.setLasttime(new Date());
        tPurchaserTargetService.update(target);
        tPurchaserTargetLogService.save(targetId, getPurchaserId());
        return Result.ok();
    }

    /**
     * 查询打卡列表
     *
     * @param params
     * @return
     */
    @WebLog
    @GetMapping("/logList")
    public Result logList(@RequestParam Map<String, Object> params) {
        params.put("deleteFlag", false);
        Query query = new Query(params);
        List<ExtTPurchaserTargetLog> list = tPurchaserTargetLogService.queryList(query);
        int total = tPurchaserTargetService.queryTotal(query);
        List<TPurchaserTargetLogRVO> result = TPurchaserTargetLogCopier.INSTANCE.asTPurchaserTargetLogRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }
}
