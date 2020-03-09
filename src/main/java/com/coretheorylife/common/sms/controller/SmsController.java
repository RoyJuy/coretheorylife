package com.coretheorylife.common.sms.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.common.sms.utils.SmsSender;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Connor 2019年11月20日
 * 验证码获取
 */
@Validated
@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    private SmsSender smsSender;

    @WebLog
    @PostMapping("/sendCode")
    public Result sendCode(@NotBlank(message = "手机号不能为空") String mobile) {
        smsSender.sendSms(mobile);
        return Result.ok();
    }
}
