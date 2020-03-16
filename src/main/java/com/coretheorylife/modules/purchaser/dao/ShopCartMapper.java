package com.coretheorylife.modules.purchaser.dao;

import com.coretheorylife.modules.purchaser.common.GoodsInfo;
import com.coretheorylife.modules.purchaser.common.ShopCartInfo;
import com.coretheorylife.modules.purchaser.common.ShopInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ShopCartMapper
 *
 * @author zhuhaitao
 * @since 2020-03-16
 */
@Mapper
public interface ShopCartMapper {

    @Select("<script>" +
            "select * from t_shop where delete_flag = false and id in " +
            "<foreach item='item' index='index' collection='ids' separator=',' open='(' close=')'>#{item}</foreach>" +
            "</script>")
    List<ShopInfo> findShopByIds(@Param(value = "ids")List<Long> ids);

    @Select("<script>" +
            "select * from t_goods where delete_flag = false and id in " +
            "<foreach item='item' index='index' collection='ids' separator=',' open='(' close=')'>#{item}</foreach>" +
            "</script>")
    List<GoodsInfo> findGoodsByIds(@Param(value = "ids") List<Long> ids);

    @Select("<script>" +
            "select * from t_purchaser_shop_cart where purchaser_id = #{purchaseId}" +
            "</script>")
    List<ShopCartInfo> findShopCartByPurchaseId(@Param(value = "purchaseId") long purchaseId);
}
