package com.coretheorylife.modules.gym.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.AbstractController;
import com.coretheorylife.modules.gym.copier.TGymBankCopier;
import com.coretheorylife.modules.gym.entity.TGymBank;
import com.coretheorylife.modules.gym.entity.TGymBankExample;
import com.coretheorylife.modules.gym.entity.ext.ExtTGymBank;
import com.coretheorylife.modules.gym.service.TGymBankService;
import com.coretheorylife.modules.gym.vo.TGymBankCVO;
import com.coretheorylife.modules.gym.vo.TGymBankRVO;
import com.coretheorylife.modules.gym.vo.TGymBankUVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/gym/bank")
public class TGymBankController extends AbstractController<TGymBank, TGymBankExample> {

    @Autowired
    private TGymBankService tGymBankService;

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
        params.put("gymId", getGymId());
        Query query = new Query(params);
        List<ExtTGymBank> list = tGymBankService.queryList(query);
        int total = tGymBankService.queryTotal(query);
        List<TGymBankRVO> result = TGymBankCopier.INSTANCE.asTGymBankRVOListExt(list);
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
    public Result save(@RequestBody TGymBankCVO t) {
        TGymBank tGymBank = TGymBankCopier.INSTANCE.asGymBank(t);
        if (tGymBank.getType() == ExtTGymBank.TYPE_PRIVATE && (tGymBank.getBankName() == null || tGymBank.getBankName().isEmpty())) {
            throw new InvalidParameterException("私人账户必须录入bankName银行名称");
        }
        if (tGymBank.getType() == ExtTGymBank.TYPE_COMPANY && (tGymBank.getCompany() == null || tGymBank.getCompany().isEmpty())) {
            throw new InvalidParameterException("对公账户必须录入Company公司名称");
        }
        tGymBank.setGymId(getGymId());
        tGymBankService.save(tGymBank);
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
    public Result update(@RequestBody TGymBankUVO t) {
        TGymBank tGymBank = TGymBankCopier.INSTANCE.asGymBank(t);
        tGymBankService.update(tGymBank);
        return Result.ok();
    }
}
