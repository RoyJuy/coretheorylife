package com.coretheorylife.modules.shop.entity.ext;

import com.coretheorylife.modules.shop.entity.TShop;

import java.math.BigDecimal;
import java.util.List;

public class ExtTShop extends TShop {

    //1-待审核 2-审核中 3-审核通过 4-审核拒绝 5-营业中 6-休息 7-关闭

    public static final int STATUS_PENDING_REVIEW = 1;

    public static final int STATUS_UNDER_REVIEW = 2;

    public static final int STATUS_REVIEWED = 3;

    public static final int STATUS_REJECT = 4;

    public static final int STATUS_OPEN = 5;

    public static final int STATUS_REST = 6;

    public static final int STATUS_CLOSE = 7;

    /**
     * 距离
     */
    private BigDecimal distance;

    /**
     * 商品列表
     */
    private List<ExtTGoods> goods;

    /**
     * 营业执照
     */
    private String businessLicense;

    /**
     * 餐饮许可证
     */
    private String cateringLicense;

    /**
     * 月订单量，已完成才算
     */
    private Integer monthSell;

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getCateringLicense() {
        return cateringLicense;
    }

    public void setCateringLicense(String cateringLicense) {
        this.cateringLicense = cateringLicense;
    }

    public List<ExtTGoods> getGoods() {
        return goods;
    }

    public void setGoods(List<ExtTGoods> goods) {
        this.goods = goods;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Integer getMonthSell() {
        return monthSell;
    }

    public void setMonthSell(Integer monthSell) {
        this.monthSell = monthSell;
    }
}
