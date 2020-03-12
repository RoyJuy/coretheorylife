package com.coretheorylife.modules.express.common;

/**
 * 物流查询错误码详情
 *
 * @author zhuhaitao
 * @since 2019-11-21
 */
public enum ExpressQueryErrorEnum {
    SUCCESS(200, "SUCCESS", "正常"),
    URL_ERROR(400, "URL_ERROR", "URL无效"),
    QUOTA_EXHAUSTED(403, "QUOTA_EXHAUSTED", "次数用完"),
    API_ERROR(500, "API_ERROR", "API网关错误");

    private Integer code;
    private String name;
    private String displayName;


    public int getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    ExpressQueryErrorEnum(int code, String name, String displayName) {
        this.code = code;
        this.name = name;
        this.displayName = displayName;
    }

    public static ExpressQueryErrorEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (ExpressQueryErrorEnum err : values()) {
            if (err.code.equals(code)) {
                return err;
            }
        }
        return null;
    }
}
