package com.coretheorylife.modules.shop.entity;

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
public class TGoods extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 店铺id
     */
    private Long shopId;

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
     * 商品状态 1-待上架 2-已上架 3-已下架
     */
    private Integer status;

    /**
     * 最小购买量
     */
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
    private BigDecimal packageFee;

    /**
     * 当前库存
     */
    private Integer nowStock;

    /**
     * 最大库存
     */
    private Integer maxStock;

    /**
     * 折扣率
     */
    private BigDecimal discountRate;

    /**
     * 最大折扣数量
     */
    private Integer maxDiscount;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 蛋白质
     */
    private BigDecimal protein;

    /**
     * 碳水
     */
    private BigDecimal carbohydrate;

    /**
     * 脂肪
     */
    private BigDecimal adipose;

    /**
     * Kacl
     */
    private BigDecimal kacl;

    /**
     * 重量，单位g
     */
    private Integer weight;

    /**
     * 月售
     */
    private Integer monthSell;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getShopTypeId() {
        return shopTypeId;
    }

    public void setShopTypeId(Long shopTypeId) {
        this.shopTypeId = shopTypeId;
    }

    public String getNameDefaultValue() {
        return name == null ? "" : name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSortDefaultValue() {
        return sort == null ? 0 : sort;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getPicDefaultValue() {
        return pic == null ? "" : pic;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getDescriptionDefaultValue() {
        return description == null ? "" : description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCharacteristicDefaultValue() {
        return characteristic == null ? "" : characteristic;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic == null ? null : characteristic.trim();
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

    public Integer getMinBuyDefaultValue() {
        return minBuy == null ? 1 : minBuy;
    }

    public Integer getMinBuy() {
        return minBuy;
    }

    public void setMinBuy(Integer minBuy) {
        this.minBuy = minBuy;
    }

    public String getUnitDefaultValue() {
        return unit == null ? "" : unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getSellTimeDefaultValue() {
        return sellTime == null ? "" : sellTime;
    }

    public String getSellTime() {
        return sellTime;
    }

    public void setSellTime(String sellTime) {
        this.sellTime = sellTime == null ? null : sellTime.trim();
    }

    public BigDecimal getPackageFeeDefaultValue() {
        return packageFee == null ? new BigDecimal("0.00") : packageFee;
    }

    public BigDecimal getPackageFee() {
        return packageFee;
    }

    public void setPackageFee(BigDecimal packageFee) {
        this.packageFee = packageFee;
    }

    public Integer getNowStockDefaultValue() {
        return nowStock == null ? 0 : nowStock;
    }

    public Integer getNowStock() {
        return nowStock;
    }

    public void setNowStock(Integer nowStock) {
        this.nowStock = nowStock;
    }

    public Integer getMaxStockDefaultValue() {
        return maxStock == null ? 0 : maxStock;
    }

    public Integer getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
    }

    public BigDecimal getDiscountRateDefaultValue() {
        return discountRate == null ? new BigDecimal("1.00") : discountRate;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public Integer getMaxDiscountDefaultValue() {
        return maxDiscount == null ? 1 : maxDiscount;
    }

    public Integer getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(Integer maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public BigDecimal getPriceDefaultValue() {
        return price == null ? new BigDecimal("0.00") : price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getProteinDefaultValue() {
        return protein == null ? new BigDecimal("0.000") : protein;
    }

    public BigDecimal getProtein() {
        return protein;
    }

    public void setProtein(BigDecimal protein) {
        this.protein = protein;
    }

    public BigDecimal getCarbohydrateDefaultValue() {
        return carbohydrate == null ? new BigDecimal("0.000") : carbohydrate;
    }

    public BigDecimal getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(BigDecimal carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public BigDecimal getAdiposeDefaultValue() {
        return adipose == null ? new BigDecimal("0.000") : adipose;
    }

    public BigDecimal getAdipose() {
        return adipose;
    }

    public void setAdipose(BigDecimal adipose) {
        this.adipose = adipose;
    }

    public BigDecimal getKaclDefaultValue() {
        return kacl == null ? new BigDecimal("0.000") : kacl;
    }

    public BigDecimal getKacl() {
        return kacl;
    }

    public void setKacl(BigDecimal kacl) {
        this.kacl = kacl;
    }

    public Integer getWeightDefaultValue() {
        return weight == null ? 0 : weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getMonthSellDefaultValue() {
        return monthSell == null ? 0 : monthSell;
    }

    public Integer getMonthSell() {
        return monthSell;
    }

    public void setMonthSell(Integer monthSell) {
        this.monthSell = monthSell;
    }
}