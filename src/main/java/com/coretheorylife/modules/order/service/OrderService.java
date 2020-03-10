package com.coretheorylife.modules.order.service;

import com.coretheorylife.common.utils.CommonUtil;
import com.coretheorylife.common.utils.ResultBuilder;
import com.coretheorylife.common.utils.TSingleResult;
import com.coretheorylife.modules.order.request.CreateOrderRequest;
import com.coretheorylife.modules.order.vo.CreateOrderVO;
import com.coretheorylife.modules.payment.dao.TransactionDao;
import com.coretheorylife.modules.payment.dao.po.TransactionPO;
import com.coretheorylife.modules.shop.dao.TOrderMapper;
import com.coretheorylife.modules.shop.entity.TOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * OrderService
 *
 * @author zhuhaitao
 * @since 2020-03-09
 */
@Service("nOrderService")
public class OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private TransactionDao transactionDao;



    public TSingleResult<CreateOrderVO> createOrder(CreateOrderRequest request){

        // 创建订单表

        TOrder tOrder = new TOrder();

        String orderId = CommonUtil.generateOID();

//        tOrder.setOrderNo(System.currentTimeMillis()+"");
//        tOrder.setPrice(new BigDecimal(0.01));
//        tOrder.setStatus(1);
//        tOrder.setOrder_id(orderId);
//        tOrder.setCreateUser(1L);
//        tOrder.setUpdateUser(1L);
//        tOrder.setCreateTime(new Date());
//        tOrder.setUpdateTime(new Date());
//
//
//
//        tOrderMapper.insert(tOrder);


        // 创建订单流水
        String transactionId = CommonUtil.generateOID();
        TransactionPO transactionPO = new TransactionPO();
        transactionPO.setOrder_id(orderId);
        transactionPO.setId(transactionId);
        transactionPO.setTransaction_number(transactionId);
        transactionDao.create(transactionPO);

        CreateOrderVO createOrderVO = new CreateOrderVO();
        createOrderVO.setOrderNumber(orderId);
        createOrderVO.setTransactionNumber(transactionId);

        return ResultBuilder.succTSingle(createOrderVO);



    }
}
