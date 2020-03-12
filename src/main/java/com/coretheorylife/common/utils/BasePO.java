package com.coretheorylife.common.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * BasePO
 *
 * @author zhuhaitao
 * @since 2020-03-12
 */
@Data
public abstract class BasePO implements Serializable {
    /**
     * 实体对象ID
     */
    protected String id;

    /**
     * 创建时间
     */
    protected Date create_time;

    /**
     * 更新时间
     */
    protected Date update_time;

    /**
     * 是否删除，默认为FALSE
     */
    protected Boolean is_deleted = Boolean.FALSE;
}
