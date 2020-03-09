package com.coretheorylife.modules.purchaser.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.AbstractController;
import com.coretheorylife.modules.purchaser.copier.TPurchaserBankCopier;
import com.coretheorylife.modules.purchaser.entity.TPurchaserBank;
import com.coretheorylife.modules.purchaser.entity.TPurchaserBankExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserBank;
import com.coretheorylife.modules.purchaser.service.TPurchaserBankService;
import com.coretheorylife.modules.purchaser.vo.TPurchaserBankCVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserBankRVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserBankUVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/purchaser/bank")
public class TPurchaserBankController extends AbstractController<TPurchaserBank, TPurchaserBankExample> {

    @Autowired
    private TPurchaserBankService tPurchaserBankService;

    /**
     * 查询银行卡列表
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
        List<ExtTPurchaserBank> list = tPurchaserBankService.queryList(query);
        int total = tPurchaserBankService.queryTotal(query);
        List<TPurchaserBankRVO> result = TPurchaserBankCopier.INSTANCE.asTPurchaserBankRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
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
        tPurchaserBank.setPurchaserId(getPurchaserId());
        tPurchaserBankService.save(tPurchaserBank);
        return Result.ok();
    }

    /**
     * 更新银行卡
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/update")
    public Result update(@RequestBody TPurchaserBankUVO t) {
        TPurchaserBank tPurchaserBank = TPurchaserBankCopier.INSTANCE.asTPurchaserBank(t);
        tPurchaserBankService.update(tPurchaserBank);
        return Result.ok();
    }
}
