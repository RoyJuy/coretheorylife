package com.coretheorylife.modules.purchaser.controller;

import com.coretheorylife.common.algorithm.RecommendUtils;
import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.purchaser.vo.TPurchaserUnifiedOrderVO;
import com.coretheorylife.modules.shop.copier.TGoodsCopier;
import com.coretheorylife.modules.shop.copier.TOrderCopier;
import com.coretheorylife.modules.shop.entity.ext.ExtTGoods;
import com.coretheorylife.modules.shop.entity.ext.ExtTOrder;
import com.coretheorylife.modules.shop.service.TOrderService;
import com.coretheorylife.modules.shop.vo.TGoodsRVO;
import com.coretheorylife.modules.shop.vo.TOrderCVO;
import com.coretheorylife.modules.shop.vo.TOrderRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/purchaser/order")
public class TPurchaserOrderController extends BaseController {

    @Autowired
    private TOrderService tOrderService;

    @Autowired
    private RecommendUtils recommendUtils;

    @WebLog
    @PostMapping("/createOrder")
    public Result createOrder(@RequestBody TOrderCVO t) {
        ExtTOrder tGoods = TOrderCopier.INSTANCE.asTOrder(t);
        tGoods.setPurchaserId(getPurchaserId());
        tOrderService.createOrder(tGoods);
        return Result.ok();
    }

    /**
     * 在线支付统一下单
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/unifiedOrder")
    public Result unifiedOrder(@RequestBody TPurchaserUnifiedOrderVO t) {
        Map<String, Object> map = tOrderService.unifiedOrder(t.getPayType(), getPurchaserId(), t.getOrderId());
        return Result.ok(map);
    }

    /**
     * 获取我的推荐餐品
     *
     * @return
     */
    @WebLog
    @GetMapping("/getRecommendList")
    public Result getRecommendList(@NotNull(message = "经度不能为空")
                                       @DecimalMax(value = "180", message = "经度数值错误")
                                       @DecimalMin(value = "0", message = "经度数值错误")
                                       BigDecimal longitude,
                                   @NotNull(message = "纬度不能为空")
                                   @DecimalMax(value = "90", message = "纬度数值错误")
                                   @DecimalMin(value = "0", message = "纬度数值错误")
                                   BigDecimal latitude,
                                   Integer number, Integer distance, BigDecimal rate) {
        boolean hasRate = false;
        if (number == null) {
            number = 1;
        }
        if (distance == null) {
            distance = 3;
        }
        if (rate == null) {
            rate = new BigDecimal("0.4");
        } else {
            hasRate = true;
        }
        List<ExtTGoods> list = recommendUtils.getRecommendList(getPurchaserId(), longitude, latitude, number, distance, rate);
        List<TGoodsRVO> result = TGoodsCopier.INSTANCE.asTGoodsRVOList(list);
        List<TGoodsRVO> dinnerResult = new ArrayList<>();
        if (!hasRate) {
            rate = new BigDecimal("0.3");
            List<ExtTGoods> dinnerList = recommendUtils.getRecommendList(getPurchaserId(), longitude, latitude, number, distance, rate);
            dinnerResult = TGoodsCopier.INSTANCE.asTGoodsRVOList(dinnerList);
        }

        return Result.ok().put("lunch", result.isEmpty() ? null : result.get(0)).put("dinner", dinnerResult.isEmpty() ? null : result.get(0));
    }

    /**
     * 查询所有订单记录
     *
     * @param params
     * @return
     */
    @WebLog
    @GetMapping("/orderList")
    public Result orderList(@RequestParam Map<String, Object> params) {
        params.put("deleteFlag", false);
        params.put("purchaserId", getPurchaserId());
        Query query = new Query(params);
        List<ExtTOrder> list = tOrderService.queryListByShopIdOrUserId(query);
        int total = tOrderService.queryTotalByShopIdOrUserId(query);
        List<TOrderRVO> result = TOrderCopier.INSTANCE.asTOrderRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }
}
