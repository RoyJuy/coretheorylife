package com.coretheorylife.modules.gym.entity;

import com.coretheorylife.modules.common.entity.BaseBean;

import java.io.Serializable;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-14
 */
public class TGymBank extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 健身房id
     */
    private Long gymId;

    /**
     * 银行卡号
     */
    private String cardNumber;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 持卡人
     */
    private String cardHolder;

    /**
     * 开户行
     */
    private String cardAddress;

    /**
     * 是默认提现卡
     */
    private Boolean defaultCard;

    /**
     * 1-私人账户 2-对公账户
     */
    private Integer type;

    /**
     * 公司名称
     */
    private String company;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGymId() {
        return gymId;
    }

    public void setGymId(Long gymId) {
        this.gymId = gymId;
    }

    public String getCardNumberDefaultValue() {
        return cardNumber == null ? "" : cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    public String getBankNameDefaultValue() {
        return bankName == null ? "" : bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getCardHolderDefaultValue() {
        return cardHolder == null ? "" : cardHolder;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder == null ? null : cardHolder.trim();
    }

    public String getCardAddressDefaultValue() {
        return cardAddress == null ? "" : cardAddress;
    }

    public String getCardAddress() {
        return cardAddress;
    }

    public void setCardAddress(String cardAddress) {
        this.cardAddress = cardAddress == null ? null : cardAddress.trim();
    }

    public Boolean getDefaultCardDefaultValue() {
        return defaultCard == null ? false : defaultCard;
    }

    public Boolean getDefaultCard() {
        return defaultCard;
    }

    public void setDefaultCard(Boolean defaultCard) {
        this.defaultCard = defaultCard;
    }

    public Integer getTypeDefaultValue() {
        return type == null ? 1 : type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCompanyDefaultValue() {
        return company == null ? "" : company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }
}