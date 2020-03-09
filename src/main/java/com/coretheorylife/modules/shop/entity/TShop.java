package com.coretheorylife.modules.shop.entity;

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
public class TShop extends BaseBean implements Serializable {
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
    private String shopCode;

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

    public String getShopCodeDefaultValue() {
        return shopCode == null ? "" : shopCode;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
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

    public BigDecimal getMinPriceDefaultValue() {
        return minPrice == null ? new BigDecimal("0.00") : minPrice;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public String getShopNoticeDefaultValue() {
        return shopNotice == null ? "" : shopNotice;
    }

    public String getShopNotice() {
        return shopNotice;
    }

    public void setShopNotice(String shopNotice) {
        this.shopNotice = shopNotice == null ? null : shopNotice.trim();
    }

    public String getShopPosterDefaultValue() {
        return shopPoster == null ? "" : shopPoster;
    }

    public String getShopPoster() {
        return shopPoster;
    }

    public void setShopPoster(String shopPoster) {
        this.shopPoster = shopPoster == null ? null : shopPoster.trim();
    }

    public String getShopWindowDefaultValue() {
        return shopWindow == null ? "" : shopWindow;
    }

    public String getShopWindow() {
        return shopWindow;
    }

    public void setShopWindow(String shopWindow) {
        this.shopWindow = shopWindow == null ? null : shopWindow.trim();
    }

    public String getFullReductionDefaultValue() {
        return fullReduction == null ? "[]" : fullReduction;
    }

    public String getFullReduction() {
        return fullReduction;
    }

    public void setFullReduction(String fullReduction) {
        this.fullReduction = fullReduction == null ? null : fullReduction.trim();
    }

    public Boolean getAutoReceiveDefaultValue() {
        return autoReceive == null ? false : autoReceive;
    }

    public Boolean getAutoReceive() {
        return autoReceive;
    }

    public void setAutoReceive(Boolean autoReceive) {
        this.autoReceive = autoReceive;
    }

    public Boolean getShipSelfDefaultValue() {
        return shipSelf == null ? false : shipSelf;
    }

    public Boolean getShipSelf() {
        return shipSelf;
    }

    public void setShipSelf(Boolean shipSelf) {
        this.shipSelf = shipSelf;
    }

    public BigDecimal getSendShipFeeDefaultValue() {
        return sendShipFee == null ? new BigDecimal("0.00") : sendShipFee;
    }

    public BigDecimal getSendShipFee() {
        return sendShipFee;
    }

    public void setSendShipFee(BigDecimal sendShipFee) {
        this.sendShipFee = sendShipFee;
    }

    public BigDecimal getShopShipFeeDefaultValue() {
        return shopShipFee == null ? new BigDecimal("0.00") : shopShipFee;
    }

    public BigDecimal getShopShipFee() {
        return shopShipFee;
    }

    public void setShopShipFee(BigDecimal shopShipFee) {
        this.shopShipFee = shopShipFee;
    }
}