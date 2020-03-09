package com.coretheorylife.modules.purchaser.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-11-28
 */
public class TPurchaserHealthRVO {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long purchaserId;

    /**
     * 身高cm
     */
    private BigDecimal height;

    /**
     * 体重kg
     */
    private BigDecimal weight;

    /**
     * 目标类型 0-未知 1-减脂 2-增肌 3-维持现状
     */
    private Integer target;

    /**
     * 标准体重
     */
    private BigDecimal standardWeight;

    /**
     * 运动量 0-未知 1-久坐人群 2-日常活动 3-每周1-2次运动 4-每周3-4次运动 5-每周运动5-7次
     */
    private Integer exercise;

    /**
     * 基础代谢
     */
    private BigDecimal basalMetabolism;

    /**
     * 行为代谢
     */
    private BigDecimal sportMetabolism;

    /**
     * 体脂
     */
    private BigDecimal bodyFatRate;

    /**
     * 每天脂肪摄入
     */
    private BigDecimal fatNeed;

    /**
     * 每天蛋白质摄入
     */
    private BigDecimal proteinNeed;

    /**
     * 每天碳水摄入
     */
    private BigDecimal carbohydrateNeed;

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
     * 是体测用户
     */
    private Boolean examer;

    /**
     * 目标体重
     */
    private BigDecimal dreamWeight;

    /**
     * 目标时间
     */
    private Date dreamDate;

    /**
     * 每天摄入卡路里
     */
    private BigDecimal kclNeed;

    /**
     * 目标状态 0-未开始 1-进行中 2-完成 3-放弃 4-系统默认
     */
    private Integer status;

    public BigDecimal getDreamWeight() {
        return dreamWeight;
    }

    public void setDreamWeight(BigDecimal dreamWeight) {
        this.dreamWeight = dreamWeight;
    }

    public Date getDreamDate() {
        return dreamDate;
    }

    public void setDreamDate(Date dreamDate) {
        this.dreamDate = dreamDate;
    }

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

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public BigDecimal getStandardWeight() {
        return standardWeight;
    }

    public void setStandardWeight(BigDecimal standardWeight) {
        this.standardWeight = standardWeight;
    }

    public Integer getExercise() {
        return exercise;
    }

    public void setExercise(Integer exercise) {
        this.exercise = exercise;
    }

    public BigDecimal getBasalMetabolism() {
        return basalMetabolism;
    }

    public void setBasalMetabolism(BigDecimal basalMetabolism) {
        this.basalMetabolism = basalMetabolism;
    }

    public BigDecimal getSportMetabolism() {
        return sportMetabolism;
    }

    public void setSportMetabolism(BigDecimal sportMetabolism) {
        this.sportMetabolism = sportMetabolism;
    }

    public BigDecimal getBodyFatRate() {
        return bodyFatRate;
    }

    public void setBodyFatRate(BigDecimal bodyFatRate) {
        this.bodyFatRate = bodyFatRate;
    }

    public BigDecimal getFatNeed() {
        return fatNeed;
    }

    public void setFatNeed(BigDecimal fatNeed) {
        this.fatNeed = fatNeed;
    }

    public BigDecimal getProteinNeed() {
        return proteinNeed;
    }

    public void setProteinNeed(BigDecimal proteinNeed) {
        this.proteinNeed = proteinNeed;
    }

    public BigDecimal getCarbohydrateNeed() {
        return carbohydrateNeed;
    }

    public void setCarbohydrateNeed(BigDecimal carbohydrateNeed) {
        this.carbohydrateNeed = carbohydrateNeed;
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

    public Boolean getExamer() {
        return examer;
    }

    public void setExamer(Boolean examer) {
        this.examer = examer;
    }

    public BigDecimal getKclNeed() {
        return kclNeed;
    }

    public void setKclNeed(BigDecimal kclNeed) {
        this.kclNeed = kclNeed;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}