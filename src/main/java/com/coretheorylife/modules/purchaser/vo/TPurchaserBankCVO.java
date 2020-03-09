package com.coretheorylife.modules.purchaser.vo;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 商户银行卡CVO
 */
public class TPurchaserBankCVO {

    /**
     * 银行卡号
     */
    @NotBlank(message = "卡号不能为空")
    private String cardNumber;

    /**
     * 银行名称
     */
    @NotBlank(message = "银行名称不能为空")
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
