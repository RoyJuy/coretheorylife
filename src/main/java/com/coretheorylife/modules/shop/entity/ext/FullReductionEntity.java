package com.coretheorylife.modules.shop.entity.ext;

import java.math.BigDecimal;

public class FullReductionEntity {
    /**
     * 满减信息
     */
    private BigDecimal full;
    private BigDecimal sub;
    private Boolean flag;

    public BigDecimal getFull() {
        return full;
    }

    public void setFull(BigDecimal full) {
        this.full = full;
    }

    public BigDecimal getSub() {
        return sub;
    }

    public void setSub(BigDecimal sub) {
        this.sub = sub;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
