package com.coretheorylife.modules.gym.vo;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 银行卡CVO
 */
public class TGymBankCVO {

    /**
     * 银行卡号
     */
    @NotBlank(message = "卡号不能为空")
    private String cardNumber;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 持卡人
     */
    @NotBlank(message = "银行名称不能为空")
    private String cardHolder;

    /**
     * 开户行
     */
    @NotBlank(message = "银行名称不能为空")
    private String cardAddress;

    /**
     * 是默认提现卡
     */
    private Boolean defaultCard;

    /**
     * 1-私人账户 2-对公账户
     */
    @NotNull(message = "账户类型不能为空")
    private Integer type;

    /**
     * 公司名称
     */
    private String company;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
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
