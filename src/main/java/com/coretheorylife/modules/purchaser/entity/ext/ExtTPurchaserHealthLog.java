package com.coretheorylife.modules.purchaser.entity.ext;

import com.coretheorylife.modules.purchaser.entity.TPurchaserHealth;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthExam;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthLog;
import com.coretheorylife.modules.shop.entity.ext.ExtTOrder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExtTPurchaserHealthLog extends TPurchaserHealthLog {

    private List<ExtTOrder> orderList;

    private TPurchaserHealth tPurchaserHealth;

    private TPurchaserHealthExam tPurchaserHealthExam;

    private List<BigDecimal> weightList;

    private Map<String, String> featuresMap;

    /**
     * 最近体重测量时间
     */
    private Date recentWeightTime;

    public List<ExtTOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<ExtTOrder> orderList) {
        this.orderList = orderList;
    }

    public TPurchaserHealth gettPurchaserHealth() {
        return tPurchaserHealth;
    }

    public void settPurchaserHealth(TPurchaserHealth tPurchaserHealth) {
        this.tPurchaserHealth = tPurchaserHealth;
    }

    public TPurchaserHealthExam gettPurchaserHealthExam() {
        return tPurchaserHealthExam;
    }

    public void settPurchaserHealthExam(TPurchaserHealthExam tPurchaserHealthExam) {
        this.tPurchaserHealthExam = tPurchaserHealthExam;
    }

    public List<BigDecimal> getWeightList() {
        return weightList;
    }

    public void setWeightList(List<BigDecimal> weightList) {
        this.weightList = weightList;
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
