package com.coretheorylife.modules.purchaser.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.purchaser.copier.TPurchaserHealthCopier;
import com.coretheorylife.modules.purchaser.copier.TPurchaserHealthLogCopier;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealth;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthLog;
import com.coretheorylife.modules.purchaser.entity.ext.ExtHealthTools;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserHealth;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserHealthLog;
import com.coretheorylife.modules.purchaser.service.TPurchaserHealthLogService;
import com.coretheorylife.modules.purchaser.service.TPurchaserHealthService;
import com.coretheorylife.modules.purchaser.vo.TPurchaserHealthCVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserHealthLogRVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserHealthRVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserHealthUVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchaser/health")
public class TPurchaserHealthController extends BaseController {

    @Autowired
    private TPurchaserHealthService tPurchaserHealthService;

    @Autowired
    private TPurchaserHealthLogService tPurchaserHealthLogService;
    /**
     * 保存健康资料
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/save")
    public Result save(@RequestBody TPurchaserHealthCVO t) {
        ExtTPurchaserHealth purchaserHealth = TPurchaserHealthCopier.INSTANCE.asTPurchaserHealthExt(t);
        purchaserHealth.setPurchaserId(getPurchaserId());
        TPurchaserHealth tPurchaser = tPurchaserHealthService.save(purchaserHealth);
        TPurchaserHealthRVO rvo = TPurchaserHealthCopier.INSTANCE.asTPurchaserHealthRVO(tPurchaser);
        return Result.ok(rvo);
    }

    /**
     * 修改健康资料
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/updateAfterSave")
    public Result updateAfterSave(@RequestBody TPurchaserHealthUVO t) {
        TPurchaserHealth purchaserHealth = TPurchaserHealthCopier.INSTANCE.asTPurchaserHealth(t);
        purchaserHealth.setPurchaserId(getPurchaserId());
        TPurchaserHealth tPurchaser = tPurchaserHealthService.updateAfterSave(purchaserHealth);
        TPurchaserHealthRVO rvo = TPurchaserHealthCopier.INSTANCE.asTPurchaserHealthRVO(tPurchaser);
        return Result.ok(rvo);
    }

    /**
     * 获取基本信息
     *
     * @return
     */
    @WebLog
    @GetMapping("/info")
    public Result info() {
        TPurchaserHealth tPurchaser = tPurchaserHealthService.queryObjectByPurchaserId(getPurchaserId());
        TPurchaserHealthRVO rvo = TPurchaserHealthCopier.INSTANCE.asTPurchaserHealthRVO(tPurchaser);
        return Result.ok(rvo);
    }

    /**
     * 看看今天吃饱了没
     *
     * @return
     */
    @WebLog
    @GetMapping("/healthLogInfo")
    public Result healthLogInfo(String time) {
        ExtTPurchaserHealthLog tPurchaserHealthLog = tPurchaserHealthLogService.queryByTime(time, getPurchaserId(), true);
        TPurchaserHealthLogRVO rvo = TPurchaserHealthLogCopier.INSTANCE.asTPurchaserHealthLogRVO(tPurchaserHealthLog);
        return Result.ok(rvo);
    }

    /**
     * 健康管理
     *
     * @return
     */
    @WebLog
    @GetMapping("/healthManagement")
    public Result healthManagement(String time) {
        List<ExtHealthTools> queryTools = tPurchaserHealthLogService.queryTools(time, getPurchaserId(), false);
        return Result.ok(queryTools);
    }
}
