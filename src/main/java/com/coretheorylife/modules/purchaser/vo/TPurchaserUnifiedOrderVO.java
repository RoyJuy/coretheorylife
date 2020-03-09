package com.coretheorylife.modules.purchaser.vo;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class TPurchaserUnifiedOrderVO {
    @NotBlank(message = "支付类型不能为空 ALI_PAY WX_PAY")
    private String payType;

    @NotNull(message = "订单id不能为空")
    private Long orderId;

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
