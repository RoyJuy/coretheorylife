package com.coretheorylife.modules.shop.entity;

import com.coretheorylife.modules.common.entity.BaseBean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-14
 */
public class TShopQualifications extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 资质类型 1-主体资质 2-行业资质
     */
    private Integer qualificationsType;

    /**
     * 证件类型 1-营业执照 2-餐饮服务许可证
     */
    private Integer credentialsType;

    /**
     * 证件照片
     */
    private String picUrl;

    /**
     * 许可证编号
     */
    private String companyNo;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 法人
     */
    private String legalPerson;

    /**
     * 经营场所
     */
    private String address;

    /**
     * 是否长期有效
     */
    private Boolean longTimeActive;

    /**
     * 失效时间
     */
    private Date notActiveTime;

    /**
     * 状态 1-待提交 2-待审核 3-审核通过 4-审核未通过
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Integer getQualificationsType() {
        return qualificationsType;
    }

    public void setQualificationsType(Integer qualificationsType) {
        this.qualificationsType = qualificationsType;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getPicUrlDefaultValue() {
        return picUrl == null ? "" : picUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getCompanyNoDefaultValue() {
        return companyNo == null ? "" : companyNo;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo == null ? null : companyNo.trim();
    }

    public String getCompanyNameDefaultValue() {
        return companyName == null ? "" : companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getLegalPersonDefaultValue() {
        return legalPerson == null ? "" : legalPerson;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    public String getAddressDefaultValue() {
        return address == null ? "" : address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Boolean getLongTimeActiveDefaultValue() {
        return longTimeActive == null ? false : longTimeActive;
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

    public Integer getStatusDefaultValue() {
        return status == null ? 1 : status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}