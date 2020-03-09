package com.coretheorylife.modules.gym.entity.ext;

import com.coretheorylife.modules.gym.entity.TGymAccountLog;

public class ExtTGymAccountLog extends TGymAccountLog {

    public static final int TYPE_WITHDRAW = 1;

    private String coachName;

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }
}
