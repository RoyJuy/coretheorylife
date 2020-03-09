package com.coretheorylife.modules.purchaser.entity;

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
public class TPurchaserAddress extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long purchaserId;

    /**
     * 收货人昵称
     */
    private String nickName;

    /**
     * 收货人电话
     */
    private String mobile;

    /**
     * 地址前缀
     */
    private String addressPrefix;

    /**
     * 地址后缀
     */
    private String addressSuffix;

    /**
     * 默认收货地址
     */
    private Boolean defaultAddress;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 标记，例如家/公司
     */
    private String flag;

    /**
     * 性别 1-男 2-女
     */
    private Integer sex;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public String getNickNameDefaultValue() {
        return nickName == null ? "" : nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
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

    public String getAddressPrefixDefaultValue() {
        return addressPrefix == null ? "" : addressPrefix;
    }

    public String getAddressPrefix() {
        return addressPrefix;
    }

    public void setAddressPrefix(String addressPrefix) {
        this.addressPrefix = addressPrefix == null ? null : addressPrefix.trim();
    }

    public String getAddressSuffixDefaultValue() {
        return addressSuffix == null ? "" : addressSuffix;
    }

    public String getAddressSuffix() {
        return addressSuffix;
    }

    public void setAddressSuffix(String addressSuffix) {
        this.addressSuffix = addressSuffix == null ? null : addressSuffix.trim();
    }

    public Boolean getDefaultAddressDefaultValue() {
        return defaultAddress == null ? true : defaultAddress;
    }

    public Boolean getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(Boolean defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public BigDecimal getLongitudeDefaultValue() {
        return longitude == null ? new BigDecimal("0.000") : longitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitudeDefaultValue() {
        return latitude == null ? new BigDecimal("0.000") : latitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getFlagDefaultValue() {
        return flag == null ? "" : flag;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public Integer getSexDefaultValue() {
        return sex == null ? 1 : sex;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}