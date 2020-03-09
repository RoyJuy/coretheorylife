package com.coretheorylife.common.sms.entity;

/**
 * @author Connor
 * 验证码防重复redis存放的实体
 */
public class SmsRedisEntity {

    private String mobile;

    private String code;

    private Long sendTime;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getSendTime() {
        return sendTime;
    }

    public void setSendTime(Long sendTime) {
        this.sendTime = sendTime;
    }
}
