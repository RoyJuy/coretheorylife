package com.coretheorylife.modules.purchaser.param;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * CoachTagUpdateParam
 *
 * @author zhuhaitao
 * @since 2020/03/15
 */
@Setter
@Getter
@ToString
public class CoachTagUpdateParam  {
    
    private String id;
    
    private String tagType;
    
    private String tagComment;
    
    private int sort;
    
    private int coachId;
    

}
