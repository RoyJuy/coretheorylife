package com.coretheorylife.modules.purchaser.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.gym.copier.TGymCopier;
import com.coretheorylife.modules.gym.entity.TGym;
import com.coretheorylife.modules.gym.service.TGymCoachService;
import com.coretheorylife.modules.gym.vo.TGymRVO;
import com.coretheorylife.modules.purchaser.copier.TPurchaserCopier;
import com.coretheorylife.modules.purchaser.entity.TPurchaser;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaser;
import com.coretheorylife.modules.purchaser.service.TPurchaserCoachGymService;
import com.coretheorylife.modules.purchaser.service.TPurchaserService;
import com.coretheorylife.modules.purchaser.vo.TPurchaserRVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserReSetAccountPasswordVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserReSetPasswordVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserUVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/purchaser/user")
public class TPurchaserController extends BaseController {

    @Autowired
    private TPurchaserService tPurchaserService;

    @Autowired
    private TPurchaserCoachGymService tPurchaserCoachGymService;

    @Autowired
    private TGymCoachService tGymCoachService;

    /**
     * 更新基本资料
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/update")
    public Result update(@RequestBody TPurchaserUVO t) {
        TPurchaser Purchaser = TPurchaserCopier.INSTANCE.asTPurchaser(t);
        Purchaser.setId(getPurchaserId());
        tPurchaserService.update(Purchaser);
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
    public Result reSetPassword(@RequestBody TPurchaserReSetPasswordVO t) {
        TPurchaser Purchaser = TPurchaserCopier.INSTANCE.asTPurchaser(t);
        Purchaser.setId(getPurchaserId());
        tPurchaserService.reSetPassword(Purchaser, t.getCode());
        return Result.ok();
    }

    /**
     * 重置密码
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/reSetWithdrawPassword")
    public Result reSetWithdrawPassword(@RequestBody TPurchaserReSetAccountPasswordVO t) {
        TPurchaser Purchaser = TPurchaserCopier.INSTANCE.asTPurchaser(t);
        Purchaser.setId(getPurchaserId());
        tPurchaserService.reSetWithdrawPassword(Purchaser, t.getCode());
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
        tPurchaserService.uploadAvatar(getPurchaserId(), request);
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
        tPurchaserService.uploadAvatarBase64(getPurchaserId(), request);
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
        ExtTPurchaser tPurchaser = tPurchaserService.queryObject(getPurchaserId());
        tPurchaser.setHaveCoach(tPurchaserService.queryMyCoach(getPurchaserId()) != null);
        tPurchaser.setHaveGym(tPurchaserService.queryMyGym(getPurchaserId()) != null);
        TPurchaserRVO rvo = TPurchaserCopier.INSTANCE.asTPurchaserRVOExt(tPurchaser);
        return Result.ok(rvo);
    }

    /**
     * 获取我的健身房
     *
     * @return
     */
    @WebLog
    @GetMapping("/queryMyGym")
    public Result queryMyGym() {
        TGym tGym = tPurchaserService.queryMyGym(getPurchaserId());
        TGymRVO rvo = TGymCopier.INSTANCE.asTGymRVO(tGym);
        return Result.ok(rvo);
    }

    /**
     * 获取我的教练
     *
     * @return
     */
    @WebLog
    @GetMapping("/queryMyCoach")
    public Result queryMyCoach() {
        TPurchaser tPurchaser = tPurchaserService.queryMyCoach(getPurchaserId());
        TPurchaserRVO rvo = TPurchaserCopier.INSTANCE.asTPurchaserRVO(tPurchaser);
        return Result.ok(rvo);
    }

    /**
     * 绑定教练
     *
     * @return
     */
    @WebLog
    @PostMapping("/bindCoach")
    public Result bindCoach(@NotNull(message = "教练id不能为空") Long coachId) {
        tPurchaserCoachGymService.bind(getPurchaserId(), coachId);
        return Result.ok();
    }

    /**
     * 解绑教练
     *
     * @return
     */
    @WebLog
    @PostMapping("/unbindCoach")
    public Result unbindCoach() {
        tPurchaserCoachGymService.unbind(getPurchaserId());
        return Result.ok();
    }

    /**
     * 用户绑定健身房
     *
     * @return
     */
    @WebLog
    @PostMapping("/bindGym")
    public Result bindGym(@NotNull(message = "健身房id不能为空") Long gymId) {
        tGymCoachService.bind(gymId, getPurchaserId());
        return Result.ok();
    }

    /**
     * 用户解绑健身房
     *
     * @return
     */
    @WebLog
    @PostMapping("/unbindGym")
    public Result unbindGym() {
        tGymCoachService.unbind(getPurchaserId());
        return Result.ok();
    }
}
