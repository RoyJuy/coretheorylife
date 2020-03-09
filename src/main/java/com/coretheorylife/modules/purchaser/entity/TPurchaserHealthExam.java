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
public class TPurchaserHealthExam extends BaseBean implements Serializable {
    /**
     * 主键id
     */
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

    public BigDecimal getBmiDefaultValue() {
        return bmi == null ? new BigDecimal("0.0000") : bmi;
    }

    public BigDecimal getBmi() {
        return bmi;
    }

    public void setBmi(BigDecimal bmi) {
        this.bmi = bmi;
    }

    public BigDecimal getBasalMetabolismDefaultValue() {
        return basalMetabolism == null ? new BigDecimal("0.0000") : basalMetabolism;
    }

    public BigDecimal getBasalMetabolism() {
        return basalMetabolism;
    }

    public void setBasalMetabolism(BigDecimal basalMetabolism) {
        this.basalMetabolism = basalMetabolism;
    }

    public BigDecimal getMuscleDefaultValue() {
        return muscle == null ? new BigDecimal("0.0000") : muscle;
    }

    public BigDecimal getMuscle() {
        return muscle;
    }

    public void setMuscle(BigDecimal muscle) {
        this.muscle = muscle;
    }

    public BigDecimal getWeightDefaultValue() {
        return weight == null ? new BigDecimal("0.0000") : weight;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getBodyFatDefaultValue() {
        return bodyFat == null ? new BigDecimal("0.0000") : bodyFat;
    }

    public BigDecimal getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(BigDecimal bodyFat) {
        this.bodyFat = bodyFat;
    }

    public BigDecimal getBodyWaterDefaultValue() {
        return bodyWater == null ? new BigDecimal("0.0000") : bodyWater;
    }

    public BigDecimal getBodyWater() {
        return bodyWater;
    }

    public void setBodyWater(BigDecimal bodyWater) {
        this.bodyWater = bodyWater;
    }

    public BigDecimal getProteinDefaultValue() {
        return protein == null ? new BigDecimal("0.0000") : protein;
    }

    public BigDecimal getProtein() {
        return protein;
    }

    public void setProtein(BigDecimal protein) {
        this.protein = protein;
    }

    public BigDecimal getVisceralFatDefaultValue() {
        return visceralFat == null ? new BigDecimal("0.0000") : visceralFat;
    }

    public BigDecimal getVisceralFat() {
        return visceralFat;
    }

    public void setVisceralFat(BigDecimal visceralFat) {
        this.visceralFat = visceralFat;
    }

    public BigDecimal getBoneMassDefaultValue() {
        return boneMass == null ? new BigDecimal("0.0000") : boneMass;
    }

    public BigDecimal getBoneMass() {
        return boneMass;
    }

    public void setBoneMass(BigDecimal boneMass) {
        this.boneMass = boneMass;
    }

    public BigDecimal getMuscleRateDefaultValue() {
        return muscleRate == null ? new BigDecimal("0.0000") : muscleRate;
    }

    public BigDecimal getMuscleRate() {
        return muscleRate;
    }

    public void setMuscleRate(BigDecimal muscleRate) {
        this.muscleRate = muscleRate;
    }

    public BigDecimal getBodyFatRateDefaultValue() {
        return bodyFatRate == null ? new BigDecimal("0.0000") : bodyFatRate;
    }

    public BigDecimal getBodyFatRate() {
        return bodyFatRate;
    }

    public void setBodyFatRate(BigDecimal bodyFatRate) {
        this.bodyFatRate = bodyFatRate;
    }

    public BigDecimal getBodyWaterRateDefaultValue() {
        return bodyWaterRate == null ? new BigDecimal("0.0000") : bodyWaterRate;
    }

    public BigDecimal getBodyWaterRate() {
        return bodyWaterRate;
    }

    public void setBodyWaterRate(BigDecimal bodyWaterRate) {
        this.bodyWaterRate = bodyWaterRate;
    }

    public BigDecimal getProteinRateDefaultValue() {
        return proteinRate == null ? new BigDecimal("0.0000") : proteinRate;
    }

    public BigDecimal getProteinRate() {
        return proteinRate;
    }

    public void setProteinRate(BigDecimal proteinRate) {
        this.proteinRate = proteinRate;
    }

    public BigDecimal getVisceralFatRateDefaultValue() {
        return visceralFatRate == null ? new BigDecimal("0.0000") : visceralFatRate;
    }

    public BigDecimal getVisceralFatRate() {
        return visceralFatRate;
    }

    public void setVisceralFatRate(BigDecimal visceralFatRate) {
        this.visceralFatRate = visceralFatRate;
    }

    public BigDecimal getBoneMassRateDefaultValue() {
        return boneMassRate == null ? new BigDecimal("0.0000") : boneMassRate;
    }

    public BigDecimal getBoneMassRate() {
        return boneMassRate;
    }

    public void setBoneMassRate(BigDecimal boneMassRate) {
        this.boneMassRate = boneMassRate;
    }

    public BigDecimal getProteinNeedDefaultValue() {
        return proteinNeed == null ? new BigDecimal("0.0000") : proteinNeed;
    }

    public BigDecimal getProteinNeed() {
        return proteinNeed;
    }

    public void setProteinNeed(BigDecimal proteinNeed) {
        this.proteinNeed = proteinNeed;
    }

    public BigDecimal getCarbohydrateNeedDefaultValue() {
        return carbohydrateNeed == null ? new BigDecimal("0.0000") : carbohydrateNeed;
    }

    public BigDecimal getCarbohydrateNeed() {
        return carbohydrateNeed;
    }

    public void setCarbohydrateNeed(BigDecimal carbohydrateNeed) {
        this.carbohydrateNeed = carbohydrateNeed;
    }

    public BigDecimal getAdiposeNeedDefaultValue() {
        return adiposeNeed == null ? new BigDecimal("0.0000") : adiposeNeed;
    }

    public BigDecimal getAdiposeNeed() {
        return adiposeNeed;
    }

    public void setAdiposeNeed(BigDecimal adiposeNeed) {
        this.adiposeNeed = adiposeNeed;
    }

    public BigDecimal getKaclNeedDefaultValue() {
        return kaclNeed == null ? new BigDecimal("0.0000") : kaclNeed;
    }

    public BigDecimal getKaclNeed() {
        return kaclNeed;
    }

    public void setKaclNeed(BigDecimal kaclNeed) {
        this.kaclNeed = kaclNeed;
    }
}