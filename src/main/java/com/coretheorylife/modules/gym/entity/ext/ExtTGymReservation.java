package com.coretheorylife.modules.gym.entity.ext;

import com.coretheorylife.modules.gym.entity.TGymReservation;

public class ExtTGymReservation extends TGymReservation {

    // 状态 1-默认 2-已预约 3-已到达 4-已过期 5-用户取消 6-健身房取消

    public static final int STATUS_DEFAULT = 1;

    public static final int STATUS_RESERVED = 2;

    public static final int STATUS_SIGN_IN = 3;

    public static final int STATUS_EXPIRED = 4;

    public static final int STATUS_PURCHASER_CANCEL = 5;

    public static final int STATUS_GYM_CANCEL = 6;

}
