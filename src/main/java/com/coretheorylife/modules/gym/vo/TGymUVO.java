package com.coretheorylife.modules.gym.vo;

import java.math.BigDecimal;

public class TGymUVO {

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 店铺名称
     */
    private String name;

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressDetailes() {
        return addressDetailes;
    }

    public void setAddressDetailes(String addressDetailes) {
        this.addressDetailes = addressDetailes;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }
}
