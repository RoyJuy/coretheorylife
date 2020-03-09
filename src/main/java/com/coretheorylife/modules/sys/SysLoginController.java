package com.coretheorylife.modules.sys;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.exception.ErrorMapping;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.sys.entity.TUser;
import com.coretheorylife.modules.sys.entity.TUserToken;
import com.coretheorylife.modules.sys.service.TUserService;
import com.coretheorylife.modules.sys.service.TUserTokenService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.io.IOException;

/**
 * 登录相关
 */
@RestController
@Validated
@RequestMapping("/sys")
public class SysLoginController {
    @Autowired
    private TUserService tUserService;
    @Autowired
    private TUserTokenService tUserTokenService;

    /**
     * 登录
     */
    @WebLog
    @PostMapping(value = "/login")
    @CrossOrigin
    public Result login(@NotNull(message = "用户名不能为空") String username, @NotNull(message = "密码不能为空") String password, String captcha) throws IOException {
        //用户信息
        TUser user = tUserService.queryByMobile(username);

        //账号不存在、密码错误
        if (user == null || !user.getPassword().equals(new Sha256Hash(password, user.getSort()).toHex())) {
            return Result.failAtClient("账号或密码不正确");
        }
        //账号锁定
        if (user.getStatus() == 0) {
            return Result.failAtClient("账号已被锁定,请联系管理员");
        }
        //生成token，并保存到数据库
		TUserToken token = tUserTokenService.createToken(user.getId());
        return Result.ok(token);
    }

}
