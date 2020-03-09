package com.coretheorylife.common.sf.utils;

/**
 * @author Connor
 * 顺丰的异常处理
 */
public class SFResultUtils {

    public static String getMsgByCode(int code) {
        switch (code) {
            case 0:
                return "成功";
            case 1002:
                return "push_time错误+具体错误的参数（例如：push_time错误 请确保push_time时间与当前时间误差不超过在180秒";
            case 1003:
                return "缺少必要参数+具体错误的参数（例如：缺少必要参数 缺少参数push_time）";
            case 1004:
                return "请求参数错误+具体错误的参数（例如：请求参数错误 shop_id不能为空）";
            case 1005:
                return "重复数据提交,不要在60s内重复提交数据!";
            case 1105:
                return "操作失败+具体描述（例如：操作失败，商铺信息获取失败,商圈或者店铺不存在）";
            case 1103:
                return "数据库操作失败+具体原因（例如：数据库创建失败，创建订单失败）";
            case 2001:
                return "开发者账号不存在";
            case 2002:
                return "签名错误";
            case 2111:
                return "用户不可以发单+具体错误描述（例如：用户不可以发单，店铺绑定的dev_id与开发者不匹配'）";
            case 3007:
                return "物品重量超出上限";
            case 3006:
                return "超出配送距离";
            case 3001:
                return "订单不存在";
            case 3004:
                return "订单已创建";
            case 3014:
                return "超过最大预约时间";
            case 4007:
                return "不在店铺设置的营业时间内+具体描述（例如：不在店铺设置的营业时间，不在商圈的营业时间内）";
        }
        return "配送服务器开小差了~";
    }
}
