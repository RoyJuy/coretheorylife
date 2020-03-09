package com.coretheorylife.modules.shop.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.shop.copier.TOrderCopier;
import com.coretheorylife.modules.shop.entity.ext.ExtTOrder;
import com.coretheorylife.modules.shop.service.TOrderService;
import com.coretheorylife.modules.shop.vo.TOrderRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shop/order")
public class TOrderController extends BaseController {

    @Autowired
    private TOrderService tOrderService;

    /**
     * 接受订单
     *
     * @param orderId
     * @return
     */
    @WebLog
    @PostMapping("/receiveOrder/{orderId}")
    public Result receiveOrder(@PathVariable(value = "orderId") Long orderId) {
        tOrderService.receiveOrder(orderId, getShopId());
        return Result.ok();
    }

    /**
     * 拒绝订单
     *
     * @param orderId
     * @return
     */
    @WebLog
    @PostMapping("/rejectOrder/{orderId}")
    public Result rejectOrder(@PathVariable(value = "orderId") Long orderId) {
        tOrderService.rejectOrder(orderId, getShopId());
        return Result.ok();
    }

    /**
     * 查询所有订单记录
     *
     * @param params
     * @return
     */
    @WebLog
    @GetMapping("/orderList")
    public Result allList(@RequestParam Map<String, Object> params) {
        params.put("deleteFlag", false);
        params.put("shopId", getShopId());
        Query query = new Query(params);
        List<ExtTOrder> list = tOrderService.queryListByShopIdOrUserId(query);
        int total = tOrderService.queryTotalByShopIdOrUserId(query);
        List<TOrderRVO> result = TOrderCopier.INSTANCE.asTOrderRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }
}
