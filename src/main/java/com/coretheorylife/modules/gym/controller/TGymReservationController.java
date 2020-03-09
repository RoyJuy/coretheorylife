package com.coretheorylife.modules.gym.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.gym.service.TGymReservationService;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/gym/reservation")
public class TGymReservationController extends BaseController {

    @Autowired
    private TGymReservationService tGymReservationService;

    /**
     * 给某个预约指定教练
     *
     * @return
     */
    @WebLog
    @PostMapping("/assignationCoach")
    public Result assignationCoach(@NotNull(message = "预约单id不能为空") Long id, @NotNull(message = "教练不能为空") Long coachId) {
        tGymReservationService.assignationCoach(id, coachId);
        return Result.ok();
    }

    /**
     * 给某个预约更换教练
     *
     * @return
     */
    @WebLog
    @PostMapping("/changeCoach")
    public Result changeCoach(@NotNull(message = "预约单id不能为空") Long id, @NotNull(message = "教练不能为空") Long coachId) {
        tGymReservationService.changeCoach(id, coachId);
        return Result.ok();
    }

    /**
     * 预约签到
     *
     * @return
     */
    @WebLog
    @PostMapping("/reservationSignIn/{id}")
    public Result reservationSignIn(@PathVariable("id") Long id) {
        tGymReservationService.signIn(id);
        return Result.ok();
    }

    /**
     * 取消预约
     *
     * @return
     */
    @WebLog
    @PostMapping("/cancelReservation")
    public Result cancelReservation(@NotNull(message = "预约单id不能为空") Long id, @NotEmpty(message = "备注不能为空") String remark) {
        tGymReservationService.gymCancel(id, remark);
        return Result.ok();
    }
}
