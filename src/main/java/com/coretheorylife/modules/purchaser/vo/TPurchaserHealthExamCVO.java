package com.coretheorylife.modules.purchaser.vo;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TPurchaserHealthExamCVO {
    /**
     * 用户id
     */
    private Long purchaserId;

    /**
     * 基础代谢
     */
    @NotNull(message = "基础代谢不能为空")
    @DecimalMax(message = "基础代谢不能大于10000", value = "10000")
    @DecimalMin(message = "基础代谢不能小于0", value = "0")
    private BigDecimal basalMetabolism;

    /**
     * 肌肉
     */
    @NotNull(message = "肌肉不能为空")
    @DecimalMax(message = "肌肉不能大于1000", value = "1000")
    @DecimalMin(message = "肌肉不能小于0", value = "0")
    private BigDecimal muscle;

    /**
     * 体重
     */
    @NotNull(message = "体重不能为空")
    @DecimalMax(message = "体重不能大于1000", value = "1000")
    @DecimalMin(message = "体重不能小于0", value = "0")
    private BigDecimal weight;

    /**
     * 体脂
     */
    @NotNull(message = "体脂不能为空")
    @DecimalMax(message = "体脂不能大于1000", value = "1000")
    @DecimalMin(message = "体脂不能小于0", value = "0")
    private BigDecimal bodyFat;

    /**
     * 水分
     */
    @NotNull(message = "水分不能为空")
    @DecimalMax(message = "水分不能大于1000", value = "1000")
    @DecimalMin(message = "水分不能小于0", value = "0")
    private BigDecimal bodyWater;

    /**
     * 蛋白质
     */
    @NotNull(message = "蛋白质不能为空")
    @DecimalMax(message = "蛋白质不能大于1000", value = "1000")
    @DecimalMin(message = "蛋白质不能小于0", value = "0")
    private BigDecimal protein;

    /**
     * 内脏脂肪
     */
    @NotNull(message = "内脏脂肪不能为空")
    @DecimalMax(message = "内脏脂肪不能大于1000", value = "1000")
    @DecimalMin(message = "内脏脂肪不能小于0", value = "0")
    private BigDecimal visceralFat;

    /**
     * 骨量
     */
    @NotNull(message = "骨量不能为空")
    @DecimalMax(message = "骨量不能大于1000", value = "1000")
    @DecimalMin(message = "骨量不能小于0", value = "0")
    private BigDecimal boneMass;

    /**
     * 蛋白质
     */
    @NotNull(message = "蛋白质不能为空")
    @DecimalMax(message = "蛋白质摄入不能大于1000", value = "1000")
    @DecimalMin(message = "蛋白质摄入不能小于0", value = "0")
    private BigDecimal proteinNeed;

    /**
     * 碳水
     */
    @NotNull(message = "碳水不能为空")
    @DecimalMax(message = "碳水摄入不能大于1000", value = "1000")
    @DecimalMin(message = "碳水摄入不能小于0", value = "0")
    private BigDecimal carbohydrateNeed;

    /**
     * 脂肪
     */
    @NotNull(message = "脂肪不能为空")
    @DecimalMax(message = "脂肪摄入不能大于1000", value = "1000")
    @DecimalMin(message = "脂肪摄入不能小于0", value = "0")
    private BigDecimal adiposeNeed;

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
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
}
