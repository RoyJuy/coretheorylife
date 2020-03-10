package com.coretheorylife.modules.payment.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.coretheorylife.common.utils.Result;
import org.apache.commons.lang3.CharSetUtils;
import org.bouncycastle.util.encoders.UTF8;
import org.springframework.stereotype.Service;

import java.nio.charset.CharsetDecoder;

/**
 * PaymentService
 *
 * @author zhuhaitao
 * @since 2020-03-09
 */
@Service
public class PaymentService {
    public Result pay(String orderNo) throws AlipayApiException {
//构造client
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
//设置网关地址
        certAlipayRequest.setServerUrl("https://openapi.alipay.com/gateway.do");
//设置应用Id
        certAlipayRequest.setAppId("2019120269644186");
//设置应用私钥
        certAlipayRequest.setPrivateKey("MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCfLqnCODl2vdz92RqBWeb22N8r3V+E0I5aAlqdoSJ7TPqfrmpld2Dz+cWtDFti2bcnBZow5ZwTTxaIjrzznVmFgPxAy9kWSpsiBmvfrN6n2Vb2sstQqRNshb/P/t/Go0ibhd3p8DBQoFxwNlsaYE9zqJKV6qULLvowdWUKC62AAFrYzBd3sg66iVnDsXXoE/QdmcfuoX2GDyxhmywMV9mSUSHElkbp0uwkkmJAETgESUs4b4Wds4+nmq2qM6Z3kAd/INCs2DVQXNFPxyHDeH8qiVJeRFp604EiDkbt5eUkTZtP9+IvbG93YGZMhCtLMa3UB06uFCSXSj0H87kSER7fAgMBAAECggEAUa8CUbXEVxhqtKCZp1LY4Ea9jqbUgzT6N1oJ4eVz6k3ANfysgFDYIZpEQ96ZbopGH/ISA5Fvm8Dz0TNd5q0R6R4dU6rHRVcXcEhXRrpQr1Up+QIartN0MjYYDcW+UxIrChORoqAsStNfW/2olkphuvn/7oowEyMSI5e6N4NyjsHQgq/Y8wem+Q8hJEQAzticqGyvskM3WAUCka0INJzbwRx5mKS28vmZhqEx1k7lp9x/URJWXnrIkbboXfZoaCweFMWfRJW2QB0TrGANeaswq9ex/6lS/7DshEhnJ4YUBv/WWVWCg6fMdWTPqOxL1KNz3sRskIUD7a+BWvs7ufTdYQKBgQDSRkDv+//ugEp+XQ1yUFqPMzEP4otgJCKwyjRnlJwLkKJ7i17fJSI1Fff8xKRQmBLkqDqY9oSMqnYtE5QIlO3a1ZZQ2Pl5zZSZMQoRw5EotSmwApAx+vVW9nDtqSsvo90UE9lf+VLroB0dni1Q0ou85Ka1I/wPaqp/uTOgep2xeQKBgQDBzCpj21yrtYCYS8K+f1bGDilDJXGGkwzv2w/pnkI7+S9pqsnxvDDbG174vL+HE4dTO0GzuPEduCJHZgVf3xjwWetL4UpkzwQsyDB3IezkX5mIwWiYDpFTOL8TREstfjfC1HD/A07v2YGirNExF3H53sPiQnsw2NzzBBW+ZIFVFwKBgQDBtLBbo6T4PDzjvasGdNmH85uty3+juIYwoIW4KeG6kans784c+KNTjgJeW3QXPpChDgy1HtuqjdnB2rhTU4buQjZwEgF4YJcUrGVfSe6uNn3JxAK72DksvGf5uA6tm2Gs/kAQtqjZoS1RPIb4Xo0WHPkqA5VPSm74rE7P9kTQ2QKBgGsgM7J9OM3GB+6nul/ZPhs/CroOQaH1OWqA+lvWWqCSTw4nFXhl4c/MYoQ2udyuA9kTYW86ZTZbab9z+raTOVLrMbEBOUFeWd1zT68a9rsKyXEaEHo1W0nYjW7WCoR8R9CP5GJi7siQwCMvSnfLkPphlIBG5ZgL2J8Q/AAByKhDAoGBAINxNxMTn5rehDFVAWL1El5bDBn/86FarOZXSRO6gOhapWASqp0wTNXtlo9S7YGBoEzqlr8pPA6Vy/hUmn2Df8fA0l1m5qxQXAtRKSqY57ap0dWbjTMJFpK19cMNvwPbdRpBgHcYBemojJDZqCVW/hgceL5HprNdqAOtUpWtkwu+");
//设置请求格式，固定值json
        certAlipayRequest.setFormat("json");
//设置字符集
        certAlipayRequest.setCharset("utf-8");
//设置签名类型
        certAlipayRequest.setSignType("RSA2");
//设置应用公钥证书路径
        certAlipayRequest.setCertPath("/opt/coretheorylife/config/appCertPublicKey_2019120269644186.crt");
//设置支付宝公钥证书路径
        certAlipayRequest.setAlipayPublicCertPath("/opt/coretheorylife/config/alipayCertPublicKey_RSA2.crt");
//设置支付宝根证书路径
        certAlipayRequest.setRootCertPath("/opt/coretheorylife/config/alipayRootCert.crt");
//构造client
        AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);

//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
//SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody("我是测试数据");
        model.setSubject("App支付测试Java");
        model.setOutTradeNo(orderNo);
        model.setTimeoutExpress("30m");
        model.setTotalAmount("0.01");
        model.setProductCode("QUICK_MSECURITY_PAY");
        request.setBizModel(model);
        request.setNotifyUrl("商户外网可以访问的异步地址");
        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
//            System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
            return Result.ok(response.getBody());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return Result.failAtServer("server error");
    }

}
