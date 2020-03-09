package com.coretheorylife.modules.gym.vo;

import java.util.Date;

public class TGymQualificationsRVO {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 店铺id
     */
    private Long gymId;

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

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建者
     */
    private Long createUser;

    /**
     * 更新者
     */
    private Long updateUser;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 逻辑删除
     */
    private Boolean deleteFlag;

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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo == null ? null : companyNo.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}