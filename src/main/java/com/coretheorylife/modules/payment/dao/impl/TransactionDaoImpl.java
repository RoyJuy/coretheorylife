package com.coretheorylife.modules.payment.dao.impl;

import com.coretheorylife.modules.payment.dao.TransactionDao;
import com.coretheorylife.modules.payment.dao.TransactionMapper;
import com.coretheorylife.modules.payment.dao.po.TransactionPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * Transaction数据访问实现
 *
 * @author zhuhaitao
 * @since 2020/03/09
 */
@Repository
public class TransactionDaoImpl implements TransactionDao {

    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public TransactionPO create(TransactionPO transactionPO) {
        Integer count = transactionMapper.create(transactionPO);
        return (count != null && count == 1) ? transactionPO : null;
    }

    @Override
    public Integer delete(String id) {
        return transactionMapper.delete(id);
    }

    @Override
    public TransactionPO findOne(String id) {
        return transactionMapper.findOne(id);
    }

    @Override
    public TransactionPO update(TransactionPO transactionPO) {
        Integer count = transactionMapper.update(transactionPO);
        return (count != null && count == 1) ? transactionPO : null;
    }


}
