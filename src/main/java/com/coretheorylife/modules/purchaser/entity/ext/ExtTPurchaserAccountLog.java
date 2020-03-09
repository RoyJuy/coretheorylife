package com.coretheorylife.modules.purchaser.entity.ext;

import com.coretheorylife.modules.purchaser.entity.TPurchaserAccountLog;

public class ExtTPurchaserAccountLog extends TPurchaserAccountLog {

    // 状态 1-待审核 2-已审核 3-已拒绝
    public static final int STATUS_PENDING_REVIEW = 1;

    public static final int STATUS_SUCCESS = 2;

    public static final int STATUS_FAILED = 3;

    // 类型 1-消费 2-退款 3-提现 4-结算
    public static final int TYPE_CONSUMPTION = 1;

    public static final int TYPE_REFUND = 2;

    public static final int TYPE_WITHDRAW = 3;

    // 支付类型 1-微信支付 2-支付宝支付
    public static final int PAY_TYPE_ALI = 1;

    public static final int PAY_TYPE_WX = 2;
}
