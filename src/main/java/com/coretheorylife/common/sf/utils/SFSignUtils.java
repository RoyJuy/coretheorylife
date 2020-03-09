package com.coretheorylife.common.sf.utils;

import com.coretheorylife.common.utils.Md5Utils;

import java.io.UnsupportedEncodingException;

/**
 * @author Connor
 * 顺丰签名以及key的配置
 */
public class SFSignUtils {

    public static final String APP_ID = "1555692742";

    public static final String APP_KEY = "6d1c5e801cb2513f5c0c3a486879f531";

    public static final String SHOP_ID = "3243279847393";

    public static String getSign(String param) {
        String keyStr = param + "&" + SFSignUtils.APP_ID + "&" + SFSignUtils.APP_KEY;
        String md5 = Md5Utils.MD5Encode(keyStr, "UTF-8");
        org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();
        String sign = null;
        try {
            sign = base64.encodeToString(md5.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sign;
    }
}
