package com.coretheorylife.modules.sys.entity;

import com.coretheorylife.modules.common.entity.BaseBean;

import java.io.Serializable;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-14
 */
public class TSysBanner extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 1，店铺banner 2，健身房banner 3-普通用户
     */
    private Integer type;

    /**
     * 描述
     */
    private String description;

    /**
     * banner所在地址
     */
    private String url;

    /**
     * 排序
     */
    private Integer sort;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescriptionDefaultValue() {
        return description == null ? "" : description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}