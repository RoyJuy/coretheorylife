package com.coretheorylife.modules.express.service;

import com.alibaba.fastjson.JSONObject;
import com.coretheorylife.common.utils.HttpUtils;
import com.coretheorylife.modules.express.common.ExpressQueryErrorEnum;
import com.coretheorylife.modules.express.common.ExpressRouteInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * ExpressQuery
 *
 * @author zhuhaitao
 * @since 2019-10-24
 */
@Component
public class ExpressQuery {

    private static final String EXPRESS_COMPANY = "EXPRESS_COMPANY";

    /**
     * 这里的空格是必要的
     */
    private static final String APPCODE = "APPCODE ";



    private static final String appCode = "dbf184c8a2384be3adfc5fa99f4e0bcd";

    public ExpressRouteInfo query(String expressNumber, String type) {
        String host = "https://wuliu.market.alicloudapi.com";
        String path = "/kdi";
        String method = "GET";
        // !!!替换填写自己的AppCode 在买家中心查看
        Map<String, String> headers = new HashMap<String, String>();
        //格式为:Authorization:APPCODE 83359fd73fe11248385f570e3c139xxx
        headers.put("Authorization", APPCODE + appCode);
        Map<String, String> querys = new HashMap<String, String>();
        // !!! 请求参数
        querys.put("no", expressNumber);
        if (StringUtils.isNotBlank(type)) {
            // !!! 请求参数
            querys.put("type", type);
        }
        //JDK 1.8示例代码请在这里下载：  http://code.fegine.com/Tools.zip
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 或者直接下载：
             * http://code.fegine.com/HttpUtils.zip
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             * 相关jar包（非pom）直接下载：
             * http://code.fegine.com/aliyun-jar.zip
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //System.out.println(response.toString());如不输出json, 请打开这行代码，打印调试头部状态码。
            //状态码: 200 正常；400 URL无效；401 appCode错误； 403 次数用完； 500 API网管错误
            //获取response的body
            //输出json
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                ExpressQueryErrorEnum expressQueryErrorEnum = ExpressQueryErrorEnum.getByCode(statusCode);
//                ReErrorPrinter.printError(ErrorCodeEnum.RE010624514001, expressQueryErrorEnum.getDisplayName());
            }
            String responseJson = EntityUtils.toString(response.getEntity());
            System.out.println("-------------" + responseJson);
//            ExpressRouteInfo expressRouteInfo = new Gson().fromJson(EntityUtils.toString(response.getEntity()), ExpressRouteInfo.class);
            ExpressRouteInfo expressRouteInfo = JSONObject.parseObject(responseJson, ExpressRouteInfo.class);
            System.out.println("++++++++++++" + expressRouteInfo.toString());
            mergeExpressCompanyInfo(expressRouteInfo);
            return expressRouteInfo;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void mergeExpressCompanyInfo(ExpressRouteInfo expressRouteInfo) {
        if (StringUtils.equals(expressRouteInfo.getStatus(), "0") || expressRouteInfo.getResult().getType() == null) {
            return;
        }
        String type = expressRouteInfo.getResult().getType();
        Map<String, Object> expressCompany = queryExpressCompany(type);
        if (expressCompany == null) {
            return;
        }
        expressRouteInfo.getResult().setExpName(expressCompany.get(EXPRESS_COMPANY).toString());
    }

    private Map<String, Object> queryExpressCompany(String type) {
        String host = "http://wuliu.market.alicloudapi.com";
        String path = "/getExpressList";
        String method = "GET";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", APPCODE + appCode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("type", type);


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 或者直接下载：
             * http://code.fegine.com/HttpUtils.zip
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             * 相关jar包（非pom）直接下载：
             * http://code.fegine.com/aliyun-jar.zip
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //System.out.println(response.toString());
            //获取response的body
//            System.out.println(EntityUtils.toString(response.getEntity()));
            JSONObject jsonObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity()));
            if (StringUtils.equals(jsonObject.getString("status"), "200")) {
                Map<String, Object> result = new HashMap<>();
                result.put(EXPRESS_COMPANY, jsonObject.getJSONObject("result").get(type));
                return result;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
