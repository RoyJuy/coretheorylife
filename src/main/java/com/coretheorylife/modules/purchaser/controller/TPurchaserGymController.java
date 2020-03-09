package com.coretheorylife.modules.purchaser.controller;

import com.coretheorylife.common.annotation.AuthIgnore;
import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.AbstractController;
import com.coretheorylife.modules.gym.copier.TGymCopier;
import com.coretheorylife.modules.gym.copier.TGymReservationCopier;
import com.coretheorylife.modules.gym.entity.TGym;
import com.coretheorylife.modules.gym.entity.TGymExample;
import com.coretheorylife.modules.gym.entity.TGymReservation;
import com.coretheorylife.modules.gym.entity.ext.ExtTGym;
import com.coretheorylife.modules.gym.entity.ext.ExtTGymReservation;
import com.coretheorylife.modules.gym.service.TGymReservationService;
import com.coretheorylife.modules.gym.service.TGymService;
import com.coretheorylife.modules.gym.vo.TGymRVO;
import com.coretheorylife.modules.gym.vo.TGymReservationCVO;
import com.coretheorylife.modules.gym.vo.TGymReservationRVO;
import com.coretheorylife.modules.gym.vo.TGymReservationUVO;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/purchaser/gym")
public class TPurchaserGymController extends AbstractController<TGym, TGymExample> {

    @Autowired
    private TGymService tGymService;

    @Autowired
    private TGymReservationService tGymReservationService;

    /**
     * 查询健身房列表
     *
     * @param params
     * @return
     */
    @AuthIgnore
    @WebLog
    @GetMapping("/list")
    public Result list(@RequestParam Map<String, Object> params) {
        if (params.get("latitude") == null || params.get("longitude") == null) {
            throw new InvalidParameterException("经度和纬度不能为空");
        }
        params.put("deleteFlag", false);
        Query query = new Query(params);
        List<ExtTGym> list = tGymService.queryListByLocation(query);
        int total = tGymService.queryTotalByLocation(query);
        List<TGymRVO> result = TGymCopier.INSTANCE.asTGymRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }

    /**
     * 预约健身房
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/saveReservation")
    public Result saveReservation(@RequestBody TGymReservationCVO t) {
        TGymReservation tGymReservation = TGymReservationCopier.INSTANCE.asGymReservation(t);
        tGymReservation.setPurchaserId(getPurchaserId());
        if (tGymReservation.getPurchaserId().equals(t.getCoachId())) {
            throw new InvalidParameterException("不能自己预约自己哦~");
        }
        tGymReservationService.reserve(tGymReservation);
        return Result.ok();
    }

    /**
     * 修改预约
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/updateReservation")
    public Result updateReservation(@RequestBody TGymReservationUVO t) {
        TGymReservation tGymReservation = TGymReservationCopier.INSTANCE.asGymReservation(t);
        tGymReservationService.update(tGymReservation);
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
        tGymReservationService.purchaserCancel(id, remark);
        return Result.ok();
    }

    /**
     * 用户查询我的预约记录
     *
     * @param params
     * @return
     */
    @WebLog
    @GetMapping("/purchaserReservationList")
    public Result purchaserReservationList(@RequestParam Map<String, Object> params) {
        params.put("deleteFlag", false);
        params.put("purchaserId", getPurchaserId());
        Query query = new Query(params);
        List<ExtTGymReservation> list = tGymReservationService.queryList(query);
        int total = tGymReservationService.queryTotal(query);
        List<TGymReservationRVO> result = TGymReservationCopier.INSTANCE.asTGymReservationRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }

    /**
     * 教练查询我的预约记录
     *
     * @param params
     * @return
     */
    @WebLog
    @GetMapping("/coachReservationList")
    public Result coachReservationList(@RequestParam Map<String, Object> params) {
        params.put("deleteFlag", false);
        params.put("coachId", getPurchaserId());
        Query query = new Query(params);
        List<ExtTGymReservation> list = tGymReservationService.queryList(query);
        int total = tGymReservationService.queryTotal(query);
        List<TGymReservationRVO> result = TGymReservationCopier.INSTANCE.asTGymReservationRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }
}
