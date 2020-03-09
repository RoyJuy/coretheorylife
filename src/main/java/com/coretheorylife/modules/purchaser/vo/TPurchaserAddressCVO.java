package com.coretheorylife.modules.purchaser.vo;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TPurchaserAddressCVO {
    /**
     * 收货人昵称
     */
    @NotBlank(message = "昵称不能为空")
    private String nickName;

    /**
     * 收货人电话
     */
    @NotBlank(message = "电话不能为空")
    private String mobile;

    /**
     * 地址前缀
     */
    @NotBlank(message = "地址前缀不能为空")
    private String addressPrefix;

    /**
     * 地址后缀
     */
    @NotBlank(message = "地址后缀不能为空")
    private String addressSuffix;

    /**
     * 默认收货地址
     */
    @NotNull(message = "是否是默认地址不能为空")
    private Boolean defaultAddress;

    /**
     * 经度
     */
    @NotNull(message = "经度不能为空")
    @DecimalMax(value = "180", message = "经度数值错误")
    @DecimalMin(value = "0", message = "经度数值错误")
    private BigDecimal longitude;

    /**
     * 纬度
     */
    @NotNull(message = "纬度不能为空")
    @DecimalMax(value = "90", message = "纬度数值错误")
    @DecimalMin(value = "0", message = "纬度数值错误")
    private BigDecimal latitude;

    /**
     * 标记，例如家/公司
     */
    private String flag;

    /**
     * 性别 1-男 2-女
     */
    @NotNull(message = "性别不能为空")
    private Integer sex;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddressPrefix() {
        return addressPrefix;
    }

    public void setAddressPrefix(String addressPrefix) {
        this.addressPrefix = addressPrefix;
    }

    public String getAddressSuffix() {
        return addressSuffix;
    }

    public void setAddressSuffix(String addressSuffix) {
        this.addressSuffix = addressSuffix;
    }

    public Boolean getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(Boolean defaultAddress) {
        this.defaultAddress = defaultAddress;
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
