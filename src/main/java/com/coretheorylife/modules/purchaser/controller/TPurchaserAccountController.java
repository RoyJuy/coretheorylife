package com.coretheorylife.modules.purchaser.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.purchaser.copier.TPurchaserAccountCopier;
import com.coretheorylife.modules.purchaser.entity.TPurchaserAccount;
import com.coretheorylife.modules.purchaser.service.TPurchaserAccountService;
import com.coretheorylife.modules.purchaser.vo.TPurchaserAccountRVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserWithdrawVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchaser/account")
public class TPurchaserAccountController extends BaseController {

    @Autowired
    private TPurchaserAccountService tPurchaserAccountService;

    /**
     * 获取基本信息
     *
     * @return
     */
    @WebLog
    @GetMapping("/info")
    public Result info() {
        TPurchaserAccount tPurchaserAccount = tPurchaserAccountService.initAccount(getPurchaserId());
        TPurchaserAccountRVO rvo = TPurchaserAccountCopier.INSTANCE.asTPurchaserAccountRVO(tPurchaserAccount);
        return Result.ok(rvo);
    }

    /**
     * 用户提现
     *
     * @param vo
     * @return
     */
    @WebLog
    @PostMapping("/withdraw")
    public Result withdraw(@RequestBody TPurchaserWithdrawVO vo) {
        tPurchaserAccountService.withDraw(vo.getMoney(), vo.getCardId(), getPurchaserId(), vo.getAccountPassword());
        return Result.ok();
    }
}
