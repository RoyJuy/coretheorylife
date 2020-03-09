package com.coretheorylife.modules.purchaser.vo;

import org.hibernate.validator.constraints.NotBlank;

public class TPurchaserTargetCVO {
    /**
     * 描述
     */
    @NotBlank(message = "name不能为空")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
