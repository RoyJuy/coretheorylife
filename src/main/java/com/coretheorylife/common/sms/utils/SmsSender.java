package com.coretheorylife.common.sms.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.utils.RedisUtils;
import com.coretheorylife.common.sms.entity.SmsRedisEntity;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * @author Connor
 * 短信发送服务
 */
@Component
public class SmsSender {

    public static final String accessKey = "LTAIDLH7eqrBpm3l";

    public static final String secret = "Quyyz7BWcaj2j7YZedkgWVKxDyq2UY";

    public static final String SMS_SEND_KEY_PREFIX = "SMS.CODE.";

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 发送验证码，已实现基于redis的60防重复
     * @param mobile
     * @param code
     */
    public void sendSms(String mobile, String code) {
        String str = redisUtils.get(SMS_SEND_KEY_PREFIX + mobile);
        if (str != null) {
            SmsRedisEntity smsRedisEntity = new Gson().fromJson(str, SmsRedisEntity.class);
            if (new Date().getTime() - smsRedisEntity.getSendTime() < 60L * 1000) {
                throw new InvalidParameterException("你的手速太快了，请" + (60L * 1000 - new Date().getTime() + smsRedisEntity.getSendTime()) / 1000 + "秒后再试");
            }
        }
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKey, secret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", "CTF");
        request.putQueryParameter("TemplateCode", "SMS_165675438");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            Map<String, Object> result = new Gson().fromJson(response.getData(), Map.class);
            if (!result.get("Code").equals("OK")) {
                throw new InvalidParameterException(result.get("Message") == null ? "短信发送失败，请重试" : result.get("Message").toString());
            } else {
                SmsRedisEntity smsRedisEntity = new SmsRedisEntity();
                smsRedisEntity.setCode(code);
                smsRedisEntity.setMobile(mobile);
                smsRedisEntity.setSendTime(new Date().getTime());
                redisUtils.set(SMS_SEND_KEY_PREFIX + mobile, new Gson().toJson(smsRedisEntity), 60 * 30L);
            }
        } catch (ServerException e) {
            throw new InvalidParameterException("短信发送失败，请重试");
        } catch (ClientException e) {
            throw new InvalidParameterException("短信发送失败，请重试");
        }
    }

    /**
     * TODO 订单被拒短信提醒
     * @param mobile
     */
    public void sendOrderRejectMessage(String mobile) {

    }

    /**
     * 发送订单提醒
     * @param mobile
     * @param orderNo
     */
    public void sendOrderTips(String mobile, String orderNo) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKey, secret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", "CTF");
        request.putQueryParameter("TemplateCode", "SMS_169902776");
        request.putQueryParameter("TemplateParam", "{\"orderSeq\":\"" + "炒饭" + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            Map<String, Object> result = new Gson().fromJson(response.getData(), Map.class);
            if (!result.get("Code").equals("OK")) {
            }
        } catch (Exception e) {
        }
    }

    public void sendSms(String mobile) {
        sendSms(mobile, getIdentifyCode());
    }

    private static String getIdentifyCode() {
        Random random = new Random();
        int identify = random.nextInt(899999) + 100000;
        return String.valueOf(identify);
    }
}
