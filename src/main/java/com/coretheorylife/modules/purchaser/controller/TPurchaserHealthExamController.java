package com.coretheorylife.modules.purchaser.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.purchaser.copier.TPurchaserHealthExamCopier;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthExam;
import com.coretheorylife.modules.purchaser.service.TPurchaserHealthExamService;
import com.coretheorylife.modules.purchaser.vo.TPurchaserHealthExamCVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchaser/health/exam")
public class TPurchaserHealthExamController extends BaseController {

    @Autowired
    private TPurchaserHealthExamService tPurchaserHealthExamService;

    /**
     * 保存健康资料
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/save")
    public Result save(@RequestBody TPurchaserHealthExamCVO t) {
        TPurchaserHealthExam purchaserHealth = TPurchaserHealthExamCopier.INSTANCE.asTPurchaserHealthExam(t);
        purchaserHealth.setPurchaserId(getPurchaserId());
        tPurchaserHealthExamService.save(purchaserHealth);
        return Result.ok();
    }

}
