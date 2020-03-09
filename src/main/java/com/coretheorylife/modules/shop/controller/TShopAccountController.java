package com.coretheorylife.modules.shop.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.shop.copier.TShopAccountCopier;
import com.coretheorylife.modules.shop.entity.TShopAccount;
import com.coretheorylife.modules.shop.service.TShopAccountService;
import com.coretheorylife.modules.shop.vo.TShopAccountRVO;
import com.coretheorylife.modules.shop.vo.TShopWithdrawVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop/account")
public class TShopAccountController extends BaseController {

    @Autowired
    private TShopAccountService tShopAccountService;

    /**
     * 获取基本信息
     *
     * @return
     */
    @WebLog
    @GetMapping("/info")
    public Result info() {
        TShopAccount tShopAccount = tShopAccountService.initAccount(getShopId());
        TShopAccountRVO rvo = TShopAccountCopier.INSTANCE.asTShopAccountRVO(tShopAccount);
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
    public Result withdraw(@RequestBody TShopWithdrawVO vo) {
        tShopAccountService.withDraw(vo.getMoney(), vo.getCardId(), getShopId(), vo.getAccountPassword());
        return Result.ok();
    }
}
