package com.coretheorylife.modules.sys.dao.mapper;

import com.coretheorylife.modules.sys.common.param.BannerQueryParam;
import com.coretheorylife.modules.sys.po.BannerPO;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Banner的MyBatis数据访问mapper
 *
 * @author zhuhaitao
 * @since 2020/03/12
 */
@Mapper
public interface BannerMapper {

    @Insert("INSERT INTO t_banner (id, type, url, description, sort) VALUES (#{po.id}, #{po.type}, #{po.url}, #{po.description}, #{po.sort})")
    Integer create(@Param("po") BannerPO bannerPO);

    @Update("UPDATE t_banner set is_deleted = 1 WHERE id=#{id}")
    Integer delete(@Param("id") String id);

    @Select("SELECT id, create_time, update_time, type, url, description, sort FROM t_banner WHERE id=#{id} AND is_deleted = 0")
    BannerPO findOne(@Param("id") String id);

    @Update("<script>" +
            "UPDATE t_banner " +
            "<set>" +
            "<if test='po.type != null'>type = #{po.type}, </if>" +
            "<if test='po.url != null'>url = #{po.url}, </if>" +
            "<if test='po.description != null'>description = #{po.description}, </if>" +
            "<if test='po.sort != null'>sort = #{po.sort}</if>" +
            "</set> " +
            "WHERE id=#{po.id}" +
            "</script>")
    Integer update(@Param("po") BannerPO bannerPO);

    @Select("<script>" +
            "SELECT id, create_time, update_time, type, url, description, sort FROM banner WHERE is_deleted = 0 " +
            "<if test='param.type != null'> and type = #{param.type}</if>" +
            "<if test=' page != null and page.sortingConditions != null and !page.sortingConditions.isEmpty()'> " +
            "order by " +
            "<foreach item='item' index='index' collection='page.sortingConditions' separator=','> ${item.fieldName} ${item.sortingMethod}</foreach>" +
            "</if>" +
            "</script>")
    List<BannerPO> findAll(@Param("param") BannerQueryParam queryParam, @Param("page") Pagination pagination);
}
