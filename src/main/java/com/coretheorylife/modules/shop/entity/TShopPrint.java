package com.coretheorylife.modules.shop.entity;

import com.coretheorylife.modules.common.entity.BaseBean;

import java.io.Serializable;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-01-14
 */
public class TShopPrint extends BaseBean implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 品牌 0-未知 1-外卖管家 2-飞蛾 3-易联云 4-中崎WiFi打印机
     */
    private Integer brand;

    /**
     * 打印机状态 1-正在使用 2-弃用
     */
    private Integer status;

    private String name;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBrandDefaultValue() {
        return brand == null ? 0 : brand;
    }

    public Integer getBrand() {
        return brand;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }

    public Integer getStatusDefaultValue() {
        return status == null ? 2 : status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNameDefaultValue() {
        return name == null ? "" : name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}