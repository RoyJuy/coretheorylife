package com.coretheorylife.modules.gym.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.DateUtils;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.gym.copier.TGymCopier;
import com.coretheorylife.modules.gym.entity.TGym;
import com.coretheorylife.modules.gym.service.TGymService;
import com.coretheorylife.modules.gym.vo.TGymRVO;
import com.coretheorylife.modules.gym.vo.TGymReSetAccountPasswordVO;
import com.coretheorylife.modules.gym.vo.TGymReSetPasswordVO;
import com.coretheorylife.modules.gym.vo.TGymUVO;
import com.coretheorylife.modules.purchaser.service.TPurchaserCoachGymLogService;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/gym/user")
public class TGymController extends BaseController {

    @Autowired
    private TGymService tGymService;

    @Autowired
    private TPurchaserCoachGymLogService tPurchaserCoachGymLogService;

    /**
     * 更新基本资料
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/update")
    public Result update(@RequestBody TGymUVO t) {
        TGym gym = TGymCopier.INSTANCE.asTGym(t);
        gym.setId(getGymId());
        tGymService.update(gym);
        return Result.ok();
    }

    /**
     * 更新状态
     *
     * @return
     */
    @WebLog
    @PostMapping("/updateStatus")
    public Result updateStatus(@NotNull(message = "状态不能为空") Integer status) {
        tGymService.updateStatus(getGymId(), status);
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
    public Result reSetPassword(@RequestBody TGymReSetPasswordVO t) {
        TGym gym = TGymCopier.INSTANCE.asTGym(t);
        gym.setId(getGymId());
        tGymService.reSetPassword(gym, t.getCode());
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
    public Result reSetWithdrawPassword(@RequestBody TGymReSetAccountPasswordVO t) {
        TGym gym = TGymCopier.INSTANCE.asTGym(t);
        gym.setId(getGymId());
        tGymService.reSetWithdrawPassword(gym, t.getCode());
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
        tGymService.uploadAvatarBase64(getGymId(), request);
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
        TGym tGym = tGymService.queryObject(getGymId());
        TGymRVO GymRVO = TGymCopier.INSTANCE.asTGymRVO(tGym);
        return Result.ok(GymRVO);
    }

    /**
     * 获取某天用户增长情况
     *
     * @return
     */
    @WebLog
    @GetMapping("/queryGymIncrease")
    public Result queryGymIncrease(String createDate) {
        if (createDate == null || createDate.isEmpty()) {
            createDate = DateUtils.getTodayStr();
        }
        int count = tPurchaserCoachGymLogService.queryGymIncrease(getGymId(), createDate);
        return Result.ok(count);
    }

    /**
     * 获取某天用户减少情况
     *
     * @return
     */
    @WebLog
    @GetMapping("/queryGymFewer")
    public Result queryGymFewer(String createDate) {
        if (createDate == null || createDate.isEmpty()) {
            createDate = DateUtils.getTodayStr();
        }
        int count = tPurchaserCoachGymLogService.queryGymFewer(getGymId(), createDate);
        return Result.ok(count);
    }

    /**
     * 获取某天用户减少情况
     *
     * @return
     */
    @WebLog
    @GetMapping("/queryEcharts")
    public Result queryEcharts(@NotBlank(message = "timeFrom不能为空") String timeFrom, @NotBlank(message = "timeFrom不能为空") String timeTo) {
        return Result.ok(tPurchaserCoachGymLogService.queryEcharts(timeFrom, timeTo, getGymId()));
    }
}
