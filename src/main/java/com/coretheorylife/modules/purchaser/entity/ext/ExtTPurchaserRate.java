package com.coretheorylife.modules.purchaser.entity.ext;

import com.coretheorylife.modules.purchaser.entity.TPurchaserRate;

public class ExtTPurchaserRate extends TPurchaserRate {

    private String shopName;

    private String nickName;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
