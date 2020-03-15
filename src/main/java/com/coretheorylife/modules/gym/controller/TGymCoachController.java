package com.coretheorylife.modules.gym.controller;

import com.coretheorylife.common.annotation.AuthIgnore;
import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.AbstractController;
import com.coretheorylife.modules.gym.entity.TGymCoach;
import com.coretheorylife.modules.gym.entity.TGymCoachExample;
import com.coretheorylife.modules.gym.service.TGymCoachService;
import com.coretheorylife.modules.purchaser.common.CoachTagsType;
import com.coretheorylife.modules.purchaser.copier.TPurchaserCopier;
import com.coretheorylife.modules.purchaser.dao.CoachTagMapper;
import com.coretheorylife.modules.purchaser.entity.CoachTagPO;
import com.coretheorylife.modules.purchaser.entity.TPurchaser;
import com.coretheorylife.modules.purchaser.param.CoachTagQueryParam;
import com.coretheorylife.modules.purchaser.vo.TPurchaserRVO;
import com.mchange.lang.LongUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/gym/coach")
public class TGymCoachController extends AbstractController<TGymCoach, TGymCoachExample> {

    @Autowired
    private TGymCoachService tGymCoachService;

    @Autowired
    private CoachTagMapper coachTagMapper;

    /**
     * 查询我的教练列表
     *
     * @return
     */
    @WebLog
    @GetMapping("/list")
    @AuthIgnore
    public Result list(@RequestParam(value = "gymId", required = false)Long gymId) {
        if (gymId == null){
            gymId = getGymId();
        }
        List<TPurchaser> list = tGymCoachService.selectCoachListByGymId(gymId);
        List<TPurchaserRVO> result = TPurchaserCopier.INSTANCE.asTPurchaserRVOList(list);
        if (!CollectionUtils.isEmpty(result)){
            for (TPurchaserRVO tPurchaserRVO : result){

                CoachTagQueryParam coachTagQueryParam = new CoachTagQueryParam();
                coachTagQueryParam.setCoachId(tPurchaserRVO.getId());

                List<CoachTagPO> tagPOs = coachTagMapper.findAll(coachTagQueryParam);

                if (!CollectionUtils.isEmpty(tagPOs)){
                    Map<String, List<CoachTagPO>> maps = tagPOs.stream().collect(Collectors.groupingBy(CoachTagPO::getTagType));

                    tPurchaserRVO.setTags(maps.get(CoachTagsType.TAG.name()));
                    tPurchaserRVO.setAdvantages(maps.get(CoachTagsType.ADVANTAGE.name()));
                }

            }
        }
        return Result.ok(result);
    }

    /**
     * 查询我的教练列表
     *
     * @return
     */
    @WebLog
    @GetMapping("/list1")
    public Result list1() {

        List<TPurchaser> list = tGymCoachService.selectCoachListByGymId(getGymId());
        List<TPurchaserRVO> result = TPurchaserCopier.INSTANCE.asTPurchaserRVOList(list);
        return Result.ok(result);
    }
}
