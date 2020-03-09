package com.coretheorylife.modules.shop.vo;

import java.math.BigDecimal;

public class TShopUVO {

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

    /**
     * 最低起送价格
     */
    private BigDecimal minPrice;

    /**
     * 店内招贴
     */
    private String shopNotice;

    /**
     * 店内海报
     */
    private String shopPoster;

    /**
     * 爆款橱窗
     */
    private String shopWindow;

    /**
     * 满减信息，例如[{"full": 20, "sub": 10}, {"full": 30, "sub": 20}] 代表满20减10，满30减20
     */
    private String fullReduction;

    /**
     * 自动接单
     */
    private Boolean autoReceive;

    /**
     * 是否商家配送
     */
    private Boolean shipSelf;

    /**
     * 配合ship_self使用，如果非商家配送，这里填写替用户垫付的配送费
     */
    private BigDecimal sendShipFee;

    /**
     * 配合ship_self使用，如商家配送，这里填写商家的配送费
     */
    private BigDecimal shopShipFee;

    public Boolean getShipSelf() {
        return shipSelf;
    }

    public void setShipSelf(Boolean shipSelf) {
        this.shipSelf = shipSelf;
    }

    public BigDecimal getSendShipFee() {
        return sendShipFee;
    }

    public void setSendShipFee(BigDecimal sendShipFee) {
        this.sendShipFee = sendShipFee;
    }

    public BigDecimal getShopShipFee() {
        return shopShipFee;
    }

    public void setShopShipFee(BigDecimal shopShipFee) {
        this.shopShipFee = shopShipFee;
    }

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

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public String getShopNotice() {
        return shopNotice;
    }

    public void setShopNotice(String shopNotice) {
        this.shopNotice = shopNotice;
    }

    public String getShopPoster() {
        return shopPoster;
    }

    public void setShopPoster(String shopPoster) {
        this.shopPoster = shopPoster;
    }

    public String getShopWindow() {
        return shopWindow;
    }

    public void setShopWindow(String shopWindow) {
        this.shopWindow = shopWindow;
    }

    public String getFullReduction() {
        return fullReduction;
    }

    public void setFullReduction(String fullReduction) {
        this.fullReduction = fullReduction;
    }

    public Boolean getAutoReceive() {
        return autoReceive;
    }

    public void setAutoReceive(Boolean autoReceive) {
        this.autoReceive = autoReceive;
    }
}
