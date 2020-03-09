package com.coretheorylife.modules.sys.entity;

import com.coretheorylife.modules.common.entity.BaseBean;

import java.io.Serializable;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-20
 */
public class TSysVersion extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 版本号
     */
    private String versionNo;

    /**
     * 1-无需提示更新 2-提示更新 3-强制更新
     */
    private Integer type;

    /**
     * 更新地址，ios可以忽略直接跳转app store
     */
    private String url;

    /**
     * 更新内容，建议使用Markdown语法
     */
    private String message;

    /**
     * 平台，具体数据请单独定义
     */
    private String platform;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersionNoDefaultValue() {
        return versionNo == null ? "" : versionNo;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo == null ? null : versionNo.trim();
    }

    public Integer getTypeDefaultValue() {
        return type == null ? 1 : type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrlDefaultValue() {
        return url == null ? "" : url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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

    public String getPlatformDefaultValue() {
        return platform == null ? "" : platform;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }
}