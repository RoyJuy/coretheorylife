package com.coretheorylife.modules.shop.controller;

import com.coretheorylife.common.annotation.AuthIgnore;
import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.AbstractController;
import com.coretheorylife.modules.purchaser.entity.TPurchaserRate;
import com.coretheorylife.modules.purchaser.entity.TPurchaserRateExample;
import com.coretheorylife.modules.sys.copier.TSysBannerCopier;
import com.coretheorylife.modules.sys.entity.TSysBanner;
import com.coretheorylife.modules.sys.entity.ext.ExtTSysBanner;
import com.coretheorylife.modules.sys.service.TSysBannerService;
import com.coretheorylife.modules.sys.vo.TSysBannerRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop/banner")
public class TShopBannerController extends AbstractController<TPurchaserRate, TPurchaserRateExample> {

    @Autowired
    private TSysBannerService tSysBannerService;

    /**
     * 查询列表
     *
     * @return
     */
    @AuthIgnore
    @WebLog
    @GetMapping("/list")
    public Result list() {
        List<TSysBanner> list = tSysBannerService.queryList(ExtTSysBanner.TYPE_SHOP);
        List<TSysBannerRVO> result = TSysBannerCopier.INSTANCE.asTSysBannerRVOList(list);
        return Result.ok(result);
    }

}
