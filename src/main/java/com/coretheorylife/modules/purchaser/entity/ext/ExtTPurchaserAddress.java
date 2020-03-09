package com.coretheorylife.modules.purchaser.entity.ext;

import com.coretheorylife.modules.purchaser.entity.TPurchaserAddress;

import java.math.BigDecimal;

public class ExtTPurchaserAddress extends TPurchaserAddress {
    private BigDecimal distance;

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }
}
