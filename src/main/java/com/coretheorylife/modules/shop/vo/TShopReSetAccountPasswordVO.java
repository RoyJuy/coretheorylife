package com.coretheorylife.modules.shop.vo;

import org.hibernate.validator.constraints.NotBlank;

public class TShopReSetAccountPasswordVO {
    /**
     * 密码
     */
    @NotBlank(message = "提现密码不能为空")
    private String accountPassword;

    @NotBlank(message = "验证码不能为空")
    private String code;

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
