package com.coretheorylife;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.purchaser.copier.TPurchaserBankCopier;
import com.coretheorylife.modules.purchaser.entity.TPurchaserBank;
import com.coretheorylife.modules.purchaser.entity.TPurchaserBankExample;
import com.coretheorylife.modules.purchaser.service.TPurchaserBankService;
import com.coretheorylife.modules.purchaser.vo.TPurchaserBankCVO;
import com.coretheorylife.modules.shop.vo.TGoodsCVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Connor 2019年11月20日
 * 说明：
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    BaseService<TPurchaserBank, TPurchaserBankExample> purchaserBankService;

    @Autowired
    private TPurchaserBankService service;

    @RequestMapping("/annoTest")
    public Result mqTest(@RequestBody TGoodsCVO cvo) {
        return Result.ok();
    }

    /**
     * 保存银行卡
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/save")
    public Result save(@RequestBody TPurchaserBankCVO t) {
        TPurchaserBank tPurchaserBank = TPurchaserBankCopier.INSTANCE.asTPurchaserBank(t);
        tPurchaserBank.setPurchaserId(8L);
        purchaserBankService.save(tPurchaserBank);
        return Result.ok();
    }

    /**
     * 保存银行卡
     *
     * @return
     */
    @WebLog
    @PostMapping("/delete")
    public Result delete() {
        purchaserBankService.delete(5L);
        return Result.ok();
    }
}
