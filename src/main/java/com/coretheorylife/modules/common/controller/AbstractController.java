package com.coretheorylife.modules.common.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.entity.BaseBean;
import com.coretheorylife.modules.common.example.BaseExample;
import com.coretheorylife.modules.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author Connor 2019年11月20日
 * Controller公共组件
 */
@Validated
@RestController
public abstract class AbstractController<T extends BaseBean, E extends BaseExample> extends BaseController {

    @Autowired
    private BaseService<T, E> baseService;

    @WebLog
    @PostMapping("/delete")
    public Result delete(@NotNull(message = "id不能为空") Long id) {
        baseService.delete(id);
        return Result.ok();
    }
}
