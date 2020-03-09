package com.coretheorylife.modules.purchaser.entity;

import com.coretheorylife.modules.common.entity.BaseBean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-14
 */
public class TPurchaserHealth extends BaseBean implements Serializable {
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
     * 是体测用户
     */
    private Boolean examer;

    /**
     * 目标体重
     */
    private BigDecimal dreamWeight;

    /**
     * 每天摄入卡路里
     */
    private BigDecimal kclNeed;

    /**
     * 目标时间
     */
    private Date dreamDate;

    /**
     * 目标状态 0-未开始 1-进行中 2-完成 3-放弃 4-系统默认
     */
    private Integer status;

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

    public Integer getTargetDefaultValue() {
        return target == null ? 0 : target;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public BigDecimal getStandardWeightDefaultValue() {
        return standardWeight == null ? new BigDecimal("0.00") : standardWeight;
    }

    public BigDecimal getStandardWeight() {
        return standardWeight;
    }

    public void setStandardWeight(BigDecimal standardWeight) {
        this.standardWeight = standardWeight;
    }

    public Integer getExerciseDefaultValue() {
        return exercise == null ? 2 : exercise;
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

    public Boolean getExamerDefaultValue() {
        return examer == null ? false : examer;
    }

    public Boolean getExamer() {
        return examer;
    }

    public void setExamer(Boolean examer) {
        this.examer = examer;
    }

    public BigDecimal getDreamWeightDefaultValue() {
        return dreamWeight == null ? new BigDecimal("0.0") : dreamWeight;
    }

    public BigDecimal getDreamWeight() {
        return dreamWeight;
    }

    public void setDreamWeight(BigDecimal dreamWeight) {
        this.dreamWeight = dreamWeight;
    }

    public BigDecimal getKclNeedDefaultValue() {
        return kclNeed == null ? new BigDecimal("0.00") : kclNeed;
    }

    public BigDecimal getKclNeed() {
        return kclNeed;
    }

    public void setKclNeed(BigDecimal kclNeed) {
        this.kclNeed = kclNeed;
    }

    public Date getDreamDate() {
        return dreamDate;
    }

    public void setDreamDate(Date dreamDate) {
        this.dreamDate = dreamDate;
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
}