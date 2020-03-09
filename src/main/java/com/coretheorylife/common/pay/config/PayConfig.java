package com.coretheorylife.common.pay.config;

/**
 * @author Connor
 * 微信支付支付宝支付的配置类
 */
public class PayConfig {

    public static final String PAY_TYPE_ALI_PAY = "ALI_PAY";

    public static final String PAY_TYPE_WX_PAY = "WX_PAY";

    // 商户appid
    public static final String ALIPAY_APP_ID = "2019112969468883";
    // 私钥
    public static final String ALIPAY_RSA_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCfWyoFpNHngq2+Fy4o5/n8YD7k3KScqNYnYPnV61D9pAJqvzcwBnroR4Edpr/4RrymN/dKRPuYRDGrfkHN1itG9V22irVshB8ThEKiC9NPx/CGBM1k8AHVkzxfIVZfUYWLzw1JvM2QeMz85yFj/tZ+BGP9HoFcz8BMtbsFFhsWoqTGI0jPPKlZ8Mj4z1sFMqfu5JjcsUs4uZTHT38weTVPNkN4m5bfxQat1OjJzgLRnrsAL2UqBW4/Zhd7+wI7p8vgmK1xWMZISnlwRa69IrKyXeY2stl9qGW0xXvEOJiEg3f3wgXPFVQiVfo3LwRpd2QqvYLDrXBXL5VVvY3yjdd5AgMBAAECggEAGozO0IfobQEJv30PNMOJk/HZKLpWNr+uhnsSxQBiyw+TU4OuRzMdMSwQqAcLPutSLQNwERCzNmhOOjtb7VZ8eWMSDQLJPV456z+C9oqv10ABo+KS8flG5PWV/meIg3MKpAOIPDvXp/Voec5scsOXqwFCQ37coMEAUgeJNEy9kKSfA1Toy1XjWPGKR4qm6oI/zrE5i0zXv0/EBgtd1gTc24B227LkqJmW5q6N7w2ERrJ4M9HUw8vk3xGN1t6MwIMN7/xAIoZylKBlZCiUh4/WwMOE7RcSQY7dtiML1xv5CRkEcvp4hJnC/KKdVlRTM1WU00tOmDdNEq+gvsBUFVh3PQKBgQDZAGHWFKb+l3e/HxYL4n390zGzjpdHDjLZdxY4Ym9SR1kYDHylhTEAaEAZCkXuZLtAS1GLn/Drj5jx9tWxsW0NyWCnTdCkw3LW2+hqk9jJiRdLmdjrI4F89F+qjbra0XUKc7IQ3dAw4rrIzS3aJSt++ZnGRcnv+tpH8UmCSIOwywKBgQC7/q7OXv2zmj5BdgMmvETemo+a2o3D1BI5SjBqwtC63Dl9Mit0SN8Dtbu3ZcuqQntcXIYOfN1r8hJKA73b69ZKwxGqHvg+hOPHhDYMqaq7l752xh1+FLo1ywAunZW45DhV1g17wG1DK/fli9IZCtxEpBbSDJpkWAC5iXjJEEWkSwKBgAQ35677s8tbMm66sfkFLCHVCzBMY1B0TDTCBeKOt09IJ8k55OpqzmsNm8Fg278ooiM705f9QfeyUOzTOZA8vLv54DEgaB/r1L2shLYdractTRChKwBXLls5fOqZ2roKPFY5rYp6ZWOt5KempW+KLXBIdd7O2IAbxkaDwEQSGM1FAoGAYFV24DufB9zfUA4YOU46gFN1iSW7hYDzwbW5r8uayFY3g2clC1aYKT+ELMuWHO4qZr7m1x+3GyyVoKXgMYTdb7wcHi/2h5rzWfbu93guDCkLKbQFwuj+LriSpFCOO4t/LsUcbbDCjKxIQLFwfPKqwuXO594bc5YA8RJ3+ZhEB5cCgYBs+rAxIuUC1jJL6Yf9npkR882l9kqvloRefwSDF0joNmdpmUFArQXQL+xEpC3ou9/sCvYdWqzQQtV2XuWT+qrRDblLuzpkEjkLvklvN5mg7ZRBIMLhmya5zid4D/a3dcmVegM99ibyhwkn0NkvtrBpSab7yy38RmEWc+1ebLiKzg==";

    public static final String ALIPAY_NOTIFY_URL = "http://www.coretheorylife.com/app/pay/aliNotify";

    public static final String ALIPAY_URL = "https://openapi.alipay.com/gateway.do";
    // 公钥
    public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn1sqBaTR54KtvhcuKOf5/GA+5NyknKjWJ2D51etQ/aQCar83MAZ66EeBHaa/+Ea8pjf3SkT7mEQxq35BzdYrRvVdtoq1bIQfE4RCogvTT8fwhgTNZPAB1ZM8XyFWX1GFi88NSbzNkHjM/OchY/7WfgRj/R6BXM/ATLW7BRYbFqKkxiNIzzypWfDI+M9bBTKn7uSY3LFLOLmUx09/MHk1TzZDeJuW38UGrdToyc4C0Z67AC9lKgVuP2YXe/sCO6fL4JitcVjGSEp5cEWuvSKysl3mNrLZfahltMV7xDiYhIN398IFzxVUIlX6Ny8EaXdkKr2Cw61wVy+VVb2N8o3XeQIDAQAB";

    public static final String Wx_Pay_SignType = "MD5";

    public static final String Wx_Pay_MchId = "1568781921";

    public static final String Wx_Pay_Appid = "wx338fdd1442ef4d08";

    public static final String Wx_Pay_Secret_Key = "ddd876c24d77852db7649ece6c36828d";

    public static final String Wx_Pay_NotifyUrl = "http://www.coretheorylife.com/app/pay/wxNotify";

}

