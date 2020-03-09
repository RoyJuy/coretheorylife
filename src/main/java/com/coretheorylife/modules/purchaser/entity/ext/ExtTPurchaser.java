package com.coretheorylife.modules.purchaser.entity.ext;

import com.coretheorylife.modules.purchaser.entity.TPurchaser;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealth;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthExam;

public class ExtTPurchaser extends TPurchaser {

    public static final int PROPERTY_COACH = 2;

    /**
     * 健康数据
     */
    private TPurchaserHealth purchaserHealth;

    /**
     * 体测数据
     */
    private TPurchaserHealthExam purchaserHealthExam;

    /**
     * 是否已经绑定健身房
     */
    private Boolean haveGym;

    /**
     * 是否已经绑定教练
     */
    private Boolean haveCoach;

    public Boolean getHaveGym() {
        return haveGym;
    }

    public void setHaveGym(Boolean haveGym) {
        this.haveGym = haveGym;
    }

    public Boolean getHaveCoach() {
        return haveCoach;
    }

    public void setHaveCoach(Boolean haveCoach) {
        this.haveCoach = haveCoach;
    }

    public TPurchaserHealth getPurchaserHealth() {
        return purchaserHealth;
    }

    public void setPurchaserHealth(TPurchaserHealth purchaserHealth) {
        this.purchaserHealth = purchaserHealth;
    }

    public TPurchaserHealthExam getPurchaserHealthExam() {
        return purchaserHealthExam;
    }

    public void setPurchaserHealthExam(TPurchaserHealthExam purchaserHealthExam) {
        this.purchaserHealthExam = purchaserHealthExam;
    }
}
