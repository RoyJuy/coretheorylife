package com.coretheorylife.modules.purchaser.vo;

import com.coretheorylife.modules.purchaser.entity.CoachTagPO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TPurchaserRVO {
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
     * 健康数据
     */
    private TPurchaserHealthRVO purchaserHealth;

    /**
     * 体测数据
     */
    private TPurchaserHealthExamRVO purchaserHealthExam;

    /**
     * 1-普通用户 2-教练
     */
    private Integer property;

    /**
     * 是否已经绑定健身房
     */
    private Boolean haveGym;

    /**
     * 是否已经绑定教练
     */
    private Boolean haveCoach;

    private List<CoachTagPO> tags;

    private List<CoachTagPO> advantages;

    public Boolean getHaveGym() {
        return haveGym;
    }

    public void setHaveGym(Boolean haveGym) {
        this.haveGym = haveGym;
    }

    public Boolean getHaveCoach() {
        return haveCoach;
    }

    public void setHaveCoach(Boolean haveCoach) {
        this.haveCoach = haveCoach;
    }

    public TPurchaserHealthRVO getPurchaserHealth() {
        return purchaserHealth;
    }

    public void setPurchaserHealth(TPurchaserHealthRVO purchaserHealth) {
        this.purchaserHealth = purchaserHealth;
    }

    public TPurchaserHealthExamRVO getPurchaserHealthExam() {
        return purchaserHealthExam;
    }

    public void setPurchaserHealthExam(TPurchaserHealthExamRVO purchaserHealthExam) {
        this.purchaserHealthExam = purchaserHealthExam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getWechatName() {
        return wechatName;
    }

    public void setWechatName(String wechatName) {
        this.wechatName = wechatName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public Integer getProperty() {
        return property;
    }

    public void setProperty(Integer property) {
        this.property = property;
    }
}
