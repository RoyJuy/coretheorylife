package com.coretheorylife.modules.gym.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.AbstractController;
import com.coretheorylife.modules.gym.entity.TGymCoach;
import com.coretheorylife.modules.gym.entity.TGymCoachExample;
import com.coretheorylife.modules.gym.service.TGymCoachService;
import com.coretheorylife.modules.purchaser.copier.TPurchaserCopier;
import com.coretheorylife.modules.purchaser.entity.TPurchaser;
import com.coretheorylife.modules.purchaser.vo.TPurchaserRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/gym/coach")
public class TGymCoachController extends AbstractController<TGymCoach, TGymCoachExample> {

    @Autowired
    private TGymCoachService tGymCoachService;

    /**
     * 查询我的教练列表
     *
     * @return
     */
    @WebLog
    @GetMapping("/list")
    public Result list() {
        List<TPurchaser> list = tGymCoachService.selectCoachListByGymId(getGymId());
        List<TPurchaserRVO> result = TPurchaserCopier.INSTANCE.asTPurchaserRVOList(list);
        return Result.ok(result);
    }
}
