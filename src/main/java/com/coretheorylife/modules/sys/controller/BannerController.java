package com.coretheorylife.modules.sys.controller;

import com.coretheorylife.common.utils.CommonUtil;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.sys.common.BannerTypeEnum;
import com.coretheorylife.modules.sys.common.param.BannerQueryParam;
import com.coretheorylife.modules.sys.dao.mapper.BannerMapper;
import com.coretheorylife.modules.sys.po.BannerPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
        param.setBannerType(bannerType.name());
        return Result.ok(bannerMapper.findAll(param, null));
    }

    @RequestMapping(value = "/v1/sys/banner", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result createBanner(@RequestBody BannerPO po) {
        po.setId(CommonUtil.generateOID());
        return Result.ok(bannerMapper.create(po));
    }
}
