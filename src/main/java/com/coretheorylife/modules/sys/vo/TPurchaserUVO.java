package com.coretheorylife.modules.sys.vo;

import javax.validation.constraints.NotNull;

public class TPurchaserUVO {

    @NotNull(message = "用户id不能为空")
    private Long purchaserId;

    /**
     * 1-普通用户 2-教练
     */
    @NotNull(message = "用户身份不能为空")
    private Integer property;

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public Integer getProperty() {
        return property;
    }

    public void setProperty(Integer property) {
        this.property = property;
    }
}
