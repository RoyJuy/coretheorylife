package com.coretheorylife.modules.express.common;

/**
 * ExpressCompanyEnum
 *
 * @author zhuhaitao
 * @since 2019-10-22
 */
public enum ExpressCompanyEnum {
    SFEXPRESS("SFEXPRESS", "顺丰快递");

    private String name;
    private String desc;


    ExpressCompanyEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
