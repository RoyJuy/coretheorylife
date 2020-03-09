package com.coretheorylife.modules.purchaser.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.AbstractController;
import com.coretheorylife.modules.purchaser.copier.TPurchaserAddressCopier;
import com.coretheorylife.modules.purchaser.entity.TPurchaserAddress;
import com.coretheorylife.modules.purchaser.entity.TPurchaserAddressExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserAddress;
import com.coretheorylife.modules.purchaser.service.TPurchaserAddressService;
import com.coretheorylife.modules.purchaser.vo.TPurchaserAddressCVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserAddressRVO;
import com.coretheorylife.modules.purchaser.vo.TPurchaserAddressUVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/purchaser/address")
public class TPurchaserAddressController extends AbstractController<TPurchaserAddress, TPurchaserAddressExample> {

    @Autowired
    private TPurchaserAddressService tPurchaserAddressService;

    /**
     * 查询地址列表
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
        List<ExtTPurchaserAddress> list = tPurchaserAddressService.queryList(query);
        int total = tPurchaserAddressService.queryTotal(query);
        List<TPurchaserAddressRVO> result = TPurchaserAddressCopier.INSTANCE.asTPurchaserAddressRVOListExt(list);
        PageUtils pageUtil = new PageUtils(result, total, query.getLimit(), query.getPage());
        return Result.ok(pageUtil);
    }

    /**
     * 保存地址
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/save")
    public Result save(@RequestBody TPurchaserAddressCVO t) {
        TPurchaserAddress tPurchaserAddress = TPurchaserAddressCopier.INSTANCE.asTPurchaserAddress(t);
        tPurchaserAddress.setPurchaserId(getPurchaserId());
        tPurchaserAddressService.save(tPurchaserAddress);
        return Result.ok();
    }

    /**
     * 更新地址
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/update")
    public Result update(@RequestBody TPurchaserAddressUVO t) {
        TPurchaserAddress tPurchaserAddress = TPurchaserAddressCopier.INSTANCE.asTPurchaserAddress(t);
        tPurchaserAddressService.update(tPurchaserAddress);
        return Result.ok();
    }
}
