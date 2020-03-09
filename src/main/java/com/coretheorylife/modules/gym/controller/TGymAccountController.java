package com.coretheorylife.modules.gym.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.gym.copier.TGymAccountCopier;
import com.coretheorylife.modules.gym.entity.TGymAccount;
import com.coretheorylife.modules.gym.service.TGymAccountService;
import com.coretheorylife.modules.gym.vo.TGymAccountRVO;
import com.coretheorylife.modules.gym.vo.TGymWithdrawVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gym/account")
public class TGymAccountController extends BaseController {

    @Autowired
    private TGymAccountService tGymAccountService;

    /**
     * 获取基本信息
     *
     * @return
     */
    @WebLog
    @GetMapping("/info")
    public Result info() {
        TGymAccount tGymAccount = tGymAccountService.initAccount(getGymId());
        TGymAccountRVO rvo = TGymAccountCopier.INSTANCE.asTGymAccountRVO(tGymAccount);
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
    public Result withdraw(@RequestBody TGymWithdrawVO vo) {
        tGymAccountService.withDraw(vo.getMoney(), vo.getCardId(), getGymId(), vo.getAccountPassword());
        return Result.ok();
    }
}
