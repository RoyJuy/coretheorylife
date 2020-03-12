package com.coretheorylife.modules.express.controller;

import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.express.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ExpressController
 *
 * @author zhuhaitao
 * @since 2020-03-12
 */
@RestController
public class ExpressController {

    @Autowired
    private ExpressService expressService;

    @RequestMapping(value = "/v1/expresses/express/route", method = RequestMethod.GET)
    public Result queryExpressRoute(@RequestParam(value = "expressNo") String expressNo){
        return Result.ok(expressService.findExpressRoute(expressNo));

    }
}
