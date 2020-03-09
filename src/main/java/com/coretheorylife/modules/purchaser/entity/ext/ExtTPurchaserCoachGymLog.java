package com.coretheorylife.modules.purchaser.entity.ext;

import com.coretheorylife.modules.purchaser.entity.TPurchaserCoachGymLog;

public class ExtTPurchaserCoachGymLog extends TPurchaserCoachGymLog {

    // 变化类型 1-增长 2-减少 3-教练变化（和健身房用户数无关）
    public static final int TYPE_INCREASE = 1;

    public static final int TYPE_FEWER = 2;

    public static final int TYPE_COACH_CHANGE = 3;

    // 用于计算的类型 0-默认没有什么用 1-是增长（今天该用户之前的要改成0） 2-减少（今天该用户之前的要改为0）
    public static final int QUERY_TYPE_INCREASE = 1;

    public static final int QUERY_TYPE_FEWER = 2;

    public static final int QUERY_TYPE_DEFAULT = 0;
}
