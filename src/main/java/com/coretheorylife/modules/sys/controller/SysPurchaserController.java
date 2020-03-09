package com.coretheorylife.modules.sys.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.purchaser.service.TPurchaserService;
import com.coretheorylife.modules.sys.vo.TPurchaserUVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/purchaser")
public class SysPurchaserController {

    @Autowired
    private TPurchaserService tPurchaserService;

    /**
     * 更新用户身份
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/updateProperty")
    public Result updateProperty(@RequestBody TPurchaserUVO t) {
        tPurchaserService.updateProperty(t.getPurchaserId(), t.getProperty());
        return Result.ok();
    }
}
