package com.coretheorylife.modules.purchaser.param;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * CoachTagCreateParam
 *
 * @author zhuhaitao
 * @since 2020/03/15
 */
@Setter
@Getter
@ToString
public class CoachTagCreateParam  {
    
    private String tagType;
    
    private String tagComment;
    
    private int sort;
    
    private int coachId;
    


}
