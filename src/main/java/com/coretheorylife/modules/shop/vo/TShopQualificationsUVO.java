package com.coretheorylife.modules.shop.vo;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class TShopQualificationsUVO {
    /**
     * 主键id
     */
    @NotNull(message = "资质id不能为空")
    private Long id;

    /**
     * 证件照片
     */
    @NotBlank(message = "证件照片不能为空")
    private String picUrl;

    /**
     * 许可证编号
     */
    @NotBlank(message = "许可证编号不能为空")
    private String companyNo;

    /**
     * 公司名称
     */
    @NotBlank(message = "公司名称不能为空")
    private String companyName;

    /**
     * 法人
     */
    @NotBlank(message = "法人不能为空")
    private String legalPerson;

    /**
     * 经营场所
     */
    @NotBlank(message = "经营场所不能为空")
    private String address;

    /**
     * 是否长期有效
     */
    @NotNull(message = "是否长期有效不能为空")
    private Boolean longTimeActive;

    /**
     * 失效时间
     */
    private Date notActiveTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getLongTimeActive() {
        return longTimeActive;
    }

    public void setLongTimeActive(Boolean longTimeActive) {
        this.longTimeActive = longTimeActive;
    }

    public Date getNotActiveTime() {
        return notActiveTime;
    }

    public void setNotActiveTime(Date notActiveTime) {
        this.notActiveTime = notActiveTime;
    }
}