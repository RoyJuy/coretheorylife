package com.coretheorylife.modules.gym.entity.ext;

import com.coretheorylife.modules.gym.entity.TGym;

import java.math.BigDecimal;

public class ExtTGym extends TGym {

    //1-待审核 2-审核中 3-审核通过 4-审核拒绝 5-营业中 6-休息 7-关闭

    public static final int STATUS_PENDING_REVIEW = 1;

    public static final int STATUS_UNDER_REVIEW = 2;

    public static final int STATUS_REVIEWED = 3;

    public static final int STATUS_REJECT = 4;

    public static final int STATUS_OPEN = 5;

    public static final int STATUS_REST = 6;

    public static final int STATUS_CLOSE = 7;

    private BigDecimal distance;

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }
}
