package com.coretheorylife.modules.shop;

import com.coretheorylife.common.annotation.AuthIgnore;
import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.exception.ErrorMapping;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.utils.RedisUtils;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.common.sms.entity.SmsRedisEntity;
import com.coretheorylife.common.sms.utils.SmsSender;
import com.coretheorylife.modules.shop.entity.TShop;
import com.coretheorylife.modules.shop.entity.TShopToken;
import com.coretheorylife.modules.shop.service.TShopService;
import com.coretheorylife.modules.shop.service.TShopTokenService;
import com.google.gson.Gson;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/shop")
public class ShopLoginController {
    @Autowired
    private TShopService tShopService;
    @Autowired
    private TShopTokenService tShopTokenService;
    @Autowired
    private RedisUtils redisUtils;

    @Value("${spring.profiles.active}")
    private String profiles;

    /**
     * 登录
     */
    @WebLog
    @PostMapping(value = "/login")
    @CrossOrigin
    @AuthIgnore
    public Result login(@NotNull(message = "用户名不能为空") String mobile, @NotNull(message = "密码不能为空") String password, String captcha) throws IOException {
        //用户信息
        TShop user = tShopService.queryByMobile(mobile);
        //账号不存在、密码错误
        if (user == null || !user.getPassword().equals(new Sha256Hash(password, user.getSort()).toHex())) {
            return Result.failAtClient("账号或密码不正确");
        }
        //生成token，并保存到数据库
        TShopToken token = tShopTokenService.createToken(user.getId());
        return Result.ok(token);
    }

    /**
     * 登录并注册
     */
    @WebLog
    @PostMapping(value = "/smslogin")
    @CrossOrigin
    @AuthIgnore
    public Result smsLogin(@NotNull(message = "用户名不能为空") String mobile, @NotNull(message = "密码不能为空") String code) {
        //用户信息
        TShop user = tShopService.queryByMobile(mobile);
        // 如果没有用户那么执行注册 后续的验证码是不可以继续使用了，所以就不验证了
        if (user == null) {
            TShop tShop = new TShop();
            tShop.setMobile(mobile);
            tShopService.register(tShop, code);
            user = tShopService.queryByMobile(mobile);
        } else {
            if (profiles.equals("test") || profiles.equals("dev")) {
                // 测试环境和开发环境不验证
            } else {
                String str = redisUtils.get(SmsSender.SMS_SEND_KEY_PREFIX + mobile);
                if (str != null) {
                    SmsRedisEntity smsRedisEntity = new Gson().fromJson(str, SmsRedisEntity.class);
                    // 没过期
                    if (!smsRedisEntity.getCode().equals(code)) {
                        throw new InvalidParameterException("验证码错误");
                    } else {
                        redisUtils.delete(SmsSender.SMS_SEND_KEY_PREFIX + mobile);
                    }
                } else {
                    throw new InvalidParameterException("手机号错误或验证码已过期");
                }
            }
        }
        //生成token，并保存到数据库
        TShopToken token = tShopTokenService.createToken(user.getId());
        return Result.ok(token);
    }
}
