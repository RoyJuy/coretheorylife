package com.coretheorylife.modules.gym.entity;

import com.coretheorylife.modules.common.entity.BaseBean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-14
 */
public class TGym extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String sort;

    /**
     * 提现密码
     */
    private String accountPassword;

    /**
     * 提现密码盐
     */
    private String accountSort;

    /**
     * 微信openId
     */
    private String openid;

    /**
     * 微信名称
     */
    private String wechatName;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 1-待审核 2-审核中 3-审核通过 4-审核拒绝 5-营业中 6-休息 7-关闭
     */
    private Integer status;

    /**
     * 店铺名称
     */
    private String name;

    /**
     * 门店编码
     */
    private String gymCode;

    /**
     * 联系电话
     */
    private String orderPhone;

    /**
     * 门店地址
     */
    private String address;

    /**
     * 门店详细地址
     */
    private String addressDetailes;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 公告
     */
    private String announcement;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 营业时间
     */
    private String businessHours;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobileDefaultValue() {
        return mobile == null ? "" : mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPasswordDefaultValue() {
        return password == null ? "" : password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSortDefaultValue() {
        return sort == null ? "" : sort;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public String getAccountPasswordDefaultValue() {
        return accountPassword == null ? "" : accountPassword;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword == null ? null : accountPassword.trim();
    }

    public String getAccountSortDefaultValue() {
        return accountSort == null ? "" : accountSort;
    }

    public String getAccountSort() {
        return accountSort;
    }

    public void setAccountSort(String accountSort) {
        this.accountSort = accountSort == null ? null : accountSort.trim();
    }

    public String getOpenidDefaultValue() {
        return openid == null ? "" : openid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getWechatNameDefaultValue() {
        return wechatName == null ? "" : wechatName;
    }

    public String getWechatName() {
        return wechatName;
    }

    public void setWechatName(String wechatName) {
        this.wechatName = wechatName == null ? null : wechatName.trim();
    }

    public String getAvatarDefaultValue() {
        return avatar == null ? "" : avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
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

    public String getNameDefaultValue() {
        return name == null ? "" : name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGymCodeDefaultValue() {
        return gymCode == null ? "" : gymCode;
    }

    public String getGymCode() {
        return gymCode;
    }

    public void setGymCode(String gymCode) {
        this.gymCode = gymCode == null ? null : gymCode.trim();
    }

    public String getOrderPhoneDefaultValue() {
        return orderPhone == null ? "" : orderPhone;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone == null ? null : orderPhone.trim();
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

    public String getAddressDetailesDefaultValue() {
        return addressDetailes == null ? "" : addressDetailes;
    }

    public String getAddressDetailes() {
        return addressDetailes;
    }

    public void setAddressDetailes(String addressDetailes) {
        this.addressDetailes = addressDetailes == null ? null : addressDetailes.trim();
    }

    public BigDecimal getLongitudeDefaultValue() {
        return longitude == null ? new BigDecimal("0.000000") : longitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitudeDefaultValue() {
        return latitude == null ? new BigDecimal("0.000000") : latitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getAnnouncementDefaultValue() {
        return announcement == null ? "" : announcement;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement == null ? null : announcement.trim();
    }

    public String getIntroductionDefaultValue() {
        return introduction == null ? "" : introduction;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getBusinessHoursDefaultValue() {
        return businessHours == null ? "" : businessHours;
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours == null ? null : businessHours.trim();
    }
}