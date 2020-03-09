package com.coretheorylife.modules.shop.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.AbstractController;
import com.coretheorylife.modules.shop.copier.TShopBankCopier;
import com.coretheorylife.modules.shop.entity.TShopBank;
import com.coretheorylife.modules.shop.entity.TShopBankExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTShopBank;
import com.coretheorylife.modules.shop.service.TShopBankService;
import com.coretheorylife.modules.shop.vo.TShopBankCVO;
import com.coretheorylife.modules.shop.vo.TShopBankRVO;
import com.coretheorylife.modules.shop.vo.TShopBankUVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shop/bank")
public class TShopBankController extends AbstractController<TShopBank, TShopBankExample> {

    @Autowired
    private TShopBankService tShopBankService;

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
        List<ExtTShopBank> list = tShopBankService.queryList(query);
        int total = tShopBankService.queryTotal(query);
        List<TShopBankRVO> result = TShopBankCopier.INSTANCE.asTShopBankRVOListExt(list);
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
    public Result save(@RequestBody TShopBankCVO t) {
        TShopBank tShopBank = TShopBankCopier.INSTANCE.asShopBank(t);
        tShopBank.setShopId(getShopId());
        tShopBankService.save(tShopBank);
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
    public Result update(@RequestBody TShopBankUVO t) {
        TShopBank tShopBank = TShopBankCopier.INSTANCE.asShopBank(t);
        tShopBankService.update(tShopBank);
        return Result.ok();
    }
}
