package com.coretheorylife.modules.shop.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wcyong
 * @date 2019-12-03
 */
public class TOrderLogRVO implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 日志描述
     */
    private Integer code;

    /**
     * 日志代码
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}