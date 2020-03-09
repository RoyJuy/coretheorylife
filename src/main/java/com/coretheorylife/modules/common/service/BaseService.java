package com.coretheorylife.modules.common.service;

import com.coretheorylife.modules.common.entity.BaseBean;
import com.coretheorylife.modules.common.example.BaseExample;

import java.util.List;

/**
 * @author Connor
 * 逆向工程增强之通用Service封装
 */
public interface BaseService<T extends BaseBean, E extends BaseExample> {

    int save(T t);

    int update(T t);

    int delete(Long id);

    T queryObject(Long id);

    List<T> selectByExample(E example);
}
