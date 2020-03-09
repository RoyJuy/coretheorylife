package com.coretheorylife.modules.purchaser.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.purchaser.copier.TPurchaserNotifyCopier;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserNotify;
import com.coretheorylife.modules.purchaser.service.TPurchaserNotifyService;
import com.coretheorylife.modules.purchaser.vo.TPurchaserNotifyRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/purchaser/notify")
public class TPurchaserNotifyController extends BaseController {

    @Autowired
    private TPurchaserNotifyService tPurchaserNotifyService;

    /**
     * 查询通知列表
     *
     * @param params
     * @return
     */
    @WebLog
    @GetMapping("/list")
    public Result list(@RequestParam Map<String, Object> params) {
        params.put("deleteFlag", false);
        params.put("purchaserId", getPurchaserId());
        Query query = new Query(params);
        List<ExtTPurchaserNotify> list = tPurchaserNotifyService.queryList(query);
        int total = tPurchaserNotifyService.queryTotal(query);
        List<TPurchaserNotifyRVO> result = TPurchaserNotifyCopier.INSTANCE.asTPurchaserNotifyRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }

    /**
     * 查询未读数量
     *
     * @return
     */
    @WebLog
    @GetMapping("/notReadTotal")
    public Result notReadTotal() {
        Map<String, Object> params = new HashMap<>();
        params.put("deleteFlag", false);
        params.put("purchaserId", getPurchaserId());
        params.put("hasRead", false);
        return Result.ok(tPurchaserNotifyService.queryTotal(params));
    }

    /**
     * 设置消息为已读
     *
     * @return
     */
    @WebLog
    @PostMapping("/setHaveRead/{notifyId}")
    public Result setHaveRead(@PathVariable(value = "notifyId") Long notifyId) {
        tPurchaserNotifyService.readNotify(notifyId);
        return Result.ok();
    }
}
