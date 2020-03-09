package com.coretheorylife.modules.shop.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TGoodsRVO {
    /**
     * 食材成分表
     */
    private List<TGoodsNutritionRVO> nutritions;

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
     * 商品状态 1-待上架 2-已上架
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
     * 折扣率
     */
    private BigDecimal discountRate;

    /**
     * 最大折扣数量
     */
    private Integer maxDiscount;

    /**
     * 脂肪
     */
    private BigDecimal adipose;

    /**
     * Kacl
     */
    private BigDecimal kacl;

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
     * 商品数量
     */
    private Integer number;

    private List<TGoodsLabelRVO> goodsLabels;

    private String shopName;

    /**
     * 重量，单位g
     */
    private Integer weight;

    /**
     * 月售
     */
    private Integer monthSell;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getMonthSell() {
        return monthSell;
    }

    public void setMonthSell(Integer monthSell) {
        this.monthSell = monthSell;
    }

    public List<TGoodsNutritionRVO> getNutritions() {
        return nutritions;
    }

    public void setNutritions(List<TGoodsNutritionRVO> nutritions) {
        this.nutritions = nutritions;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getNowStock() {
        return nowStock;
    }

    public void setNowStock(Integer nowStock) {
        this.nowStock = nowStock;
    }

    public Integer getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getProtein() {
        return protein;
    }

    public void setProtein(BigDecimal protein) {
        this.protein = protein;
    }

    public BigDecimal getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(BigDecimal carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public BigDecimal getAdipose() {
        return adipose;
    }

    public void setAdipose(BigDecimal adipose) {
        this.adipose = adipose;
    }

    public BigDecimal getKacl() {
        return kacl;
    }

    public void setKacl(BigDecimal kacl) {
        this.kacl = kacl;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<TGoodsLabelRVO> getGoodsLabels() {
        return goodsLabels;
    }

    public void setGoodsLabels(List<TGoodsLabelRVO> goodsLabels) {
        this.goodsLabels = goodsLabels;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
