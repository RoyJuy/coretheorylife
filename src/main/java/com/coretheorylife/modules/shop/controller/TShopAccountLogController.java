package com.coretheorylife.modules.shop.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.shop.copier.TShopAccountLogCopier;
import com.coretheorylife.modules.shop.entity.ext.ExtTShopAccountLog;
import com.coretheorylife.modules.shop.service.TShopAccountLogService;
import com.coretheorylife.modules.shop.vo.TShopAccountLogRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shop/account/log")
public class TShopAccountLogController extends BaseController {

    @Autowired
    private TShopAccountLogService shopAccountLogService;

    /**
     * 查询账户日志
     *
     * @param params
     * @return
     */
    @WebLog
    @GetMapping("/list")
    public Result list(@RequestParam Map<String, Object> params) {
        params.put("deleteFlag", false);
        params.put("shopId", getShopId());
        Query query = new Query(params);
        List<ExtTShopAccountLog> list = shopAccountLogService.queryList(query);
        int total = shopAccountLogService.queryTotal(query);
        List<TShopAccountLogRVO> result = TShopAccountLogCopier.INSTANCE.asTShopAccountLogRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }

}
