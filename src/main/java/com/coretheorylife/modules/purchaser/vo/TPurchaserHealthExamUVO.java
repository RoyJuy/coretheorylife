package com.coretheorylife.modules.purchaser.vo;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class TPurchaserHealthExamUVO {
    /**
     * 主键id
     */
    @NotNull(message = "id不能为空")
    private Long id;

    /**
     * 用户id
     */
    private Long purchaserId;

    /**
     * BMI
     */
    private BigDecimal bmi;

    /**
     * 基础代谢
     */
    private BigDecimal basalMetabolism;

    /**
     * 肌肉
     */
    private BigDecimal muscle;

    /**
     * 体重
     */
    private BigDecimal weight;

    /**
     * 体脂
     */
    private BigDecimal bodyFat;

    /**
     * 水分
     */
    private BigDecimal bodyWater;

    /**
     * 蛋白质
     */
    private BigDecimal protein;

    /**
     * 内脏脂肪
     */
    private BigDecimal visceralFat;

    /**
     * 骨量
     */
    private BigDecimal boneMass;

    /**
     * 肌肉百分比
     */
    private BigDecimal muscleRate;

    /**
     * 体脂百分比
     */
    private BigDecimal bodyFatRate;

    /**
     * 水分百分比
     */
    private BigDecimal bodyWaterRate;

    /**
     * 蛋白质含量百分比
     */
    private BigDecimal proteinRate;

    /**
     * 内脏脂肪百分比
     */
    private BigDecimal visceralFatRate;

    /**
     * 骨量百分比
     */
    private BigDecimal boneMassRate;

    /**
     * 蛋白质
     */
    private BigDecimal proteinNeed;

    /**
     * 碳水
     */
    private BigDecimal carbohydrateNeed;

    /**
     * 脂肪
     */
    private BigDecimal adiposeNeed;

    /**
     * Kacl
     */
    private BigDecimal kaclNeed;

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

    public BigDecimal getBmi() {
        return bmi;
    }

    public void setBmi(BigDecimal bmi) {
        this.bmi = bmi;
    }

    public BigDecimal getBasalMetabolism() {
        return basalMetabolism;
    }

    public void setBasalMetabolism(BigDecimal basalMetabolism) {
        this.basalMetabolism = basalMetabolism;
    }

    public BigDecimal getMuscle() {
        return muscle;
    }

    public void setMuscle(BigDecimal muscle) {
        this.muscle = muscle;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(BigDecimal bodyFat) {
        this.bodyFat = bodyFat;
    }

    public BigDecimal getBodyWater() {
        return bodyWater;
    }

    public void setBodyWater(BigDecimal bodyWater) {
        this.bodyWater = bodyWater;
    }

    public BigDecimal getProtein() {
        return protein;
    }

    public void setProtein(BigDecimal protein) {
        this.protein = protein;
    }

    public BigDecimal getVisceralFat() {
        return visceralFat;
    }

    public void setVisceralFat(BigDecimal visceralFat) {
        this.visceralFat = visceralFat;
    }

    public BigDecimal getBoneMass() {
        return boneMass;
    }

    public void setBoneMass(BigDecimal boneMass) {
        this.boneMass = boneMass;
    }

    public BigDecimal getMuscleRate() {
        return muscleRate;
    }

    public void setMuscleRate(BigDecimal muscleRate) {
        this.muscleRate = muscleRate;
    }

    public BigDecimal getBodyFatRate() {
        return bodyFatRate;
    }

    public void setBodyFatRate(BigDecimal bodyFatRate) {
        this.bodyFatRate = bodyFatRate;
    }

    public BigDecimal getBodyWaterRate() {
        return bodyWaterRate;
    }

    public void setBodyWaterRate(BigDecimal bodyWaterRate) {
        this.bodyWaterRate = bodyWaterRate;
    }

    public BigDecimal getProteinRate() {
        return proteinRate;
    }

    public void setProteinRate(BigDecimal proteinRate) {
        this.proteinRate = proteinRate;
    }

    public BigDecimal getVisceralFatRate() {
        return visceralFatRate;
    }

    public void setVisceralFatRate(BigDecimal visceralFatRate) {
        this.visceralFatRate = visceralFatRate;
    }

    public BigDecimal getBoneMassRate() {
        return boneMassRate;
    }

    public void setBoneMassRate(BigDecimal boneMassRate) {
        this.boneMassRate = boneMassRate;
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

    public BigDecimal getAdiposeNeed() {
        return adiposeNeed;
    }

    public void setAdiposeNeed(BigDecimal adiposeNeed) {
        this.adiposeNeed = adiposeNeed;
    }

    public BigDecimal getKaclNeed() {
        return kaclNeed;
    }

    public void setKaclNeed(BigDecimal kaclNeed) {
        this.kaclNeed = kaclNeed;
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
}
