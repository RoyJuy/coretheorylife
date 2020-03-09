package com.coretheorylife.modules.purchaser.vo;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-11-28
 */
public class TPurchaserHealthUVO {

    /**
     * 身高cm
     */
    @DecimalMax(value = "500", message = "暂时不服务超过5米的巨人")
    @DecimalMin(value = "10", message = "请认真填写身高(cm)")
    private BigDecimal height;
    /**
     * 体重kg
     */
    @DecimalMax(value = "1000", message = "暂时不服务超过1吨的巨人")
    @DecimalMin(value = "10", message = "请认真填写体重(kg)")
    private BigDecimal weight;

    /**
     * 目标类型 0-未知 1-减脂 2-增肌 3-维持现状
     */
    @Min(value = 1, message = "目标超出取值范围")
    @Max(value = 3, message = "目标超出取值范围")
    private Integer target;

    /**
     * 运动量 0-未知 1-久坐人群 2-日常活动 3-每周1-2次运动 4-每周3-4次运动 5-每周运动5-7次
     */
    @Min(value = 1, message = "目标超出取值范围")
    @Max(value = 5, message = "目标超出取值范围")
    private Integer exercise;

    /**
     * 基础代谢
     */
    @DecimalMax(value = "10000", message = "基础代谢太旺盛啦")
    @DecimalMin(value = "0", message = "请认真填写基础代谢（Kcal）")
    private BigDecimal basalMetabolism;

    /**
     * 体脂
     */
    @DecimalMax(value = "1", message = "请认真填写体脂(0-1)")
    @DecimalMin(value = "0", message = "请认真填写体脂(0-1)")
    private BigDecimal bodyFatRate;

    private Date birthday;

    @Min(value = 1, message = "1男2女")
    @Max(value = 2, message = "1男2女")
    private Integer sex;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public BigDecimal getBodyFatRate() {
        return bodyFatRate;
    }

    public void setBodyFatRate(BigDecimal bodyFatRate) {
        this.bodyFatRate = bodyFatRate;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Boolean getExamer() {
        return examer;
    }

    public void setExamer(Boolean examer) {
        this.examer = examer;
    }
}