package com.coretheorylife.modules.payment.dao;

import com.coretheorylife.modules.payment.dao.po.TransactionPO;

/**
 * Transaction数据访问接口
 *
 * @author zhuhaitao
 * @since 2020/03/09
 */
public interface TransactionDao {

    TransactionPO create(TransactionPO transactionPO);

    Integer delete(String id);

    TransactionPO findOne(String id);

    TransactionPO update(TransactionPO transactionPO);

}
