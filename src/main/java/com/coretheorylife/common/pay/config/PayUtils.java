package com.coretheorylife.common.pay.config;

import com.egzosn.pay.ali.api.AliPayConfigStorage;
import com.egzosn.pay.common.api.BasePayConfigStorage;
import com.egzosn.pay.common.http.HttpConfigStorage;
import com.egzosn.pay.common.util.sign.SignUtils;
import com.egzosn.pay.wx.api.WxPayConfigStorage;
import org.springframework.stereotype.Component;

/**
 * @author Connor
 * 移动支付的工具类
 */
@Component
public class PayUtils {

    public BasePayConfigStorage getPayConfigStorage(String payType) {
        if (payType.equals(PayConfig.PAY_TYPE_ALI_PAY)) {
            return getAliPayConfig();
        }
        if (payType.equals(PayConfig.PAY_TYPE_WX_PAY)) {
            return getWxPayConfig();
        }
        return null;
    }


    /**
     * 获取支付宝支付配置
     *
     * @return
     */
    private AliPayConfigStorage getAliPayConfig() {
        AliPayConfigStorage aliPayConfigStorage = new AliPayConfigStorage();
        aliPayConfigStorage.setAppId(PayConfig.ALIPAY_APP_ID);
        aliPayConfigStorage.setKeyPublic(PayConfig.ALIPAY_PUBLIC_KEY);
        aliPayConfigStorage.setKeyPrivate(PayConfig.ALIPAY_RSA_PRIVATE_KEY);
        aliPayConfigStorage.setNotifyUrl(PayConfig.ALIPAY_NOTIFY_URL);
        aliPayConfigStorage.setSignType(SignUtils.RSA2.name());
        aliPayConfigStorage.setInputCharset("utf-8");
        //是否为测试账号，沙箱环境
        aliPayConfigStorage.setTest(false);
        return aliPayConfigStorage;
    }


    /**
     * 获取微信支付配置
     *
     * @return
     */
    private WxPayConfigStorage getWxPayConfig() {
        WxPayConfigStorage wxPayConfigStorage = new WxPayConfigStorage();
        wxPayConfigStorage.setMchId(PayConfig.Wx_Pay_MchId);
        wxPayConfigStorage.setAppid(PayConfig.Wx_Pay_Appid);
//        wxPayConfigStorage.setKeyPublic(PayConfig.Wx_Pay_Public_Key);
        wxPayConfigStorage.setSecretKey(PayConfig.Wx_Pay_Secret_Key);
        wxPayConfigStorage.setNotifyUrl(PayConfig.Wx_Pay_NotifyUrl);
//        wxPayConfigStorage.setReturnUrl(PayConfig.Wx_Pay_ReturnUrl);
        wxPayConfigStorage.setSignType(PayConfig.Wx_Pay_SignType);
        wxPayConfigStorage.setInputCharset("utf-8");
        return wxPayConfigStorage;
    }

    public HttpConfigStorage getAliHttpConfigStorage() {
        //请求连接池配置
        HttpConfigStorage httpConfigStorage = new HttpConfigStorage();
        //最大连接数
        httpConfigStorage.setMaxTotal(20);
        //默认的每个路由的最大连接数
        httpConfigStorage.setDefaultMaxPerRoute(10);
        return httpConfigStorage;
    }


    public HttpConfigStorage getWxHttpConfigStorage() {
        HttpConfigStorage httpConfigStorage = new HttpConfigStorage();
        //ssl 退款证书相关 不使用可注释
//        if(!"ssl 退款证书".equals(PayConfig.WX_PAY_KEYSTORE)){
//            httpConfigStorage.setKeystore(PayConfig.WX_PAY_KEYSTORE);
//            httpConfigStorage.setStorePassword(PayConfig.WX_PAY_STORE_PASSWORD);
//            httpConfigStorage.setPath(true);
//        }
        //请求连接池配置
        //最大连接数
        httpConfigStorage.setMaxTotal(20);
        //默认的每个路由的最大连接数
        httpConfigStorage.setDefaultMaxPerRoute(10);
        return httpConfigStorage;
    }
}
