package com.coretheorylife.common.utils;


import java.util.List;

public class ResultBuilder {

    @SuppressWarnings("unchecked")
    public static <T extends BaseResult> T succ(Class<T> clz) {
        try {
            BaseResult rs = clz.newInstance();
            rs.setStatusCode(BaseResult.Success_Status_Code);
            rs.setComments(BaseResult.Success_Message);
            return (T) rs;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> TSingleResult<T> succTSingle(T value) {
        TSingleResult<T> result = new TSingleResult<>();
        result.setData(value);
        result.setStatusCode(BaseResult.Success_Status_Code);
        result.setComments(BaseResult.Success_Message);
        return result;
    }



    @SuppressWarnings("unchecked")
    public static <T extends BaseResult> T fail(Class<T> clz, int errStatusCode, String errmsg) {
        try {
            BaseResult rs = clz.newInstance();
            rs.setStatusCode(errStatusCode);
            rs.setComments(errmsg);
            return (T) rs;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends BaseResult> T fail(Class<T> clz, int errStatusCode, String errorCode, String errmsg) {
        try {
            BaseResult rs = clz.newInstance();
            rs.setStatusCode(errStatusCode);
            rs.setErrorCode(errorCode);
            rs.setComments(errmsg);
            return (T) rs;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends BaseResult> T fail(Class<T> clz, Error error) {
        try {
            BaseResult rs = clz.newInstance();
            rs.setStatusCode(500);
            rs.setComments("error");
            return (T) rs;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> TSingleResult<T> failTSingle(Error error) {
        TSingleResult<T> result = new TSingleResult<>();
        result.setStatusCode(500);
        result.setComments("error");
        return result;
    }

    public static <T> TSingleResult<T> failTSingle(int errcode, String errmsg) {
        TSingleResult<T> result = new TSingleResult<>();
        result.setStatusCode(errcode);
        result.setComments(errmsg);
        return result;
    }

    public static <T> TSingleResult<T> failTSingle(int errStatusCode, String errorCode, String errmsg) {
        TSingleResult<T> result = new TSingleResult<>();
        result.setStatusCode(errStatusCode);
        result.setErrorCode(errorCode);
        result.setComments(errmsg);
        return result;
    }


}
