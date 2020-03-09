package com.coretheorylife.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一基础返回格式
 */
public class BaseResult implements Response {

    private static final long serialVersionUID = -5307177740321084526L;

    /**
     * 错误信息返回请参考common-error
     */
    @Deprecated
    public static int Success_Status_Code = 200;
    @Deprecated
    public static String Success_Message = "成功";
    @Deprecated
    public static int SYS_ERROR_CODE = 500;
    @Deprecated
    public static String SYS_ERROR_MSG = "请求失败，服务器发生了错误";

    private int statusCode;

    /**
     * RE010111000001 格式，建错误码文档
     */
    private String errorCode;

    private String comments;

    private Map<String, Object> result = new HashMap<String, Object>();

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result.putAll(result);
    }

    public void setResult(String key, Object value) {
        result.put(key, value);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean success() {
        return this.statusCode == Success_Status_Code;
    }

    @Override
    public String toString() {
        return String.format("CommonResult [statusCode=%s, errorCode=%s, comments=%s]", statusCode, errorCode, comments);
    }

}
