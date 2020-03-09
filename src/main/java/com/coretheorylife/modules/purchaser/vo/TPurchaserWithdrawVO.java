package com.coretheorylife.modules.purchaser.vo;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TPurchaserWithdrawVO {

    @NotNull(message = "金额不能为空")
    @DecimalMin(message = "金额不能小于0", value = "0")
    @DecimalMax(message = "单次提现金额不能大于999999", value = "999999")
    private BigDecimal money;

    @NotNull(message = "银行卡id不能为空")
    private Long cardId;

    @NotBlank(message = "提现密码不能为空")
    private String accountPassword;

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }
}
