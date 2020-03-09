package com.coretheorylife.modules.purchaser.entity;

import com.coretheorylife.modules.common.entity.BaseBean;

import java.io.Serializable;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-14
 */
public class TPurchaserNotify extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long purchaserId;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 消息类型 1-文本消息
     */
    private Integer messageType;

    /**
     * 系统消息，否则是商铺消息
     */
    private Boolean messageSys;

    /**
     * 消息来自哪个商铺
     */
    private Long messageFromShopId;

    /**
     * 是否已读
     */
    private Boolean hasRead;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(Long purchaserId) {
        this.purchaserId = purchaserId;
    }

    public String getMessageDefaultValue() {
        return message == null ? "" : message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Integer getMessageTypeDefaultValue() {
        return messageType == null ? 1 : messageType;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public Boolean getMessageSysDefaultValue() {
        return messageSys == null ? true : messageSys;
    }

    public Boolean getMessageSys() {
        return messageSys;
    }

    public void setMessageSys(Boolean messageSys) {
        this.messageSys = messageSys;
    }

    public Long getMessageFromShopId() {
        return messageFromShopId;
    }

    public void setMessageFromShopId(Long messageFromShopId) {
        this.messageFromShopId = messageFromShopId;
    }

    public Boolean getHasReadDefaultValue() {
        return hasRead == null ? false : hasRead;
    }

    public Boolean getHasRead() {
        return hasRead;
    }

    public void setHasRead(Boolean hasRead) {
        this.hasRead = hasRead;
    }
}