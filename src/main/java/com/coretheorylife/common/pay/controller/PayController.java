package com.coretheorylife.common.pay.controller;

import com.coretheorylife.common.annotation.AuthIgnore;
import com.coretheorylife.common.annotation.WebLog;
import com.coretheorylife.common.pay.config.PayConfig;
import com.coretheorylife.common.pay.config.PayUtils;
import com.coretheorylife.common.utils.LogUtil;
import com.coretheorylife.common.utils.PageUtils;
import com.coretheorylife.common.utils.Query;
import com.coretheorylife.common.utils.Result;
import com.coretheorylife.modules.common.controller.BaseController;
import com.coretheorylife.modules.purchaser.copier.TPurchaserNotifyCopier;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserNotify;
import com.coretheorylife.modules.purchaser.service.TPurchaserNotifyService;
import com.coretheorylife.modules.purchaser.vo.TPurchaserNotifyRVO;
import com.coretheorylife.modules.shop.service.TOrderService;
import com.egzosn.pay.ali.api.AliPayService;
import com.egzosn.pay.common.api.BasePayConfigStorage;
import com.egzosn.pay.wx.api.WxPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.coretheorylife.common.pay.config.PayConfig.ALIPAY_PUBLIC_KEY;

/**
 * @author Connor
 * 支付回调的类
 */
@Validated
@RestController
@RequestMapping("/pay")
public class PayController extends BaseController {

    @Autowired
    private PayUtils payUtils;

    @Autowired
    private TOrderService tOrderService;

    @WebLog
    @AuthIgnore
    @GetMapping("/aliNotify")
    public String aliNotify(HttpServletRequest request) throws IOException {
        BasePayConfigStorage payConfigStorage = payUtils.getPayConfigStorage(PayConfig.PAY_TYPE_ALI_PAY);
        AliPayService aliPayService = new AliPayService(payConfigStorage, payUtils.getAliHttpConfigStorage());
        //获取支付方返回的对应参数
        Map<String, Object> params = aliPayService.getParameter2Map(request.getParameterMap(), request.getInputStream());
        boolean signVerified = aliPayService.verify(params);
        if (signVerified) {
            tOrderService.paySuccess(params.get("out_trade_no").toString(), params.get("trade_no").toString());
        } else {
            return aliPayService.getPayOutMessage("fail", "失败").toMessage();
        }
        LogUtil.debug(PayController.class, params);
        return aliPayService.getPayOutMessage("success", "成功").toMessage();
    }

    @WebLog
    @AuthIgnore
    @GetMapping("/wxNotify")
    public String wxNotify(HttpServletRequest request) throws IOException {
        BasePayConfigStorage payConfigStorage = payUtils.getPayConfigStorage(PayConfig.PAY_TYPE_ALI_PAY);
        WxPayService wxPayService = new WxPayService(payConfigStorage, payUtils.getWxHttpConfigStorage());
        //获取支付方返回的对应参数
        Map<String, Object> params = wxPayService.getParameter2Map(request.getParameterMap(), request.getInputStream());
        boolean signVerified = wxPayService.verify(params);
        if (signVerified) {
            tOrderService.paySuccess(params.get("out_trade_no").toString(), params.get("transaction_id").toString());
        } else {
            return wxPayService.getPayOutMessage("fail", "失败").toMessage();
        }
        LogUtil.debug(PayController.class, params);
        return wxPayService.getPayOutMessage("success", "成功").toMessage();
    }
}
