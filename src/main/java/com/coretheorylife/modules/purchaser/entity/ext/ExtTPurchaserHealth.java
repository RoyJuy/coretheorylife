package com.coretheorylife.modules.purchaser.entity.ext;

import com.coretheorylife.modules.purchaser.entity.TPurchaserHealth;

import java.util.Date;

public class ExtTPurchaserHealth extends TPurchaserHealth {

    // 运动量 0-未知 1-久坐人群 2-日常活动 3-每周1-2次运动 4-每周3-4次运动 5-每周运动5-7次
    public static final int EXERCISE_NOT_SPORT = 1;

    public static final int EXERCISE_DAILY = 2;

    public static final int EXERCISE_1_2 = 3;

    public static final int EXERCISE_3_4 = 4;

    public static final int EXERCISE_5_7 = 5;

    public static final int STATUS_SYS = 4;

    private Date birthday;

    private Integer sex;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
