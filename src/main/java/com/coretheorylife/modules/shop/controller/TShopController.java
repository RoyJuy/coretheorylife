package com.coretheorylife.modules.shop.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.shop.copier.TShopCopier;
import com.coretheorylife.modules.shop.entity.TShop;
import com.coretheorylife.modules.shop.service.TShopService;
import com.coretheorylife.modules.shop.vo.TShopRVO;
import com.coretheorylife.modules.shop.vo.TShopReSetAccountPasswordVO;
import com.coretheorylife.modules.shop.vo.TShopReSetPasswordVO;
import com.coretheorylife.modules.shop.vo.TShopUVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@RestController
@RequestMapping("/shop/user")
public class TShopController extends BaseController {

    @Autowired
    private TShopService tShopService;

    /**
     * 更新基本资料
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/update")
    public Result update(@RequestBody TShopUVO t) {
        TShop shop = TShopCopier.INSTANCE.asTShop(t);
        shop.setId(getShopId());
        tShopService.update(shop);
        return Result.ok();
    }

    /**
     * 更新基本资料
     *
     * @return
     */
    @WebLog
    @PostMapping("/updateStatus")
    public Result updateStatus(@NotNull(message = "状态不能为空") Integer status) {
        tShopService.updateStatus(getShopId(), status);
        return Result.ok();
    }

    /**
     * 重置密码
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/reSetPassword")
    public Result reSetPassword(@RequestBody TShopReSetPasswordVO t) {
        TShop shop = TShopCopier.INSTANCE.asTShop(t);
        shop.setId(getShopId());
        tShopService.reSetPassword(shop, t.getCode());
        return Result.ok();
    }

    /**
     * 重置提现密码
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/reSetWithdrawPassword")
    public Result reSetWithdrawPassword(@RequestBody TShopReSetAccountPasswordVO t) {
        TShop shop = TShopCopier.INSTANCE.asTShop(t);
        shop.setId(getShopId());
        tShopService.reSetWithdrawPassword(shop, t.getCode());
        return Result.ok();
    }

    /**
     * 上传头像
     *
     * @return
     */
    @WebLog
    @PostMapping("/uploadAvatar")
    public Result uploadAvatar(HttpServletRequest request) {
        tShopService.uploadAvatar(getShopId(), request);
        return Result.ok();
    }

    /**
     * 上传头像
     *
     * @return
     */
    @WebLog
    @PostMapping("/uploadAvatarBase64")
    public Result uploadAvatarBase64(HttpServletRequest request) {
        tShopService.uploadAvatarBase64(getShopId(), request);
        return Result.ok();
    }

    /**
     * 获取基本信息
     *
     * @return
     */
    @WebLog
    @GetMapping("/info")
    public Result info() {
        TShop tShop = tShopService.queryObject(getShopId());
        TShopRVO shopRVO = TShopCopier.INSTANCE.asTShopRVO(tShop);
        return Result.ok(shopRVO);
    }

    /**
     * 获取评分
     *
     * @return
     */
    @WebLog
    @GetMapping("/avgRate")
    public Result avgRate() {
        BigDecimal rate = tShopService.queryAvgRate(getShopId());
        return Result.ok().put("rate", rate);
    }
}
