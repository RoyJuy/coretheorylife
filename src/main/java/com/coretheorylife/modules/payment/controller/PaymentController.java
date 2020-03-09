package com.coretheorylife.modules.payment.controller;

import com.alipay.api.AlipayApiException;
import com.coretheorylife.common.annotation.AuthIgnore;
import com.coretheorylife.modules.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * PaymentController
 *
 * @author zhuhaitao
 * @since 2020-03-09
 */
@Validated
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @AuthIgnore
    @RequestMapping(value = "/v1/payment/test", method = RequestMethod.OPTIONS)
    public String testPaymentController(){
        return "success";
    }

    @AuthIgnore
    @RequestMapping(value = "/v1/payment/pay", method = RequestMethod.GET)
    public String payOrder(@RequestParam String orderNo){
        try {
            return paymentService.pay(orderNo);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return "failed";
    }
}
