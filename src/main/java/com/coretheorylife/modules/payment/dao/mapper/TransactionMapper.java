package com.coretheorylife.modules.payment.dao.mapper;

import com.coretheorylife.modules.payment.dao.po.TransactionPO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Transaction的MyBatis数据访问mapper
 *
 * @author zhuhaitao
 * @since 2020/03/09
 */
@Mapper
public interface TransactionMapper {

    @Insert("INSERT INTO t_transaction (id, order_id, transaction_number, client_id, transaction_status, amount, create_time, update_time, is_deleted) VALUES (#{po.id}, #{po.order_id}, #{po.transaction_number}, #{po.client_id}, #{po.transaction_status}, #{po.amount}, #{po.create_time}, #{po.update_time}, #{po.is_deleted})")
    Integer create(@Param("po") TransactionPO transactionPO);

    @Update("UPDATE transaction set is_deleted = 1 WHERE id=#{id}")
    Integer delete(@Param("id") String id);

    @Select("SELECT id, create_time, update_time, id, transaction_number, client_id, transaction_status, amount, create_time, update_time, is_deleted FROM transaction WHERE id=#{id} AND is_deleted = 0")
    TransactionPO findOne(@Param("id") String id);

    @Update("<script>" +
            "UPDATE transaction " +
            "<set>" +
            "<if test='po.id != null'>id = #{po.id}, </if>" +
            "<if test='po.transaction_number != null'>transaction_number = #{po.transaction_number}, </if>" +
            "<if test='po.client_id != null'>client_id = #{po.client_id}, </if>" +
            "<if test='po.transaction_status != null'>transaction_status = #{po.transaction_status}, </if>" +
            "<if test='po.amount != null'>amount = #{po.amount}, </if>" +
            "<if test='po.create_time != null'>create_time = #{po.create_time}, </if>" +
            "<if test='po.update_time != null'>update_time = #{po.update_time}, </if>" +
            "<if test='po.is_deleted != null'>is_deleted = #{po.is_deleted}</if>" +
            "</set> " +
            "WHERE id=#{po.id}" +
            "</script>")
    Integer update(@Param("po") TransactionPO transactionPO);

}
