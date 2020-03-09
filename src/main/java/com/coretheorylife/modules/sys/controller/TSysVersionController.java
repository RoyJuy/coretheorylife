package com.coretheorylife.modules.sys.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.sys.service.TSysVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.Map;

@RestController
@RequestMapping("/sys/version")
public class TSysVersionController extends BaseController {

    @Autowired
    private TSysVersionService tSysVersionService;

    @WebLog
    @GetMapping("/queryUpdate")
    public Result queryUpdate(@NotBlank(message = "平台不能为空 IOS | ANDROID") String platform, @NotBlank(message = "版本号不能为空") String versionNo) {
        Map<String, Object> map =  tSysVersionService.checkVersion(platform, versionNo);
        return Result.ok(map);
    }

}
