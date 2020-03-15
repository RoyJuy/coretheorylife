package com.coretheorylife.modules.purchaser.entity;

import com.coretheorylife.common.utils.BasePO;
import lombok.Data;

/**
 * CoachTagPO
 *
 * @author zhuhaitao
 * @since 2020/3/15
 */
@Data
public class CoachTagPO extends BasePO {
    private String tagType;
    private String tagComment;
    private int sort;
    private int coachId;
}
