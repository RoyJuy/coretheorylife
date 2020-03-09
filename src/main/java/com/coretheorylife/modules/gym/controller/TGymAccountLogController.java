package com.coretheorylife.modules.gym.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.gym.copier.TGymAccountLogCopier;
import com.coretheorylife.modules.gym.entity.ext.ExtTGymAccountLog;
import com.coretheorylife.modules.gym.service.TGymAccountLogService;
import com.coretheorylife.modules.gym.vo.TGymAccountLogRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/gym/account/log")
public class TGymAccountLogController extends BaseController {

    @Autowired
    private TGymAccountLogService GymAccountLogService;

    /**
     * 查询账户日志
     *
     * @param params
     * @return
     */
    @WebLog
    @GetMapping("/list")
    public Result list(@RequestParam Map<String, Object> params) {
        params.put("deleteFlag", false);
        params.put("gymId", getGymId());
        Query query = new Query(params);
        List<ExtTGymAccountLog> list = GymAccountLogService.queryList(query);
        int total = GymAccountLogService.queryTotal(query);
        List<TGymAccountLogRVO> result = TGymAccountLogCopier.INSTANCE.asTGymAccountLogRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }

}
