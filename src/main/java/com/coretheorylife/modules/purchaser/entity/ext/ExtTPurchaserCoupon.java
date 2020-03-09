package com.coretheorylife.modules.purchaser.entity.ext;

import com.coretheorylife.modules.purchaser.entity.TPurchaserCoupon;

public class ExtTPurchaserCoupon extends TPurchaserCoupon {

    /**
     * 店铺名称
     */
    private String shopName;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
