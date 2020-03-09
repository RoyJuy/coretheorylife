package com.coretheorylife.modules.shop.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TShopRVO {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 手机号
     */
    private String mobile;

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
     * 自动接单
     */
    private Boolean autoReceive;

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

    /**
     * 满减信息，例如[{"full": 20, "sub": 10}, {"full": 30, "sub": 20}] 代表满20减10，满30减20
     */
    private String fullReduction;

    /**
     * 商品列表
     */
    private List<TGoodsRVO> goods;

    /**
     * 距离
     */
    private BigDecimal distance;

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

    /**
     * 营业执照
     */
    private String businessLicense;

    /**
     * 餐饮许可证
     */
    private String cateringLicense;

    /**
     * 月订单量，已完成才算
     */
    private Integer monthSell;

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getCateringLicense() {
        return cateringLicense;
    }

    public void setCateringLicense(String cateringLicense) {
        this.cateringLicense = cateringLicense;
    }

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

    public List<TGoodsRVO> getGoods() {
        return goods;
    }

    public void setGoods(List<TGoodsRVO> goods) {
        this.goods = goods;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWechatName() {
        return wechatName;
    }

    public void setWechatName(String wechatName) {
        this.wechatName = wechatName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
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

    public String getFullReduction() {
        return fullReduction;
    }

    public void setFullReduction(String fullReduction) {
        this.fullReduction = fullReduction;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Boolean getAutoReceive() {
        return autoReceive;
    }

    public void setAutoReceive(Boolean autoReceive) {
        this.autoReceive = autoReceive;
    }

    public Integer getMonthSell() {
        return monthSell;
    }

    public void setMonthSell(Integer monthSell) {
        this.monthSell = monthSell;
    }
}
