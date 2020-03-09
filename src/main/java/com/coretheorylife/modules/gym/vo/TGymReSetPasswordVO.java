package com.coretheorylife.modules.gym.vo;

import org.hibernate.validator.constraints.NotBlank;

public class TGymReSetPasswordVO {
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "验证码不能为空")
    private String code;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
