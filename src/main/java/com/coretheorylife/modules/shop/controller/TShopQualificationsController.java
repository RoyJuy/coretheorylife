package com.coretheorylife.modules.shop.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.exception.ResourceNotExistsException;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.shop.copier.TShopQualificationsCopier;
import com.coretheorylife.modules.shop.entity.TShopQualifications;
import com.coretheorylife.modules.shop.entity.ext.ExtTShopQualifications;
import com.coretheorylife.modules.shop.service.TShopQualificationsService;
import com.coretheorylife.modules.shop.vo.TShopQualificationsRVO;
import com.coretheorylife.modules.shop.vo.TShopQualificationsUVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/shop/qualifications")
public class TShopQualificationsController extends BaseController {

    @Autowired
    private TShopQualificationsService tShopQualificationsService;

    /**
     * 查看行业资质
     *
     * @return
     */
    @WebLog
    @GetMapping("/qualificationsIndustry")
    public Result qualificationsIndustry() {
        TShopQualifications tShopQualifications = tShopQualificationsService.initQualificationsIndustry(getShopId());
        TShopQualificationsRVO rvo = TShopQualificationsCopier.INSTANCE.asTShopQualificationsRVO(tShopQualifications);
        return Result.ok(rvo);
    }

    /**
     * 查看主体资质
     *
     * @return
     */
    @WebLog
    @GetMapping("/qualificationsMain")
    public Result qualificationsMain() {
        TShopQualifications tShopQualifications = tShopQualificationsService.initQualificationsMain(getShopId());
        TShopQualificationsRVO rvo = TShopQualificationsCopier.INSTANCE.asTShopQualificationsRVO(tShopQualifications);
        return Result.ok(rvo);
    }

    /**
     * 修改资质
     *
     * @param t
     * @return
     */
    @WebLog
    @PostMapping("/update")
    public Result update(@RequestBody TShopQualificationsUVO t) {
        TShopQualifications bean = TShopQualificationsCopier.INSTANCE.asTShopQualifications(t);
        if (!bean.getLongTimeActive()) {
            if (bean.getNotActiveTime() == null) {
                throw new InvalidParameterException("非长期有效请填写时间");
            }
        }
        TShopQualifications temp = tShopQualificationsService.queryObject(bean.getId());
        if (temp == null) {
            throw new ResourceNotExistsException("资质不存在");
        }
        if (temp.getStatus() != ExtTShopQualifications.STATUS_NOT_SUB && temp.getStatus() != ExtTShopQualifications.STATUS_NOT_CROSS) {
            throw new InvalidParameterException("当前资质正在审核或已审核通过，无法修改");
        }
        bean.setStatus(ExtTShopQualifications.STATUS_SUB);
        tShopQualificationsService.update(bean);
        return Result.ok();
    }

    /**
     * 上传图片
     *
     * @return
     */
    @WebLog
    @PostMapping("/uploadAvatarBase64")
    public Result uploadAvatarBase64(HttpServletRequest request) {
        String url = tShopQualificationsService.uploadQualificationsBase64(getShopId(), request);
        return Result.ok(url);
    }
}
