package com.coretheorylife.modules.gym.vo;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class TGymBankUVO {

    /**
     * 主键id
     */
    @NotNull(message = "id不能为空")
    private Long id;

    /**
     * 开户行
     */
    @NotBlank(message = "银行名称不能为空")
    private String cardAddress;

    /**
     * 是默认提现卡
     */
    private Boolean defaultCard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardAddress() {
        return cardAddress;
    }

    public void setCardAddress(String cardAddress) {
        this.cardAddress = cardAddress;
    }

    public Boolean getDefaultCard() {
        return defaultCard;
    }

    public void setDefaultCard(Boolean defaultCard) {
        this.defaultCard = defaultCard;
    }
}
