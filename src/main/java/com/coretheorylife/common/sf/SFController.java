package com.coretheorylife.common.sf;

import com.coretheorylife.common.sf.entity.SFStatusChange;
import com.coretheorylife.common.utils.LogUtil;
import com.coretheorylife.modules.shop.service.TOrderService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Connor
 * 顺丰回调类
 */
@Validated
@RestController
@RequestMapping("/sf")
public class SFController {

    @Autowired
    private TOrderService tOrderService;

    @RequestMapping(value = "sfStatusChange")
    public Map<String, Object> statusChange(@RequestParam Map<String, Object> params, @RequestBody Map<String, String> body) {
        LogUtil.debug(SFController.class, "params = " + new Gson().toJson(params));
        LogUtil.debug(SFController.class, "body = " + new Gson().toJson(body));
        SFStatusChange sfStatusChange = new Gson().fromJson(new Gson().toJson(body), SFStatusChange.class);
        tOrderService.changeStatus(sfStatusChange);
        Map<String, Object> map = new HashMap<>();
        map.put("error_code", 0);
        map.put("error_msg", "success");
        return map;
    }
}