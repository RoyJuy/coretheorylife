package com.coretheorylife.modules.sys.controller;

import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.sys.common.BannerTypeEnum;
import com.coretheorylife.modules.sys.common.param.BannerQueryParam;
import com.coretheorylife.modules.sys.dao.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * BannerController
 *
 * @author zhuhaitao
 * @since 2020-03-12
 */
@RestController
public class BannerController {

    @Autowired
    private BannerMapper bannerMapper;

    @RequestMapping(value = "/v1/sys/banners", method = RequestMethod.GET)
    public Result findBanner(@RequestParam(value = "bannerType") BannerTypeEnum bannerType) {
        BannerQueryParam param = new BannerQueryParam();
        param.setType(bannerType.name());
        return Result.ok(bannerMapper.findAll(param, null));
    }
}
