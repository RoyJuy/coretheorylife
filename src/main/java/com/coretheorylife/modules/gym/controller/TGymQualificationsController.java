package com.coretheorylife.modules.gym.controller;

import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.exception.ResourceNotExistsException;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.gym.copier.TGymQualificationsCopier;
import com.coretheorylife.modules.gym.entity.TGymQualifications;
import com.coretheorylife.modules.gym.entity.ext.ExtTGymQualifications;
import com.coretheorylife.modules.gym.service.TGymQualificationsService;
import com.coretheorylife.modules.gym.vo.TGymQualificationsRVO;
import com.coretheorylife.modules.gym.vo.TGymQualificationsUVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/gym/qualifications")
public class TGymQualificationsController extends BaseController {

    @Autowired
    private TGymQualificationsService tGymQualificationsService;

    /**
     * 查看资质
     *
     * @return
     */
    @WebLog
    @GetMapping("/info")
    public Result info() {
        TGymQualifications tGymQualifications = tGymQualificationsService.init(getGymId());
        TGymQualificationsRVO rvo = TGymQualificationsCopier.INSTANCE.asTGymQualificationsRVO(tGymQualifications);
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
    public Result update(@RequestBody TGymQualificationsUVO t) {
        TGymQualifications bean = TGymQualificationsCopier.INSTANCE.asTGymQualifications(t);
        if (!bean.getLongTimeActive()) {
            if (bean.getNotActiveTime() == null) {
                throw new InvalidParameterException("非长期有效请填写时间");
            }
        }
        TGymQualifications temp = tGymQualificationsService.queryObject(bean.getId());
        if (temp == null) {
            throw new ResourceNotExistsException("资质不存在");
        }
        if (temp.getStatus() != ExtTGymQualifications.STATUS_NOT_SUB && temp.getStatus() != ExtTGymQualifications.STATUS_NOT_CROSS) {
            throw new InvalidParameterException("当前资质正在审核或已审核通过，无法修改");
        }
        bean.setStatus(ExtTGymQualifications.STATUS_SUB);
        tGymQualificationsService.update(bean);
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
        String url = tGymQualificationsService.uploadQualificationsBase64(getGymId(), request);
        return Result.ok(url);
    }
}
