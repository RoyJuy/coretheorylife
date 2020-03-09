package com.coretheorylife.modules.shop.vo;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

public class TGoodsUVO {

    @NotNull(message = "id不能为空")
    private Long id;

    /**
     * 店内货架
     */
    private Long shopTypeId;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序1-999 越大越靠前
     */
    @Max(value = 999, message = "最大值不能超过999")
    @Min(value = 1, message = "最小值不能小于1")
    private Integer sort;

    /**
     * 图片
     */
    private String pic;

    /**
     * 描述
     */
    private String description;

    /**
     * 商品特色
     */
    private String characteristic;

    /**
     * 最小购买量
     */
    @Max(value = 10000, message = "最大值不能超过10000")
    @Min(value = 1, message = "最小值不能小于1")
    private Integer minBuy;

    /**
     * 单位，如份
     */
    private String unit;

    /**
     * 售卖时间
     */
    private String sellTime;

    /**
     * 包装费
     */
    @DecimalMax(value = "10000", message = "最大值不能超过10000")
    @DecimalMin(value = "0.01", message = "最小值不能小于0.01")
    private BigDecimal packageFee;

    /**
     * 价格
     */
    @DecimalMax(value = "10000", message = "最大值不能超过10000")
    @DecimalMin(value = "0.01", message = "最小值不能小于0.01")
    private BigDecimal price;

    @Valid
    @NotEmpty(message = "组成不能为0")
    private List<TGoodsIncludeUVOForUpdateGoods> tGoodsIncludes;

    /**
     * 折扣率
     */
    @DecimalMax(value = "1", message = "最大值不能超过1")
    @DecimalMin(value = "0.01", message = "最小值不能小于0.01")
    private BigDecimal discountRate;

    /**
     * 最大折扣数量
     */
    private Integer maxDiscount;

    /**
     * 规格标签，可以使用多个
     */
    @Valid
    private List<TGoodsLabelCVO> goodsLabels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopTypeId() {
        return shopTypeId;
    }

    public void setShopTypeId(Long shopTypeId) {
        this.shopTypeId = shopTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public Integer getMinBuy() {
        return minBuy;
    }

    public void setMinBuy(Integer minBuy) {
        this.minBuy = minBuy;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSellTime() {
        return sellTime;
    }

    public void setSellTime(String sellTime) {
        this.sellTime = sellTime;
    }

    public BigDecimal getPackageFee() {
        return packageFee;
    }

    public void setPackageFee(BigDecimal packageFee) {
        this.packageFee = packageFee;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<TGoodsIncludeUVOForUpdateGoods> gettGoodsIncludes() {
        return tGoodsIncludes;
    }

    public void settGoodsIncludes(List<TGoodsIncludeUVOForUpdateGoods> tGoodsIncludes) {
        this.tGoodsIncludes = tGoodsIncludes;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public Integer getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(Integer maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public List<TGoodsLabelCVO> getGoodsLabels() {
        return goodsLabels;
    }

    public void setGoodsLabels(List<TGoodsLabelCVO> goodsLabels) {
        this.goodsLabels = goodsLabels;
    }
}
