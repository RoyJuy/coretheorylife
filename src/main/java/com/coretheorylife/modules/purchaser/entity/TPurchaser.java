package com.coretheorylife.modules.purchaser.entity;

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
public class TPurchaser extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickName;

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
     * 性别 0-未知 1-男 2-女 3-保密
     */
    private Integer sex;

    /**
     * 性别 0-锁定 1-正常使用
     */
    private Integer status;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 1-普通用户 2-教练
     */
    private Integer property;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getSexDefaultValue() {
        return sex == null ? 0 : sex;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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

    public String getAvatarDefaultValue() {
        return avatar == null ? "" : avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getPropertyDefaultValue() {
        return property == null ? 1 : property;
    }

    public Integer getProperty() {
        return property;
    }

    public void setProperty(Integer property) {
        this.property = property;
    }
}