package com.coretheorylife.modules.sys.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.AbstractController;
import com.coretheorylife.modules.shop.copier.TShopCopier;
import com.coretheorylife.modules.shop.entity.TShop;
import com.coretheorylife.modules.shop.entity.TShopExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTShop;
import com.coretheorylife.modules.shop.service.TShopService;
import com.coretheorylife.modules.shop.vo.TShopRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sys/shop")
public class SysTShopController extends AbstractController<TShop, TShopExample> {

    @Autowired
    private TShopService tShopService;

    /**
     * 查询用户列表
     *
     * @param params
     * @return
     */
    @WebLog
    @GetMapping("/list")
    public Result list(@RequestParam Map<String, Object> params) {
        params.put("deleteFlag", false);
        Query query = new Query(params);
        List<ExtTShop> list = tShopService.queryList(query);
        int total = tShopService.queryTotal(query);
        List<TShopRVO> result = TShopCopier.INSTANCE.asTShopRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }
}
