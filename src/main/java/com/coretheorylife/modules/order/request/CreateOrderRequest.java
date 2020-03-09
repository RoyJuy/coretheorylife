package com.coretheorylife.modules.order.request;

import com.coretheorylife.modules.shop.vo.TOrderLineCVO;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * CreateOrderRequest
 *
 * @author zhuhaitao
 * @since 2020-03-09
 */
@Data
public class CreateOrderRequest {

    @NotNull(message = "店铺id不能为空")
    private Long shopId;

    /**
     * 订单备注
     */
    private String remark;

    /**
     * 1-立即配送 2-定时配送
     */
    @NotNull(message = "配送方式不能为空")
    private Integer shipType;

    /**
     * 定时配送时间
     */
    private Date shipTime;

    /**
     * 配送地址
     */
    @NotNull(message = "配送地址不能为空")
    private Long purchaserAddressId;

    /**
     * 用餐人数
     */
    @NotNull(message = "用餐人数不能为空")
    @Max(value = 999, message = "最大值不能超过999")
    @Min(value = 1, message = "最小值不能小于1")
    private Integer eatNumber;

    /**
     * 订单行
     */
    @Valid
    @NotEmpty(message = "商品不能为空")
    private List<TOrderLineCVO> orderLines;

    /**
     * 店铺优惠券id
     */
    private Long purchaserCouponId;

    /**
     * 用户红包id
     */
    private Long purchaserEnvelopeId;

    /**
     * 前端计算的实际支付
     */
    @DecimalMin(value = "0", message = "前端计算的支付金额必须大于0")
    @DecimalMax(value = "999999", message = "最大支付金额不可以超过999999")
    @NotNull(message = "前端计算的实际支付金额不能为空")
    private BigDecimal payPrice;

    /**
     * 前端计算的总价
     */
    @DecimalMin(value = "0", message = "前端计算的总价必须大于0")
    @DecimalMax(value = "999999", message = "最大总价不可以超过999999")
    @NotNull(message = "前端计算的总价不能为空")
    private BigDecimal price;
}
