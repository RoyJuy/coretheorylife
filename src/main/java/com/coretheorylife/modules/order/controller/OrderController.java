package com.coretheorylife.modules.order.controller;

import com.coretheorylife.common.utils.TSingleResult;
import com.coretheorylife.modules.order.request.CreateOrderRequest;
import com.coretheorylife.modules.order.service.OrderService;
import com.coretheorylife.modules.order.vo.CreateOrderVO;
import com.coretheorylife.modules.shop.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrderController
 *
 * @author zhuhaitao
 * @since 2020-03-09
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "/v1/orders/order_create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TSingleResult<CreateOrderVO> createOrder(@RequestBody CreateOrderRequest request){
        return orderService.createOrder(request);
    }
}
