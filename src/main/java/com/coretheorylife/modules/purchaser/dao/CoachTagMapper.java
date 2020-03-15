package com.coretheorylife.modules.purchaser.dao;

import com.coretheorylife.modules.purchaser.entity.CoachTagPO;
import com.coretheorylife.modules.purchaser.param.CoachTagQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * CoachTag的MyBatis数据访问mapper
 *
 * @author zhuhaitao
 * @since 2020/03/15
 */
@Mapper
public interface CoachTagMapper {

    @Insert("INSERT INTO coach_tag (id, tag_type, tag_comment, sort, coach_id) VALUES (#{po.id}, #{po.tag_type}, #{po.tag_comment}, #{po.sort}, #{po.coach_id})")
    Integer create(@Param("po") CoachTagPO coachTagPO);

    @Update("UPDATE coach_tag set is_deleted = 1 WHERE id=#{id}")
    Integer delete(@Param("id") String id);

    @Select("SELECT id, create_time, update_time, tag_type, tag_comment, sort, coach_id FROM coach_tag WHERE id=#{id} AND is_deleted = 0")
    CoachTagPO findOne(@Param("id") String id);

    @Update("<script>" +
            "UPDATE coach_tag " +
            "<set>" +
            "<if test='po.tag_type != null'>tag_type = #{po.tag_type}, </if>" +
            "<if test='po.tag_comment != null'>tag_comment = #{po.tag_comment}, </if>" +
            "<if test='po.sort != null'>sort = #{po.sort}, </if>" +
            "<if test='po.coach_id != null'>coach_id = #{po.coach_id}</if>" +
            "</set> " +
            "WHERE id=#{po.id}" +
            "</script>")
    Integer update(@Param("po") CoachTagPO coachTagPO);

    @Select("<script>" +
            "SELECT id, create_time, update_time, tag_type, tag_comment, sort, coach_id FROM t_coach_tag WHERE is_deleted = 0 " +
            "<if test='param.coachId != null' > and coach_id = #{param.coachId}</if>" +
            "<if test='param.tagsType != null' > and tag_type = #{param.tagsType}</if>" +
            "</script>")
    List<CoachTagPO> findAll(@Param("param") CoachTagQueryParam queryParam);
}
