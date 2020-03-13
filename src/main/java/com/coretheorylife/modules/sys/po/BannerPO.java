package com.coretheorylife.modules.sys.po;

import com.coretheorylife.common.utils.BasePO;
import lombok.Data;

/**
 * BannerPO
 *
 * @author zhuhaitao
 * @since 2020-03-12
 */
@Data
public class BannerPO extends BasePO {
    private String bannerType;
    private String url;
    private String description;
    private int sort;
}
