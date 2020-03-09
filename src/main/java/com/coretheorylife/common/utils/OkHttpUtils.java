package com.coretheorylife.common.utils;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

/**
 * @author Connor
 * 顺丰的请求封装
 */
public class OkHttpUtils {

    public static String putSF(Object obj, String url) {
        LogUtil.printParameters(OkHttpUtils.class, "obj = " + new Gson().toJson(obj), "");

        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8")
                , new Gson().toJson(obj));
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        okhttp3.Response response;
        String responseStr = null;
        try {
            response = client.newCall(request).execute();
            if (response != null) {
                responseStr = response.body().string();
            }
            if (responseStr == null) {
                return null;
            }
        } catch (IOException e) {
            LogUtil.debug(OkHttpUtils.class, e.getMessage());
        }
        LogUtil.printParameters(OkHttpUtils.class, "responseStr = " + responseStr, "");
        return responseStr;
    }
}
