package com.coretheorylife.modules.shop.entity.ext;

import com.coretheorylife.modules.shop.entity.TShopAccountLog;

public class ExtTShopAccountLog extends TShopAccountLog {
    /**
     * 提现
     */
    public static final int TYPE_WITHDRAW = 1;
    /**
     * 订单结算
     */
    public static final int TYPE_SETTLEMENT = 2;
    /**
     * 结算到余额
     */
    public static final int TYPE_SETTLEMENT_TO_ACCOUNT = 3;

    // 1-待审核 2-已审核 3-已拒绝
    public static final int STATUS_PENDING_REVIEW = 1;

    public static final int STATUS_REVIEW_SUCCESS = 2;

    public static final int STATUS_REVIEW_FAILED = 3;
}
