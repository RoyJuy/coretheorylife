package com.coretheorylife.common.utils;

/**
 * 单输出对象的通用结果封装类
 *
 * @param <T> 输出数据对象类型
 */
public class TSingleResult<T> extends BaseResult {

    private static final long serialVersionUID = -5675449690884417028L;

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("TSingleResult [statusCode=%s, comments=%s, data=%s]",
                this.getStatusCode(), this.getComments(), data);
    }
}