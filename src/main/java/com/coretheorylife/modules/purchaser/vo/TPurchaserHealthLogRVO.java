package com.coretheorylife.modules.purchaser.vo;

import com.coretheorylife.modules.shop.vo.TOrderRVO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-12-12
 */
public class TPurchaserHealthLogRVO implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 用户id
     */
    private Long purchaserId;

    /**
     * 日期格式为yyyy-MM-dd
     */
    private Date logTime;

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
     * 总预算蛋白质
     */
    private BigDecimal allProtein;

    /**
     * 总预算碳水
     */
    private BigDecimal allCarbohydrate;

    /**
     * 总预算脂肪
     */
    private BigDecimal allAdipose;

    /**
     * 总预算Kacl
     */
    private BigDecimal allKacl;

    /**
     * 当天总共吃的蛋白质
     */
    private BigDecimal allDayProtein;

    /**
     * 当天总共吃的碳水
     */
    private BigDecimal allDayCarbohydrate;

    /**
     * 当天总共吃的脂肪
     */
    private BigDecimal allDayAdipose;

    /**
     * 当天总共吃的Kacl
     */
    private BigDecimal allDayKacl;

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

    private List<TOrderRVO> orderList;

    private TPurchaserHealthRVO tPurchaserHealth;

    private TPurchaserHealthExamRVO tPurchaserHealthExam;

    private List<BigDecimal> weightList;

    private Map<String, String> featuresMap;

    /**
     * 最近体重测量时间
     */
    private Date recentWeightTime;

    public TPurchaserHealthRVO gettPurchaserHealth() {
        return tPurchaserHealth;
    }

    public void settPurchaserHealth(TPurchaserHealthRVO tPurchaserHealth) {
        this.tPurchaserHealth = tPurchaserHealth;
    }

    public TPurchaserHealthExamRVO gettPurchaserHealthExam() {
        return tPurchaserHealthExam;
    }

    public void settPurchaserHealthExam(TPurchaserHealthExamRVO tPurchaserHealthExam) {
        this.tPurchaserHealthExam = tPurchaserHealthExam;
    }

    public List<BigDecimal> getWeightList() {
        return weightList;
    }

    public void setWeightList(List<BigDecimal> weightList) {
        this.weightList = weightList;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
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

    public BigDecimal getAllProtein() {
        return allProtein;
    }

    public void setAllProtein(BigDecimal allProtein) {
        this.allProtein = allProtein;
    }

    public BigDecimal getAllCarbohydrate() {
        return allCarbohydrate;
    }

    public void setAllCarbohydrate(BigDecimal allCarbohydrate) {
        this.allCarbohydrate = allCarbohydrate;
    }

    public BigDecimal getAllAdipose() {
        return allAdipose;
    }

    public void setAllAdipose(BigDecimal allAdipose) {
        this.allAdipose = allAdipose;
    }

    public BigDecimal getAllKacl() {
        return allKacl;
    }

    public void setAllKacl(BigDecimal allKacl) {
        this.allKacl = allKacl;
    }

    public BigDecimal getAllDayProtein() {
        return allDayProtein;
    }

    public void setAllDayProtein(BigDecimal allDayProtein) {
        this.allDayProtein = allDayProtein;
    }

    public BigDecimal getAllDayCarbohydrate() {
        return allDayCarbohydrate;
    }

    public void setAllDayCarbohydrate(BigDecimal allDayCarbohydrate) {
        this.allDayCarbohydrate = allDayCarbohydrate;
    }

    public BigDecimal getAllDayAdipose() {
        return allDayAdipose;
    }

    public void setAllDayAdipose(BigDecimal allDayAdipose) {
        this.allDayAdipose = allDayAdipose;
    }

    public BigDecimal getAllDayKacl() {
        return allDayKacl;
    }

    public void setAllDayKacl(BigDecimal allDayKacl) {
        this.allDayKacl = allDayKacl;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", purchaserId=").append(purchaserId);
        sb.append(", logTime=").append(logTime);
        sb.append(", protein=").append(protein);
        sb.append(", carbohydrate=").append(carbohydrate);
        sb.append(", adipose=").append(adipose);
        sb.append(", kacl=").append(kacl);
        sb.append(", allProtein=").append(allProtein);
        sb.append(", allCarbohydrate=").append(allCarbohydrate);
        sb.append(", allAdipose=").append(allAdipose);
        sb.append(", allKacl=").append(allKacl);
        sb.append(", allDayProtein=").append(allDayProtein);
        sb.append(", allDayCarbohydrate=").append(allDayCarbohydrate);
        sb.append(", allDayAdipose=").append(allDayAdipose);
        sb.append(", allDayKacl=").append(allDayKacl);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", version=").append(version);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public List<TOrderRVO> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<TOrderRVO> orderList) {
        this.orderList = orderList;
    }

    public Map<String, String> getFeaturesMap() {
        return featuresMap;
    }

    public void setFeaturesMap(Map<String, String> featuresMap) {
        this.featuresMap = featuresMap;
    }

    public Date getRecentWeightTime() {
        return recentWeightTime;
    }

    public void setRecentWeightTime(Date recentWeightTime) {
        this.recentWeightTime = recentWeightTime;
    }
}