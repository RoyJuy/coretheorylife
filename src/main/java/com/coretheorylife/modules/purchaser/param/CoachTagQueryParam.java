package com.coretheorylife.modules.purchaser.param;


import com.coretheorylife.modules.purchaser.common.CoachTagsType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * CoachTagQueryParam
 *
 * @author zhuhaitao
 * @since 2020/03/15
 */
@Setter
@Getter
@ToString
public class CoachTagQueryParam {
    
    private Long coachId;

    private CoachTagsType tagsType;

}
