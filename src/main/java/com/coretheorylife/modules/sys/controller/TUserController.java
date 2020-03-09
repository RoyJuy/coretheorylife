package com.coretheorylife.modules.sys.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.AbstractController;
import com.coretheorylife.modules.sys.copier.TUserCopier;
import com.coretheorylife.modules.sys.entity.TUser;
import com.coretheorylife.modules.sys.entity.TUserExample;
import com.coretheorylife.modules.sys.entity.ext.ExtTUser;
import com.coretheorylife.modules.sys.service.TUserService;
import com.coretheorylife.modules.sys.vo.TUserRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class TUserController extends AbstractController<TUser, TUserExample> {

    @Autowired
    private TUserService tUserService;

    /**
     * 查询用户列表
     *
     * @param params
     * @return
     */
    @WebLog
    @GetMapping("/list")
    public Result list(@RequestParam Map<String, Object> params) {
        params.put("deleteFlag", false);
        Query query = new Query(params);
        List<ExtTUser> list = tUserService.queryList(query);
        int total = tUserService.queryTotal(query);
        List<TUserRVO> result = TUserCopier.INSTANCE.asTUserRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }
}
