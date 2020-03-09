package com.coretheorylife.modules.purchaser.service.impl;

import com.coretheorylife.common.annotation.ZookeeperLock;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.gym.entity.TGymCoach;
import com.coretheorylife.modules.gym.service.TGymCoachService;
import com.coretheorylife.modules.purchaser.dao.TPurchaserAccountMapper;
import com.coretheorylife.modules.purchaser.dao.ext.ExtTPurchaserAccountMapper;
import com.coretheorylife.modules.purchaser.entity.*;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaser;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserAccountLog;
import com.coretheorylife.modules.purchaser.service.TPurchaserAccountLogService;
import com.coretheorylife.modules.purchaser.service.TPurchaserAccountService;
import com.coretheorylife.modules.purchaser.service.TPurchaserBankService;
import com.coretheorylife.modules.purchaser.service.TPurchaserService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service("tPurchaserAccountService")
public class TPurchaserAccountServiceImpl extends BaseServiceImpl<TPurchaserAccount, TPurchaserAccountExample> implements TPurchaserAccountService {

    private static final String LOCK_PREFIX = "purchaser_account_withDraw";

    private static final String INIT_LOCK_PREFIX = "purchaser_account_init";

    @Autowired
    private TPurchaserAccountMapper tPurchaserAccountMapper;

    @Autowired
    private ExtTPurchaserAccountMapper extTPurchaserAccountMapper;

    @Autowired
    private TPurchaserBankService tPurchaserBankService;

    @Autowired
    private TPurchaserService tPurchaserService;

    @Autowired
    private TPurchaserAccountLogService tPurchaserAccountLogService;

    @Autowired
    private TGymCoachService tGymCoachService;
    @Override
    @ZookeeperLock(lockPathPrefix = INIT_LOCK_PREFIX)
    public TPurchaserAccount initAccount(Long purchaserId) {
        TPurchaserAccountExample example = new TPurchaserAccountExample();
        TPurchaserAccountExample.Criteria criteria = example.createCriteria();
        criteria.andPurchaserIdEqualTo(purchaserId);
        criteria.andDeleteFlagEqualTo(false);
        List<TPurchaserAccount> list = tPurchaserAccountMapper.selectByExample(example);
        if (list.isEmpty()) {
            // 重新生成账户
            TPurchaserAccount tPurchaserAccount = new TPurchaserAccount();
            tPurchaserAccount.setPurchaserId(purchaserId);
            tPurchaserAccount.setCreateTime(new Date());
            tPurchaserAccount.setUpdateTime(new Date());
            extTPurchaserAccountMapper.insertSelective(tPurchaserAccount);
            // 因为要查询基本的默认值，所以还是重新查一遍最合适
            return queryObject(tPurchaserAccount.getId());
        } else {
            return list.get(0);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    @ZookeeperLock(lockPathPrefix = LOCK_PREFIX, suffixIndex = 2)
    public int withDraw(BigDecimal money, Long cardId, Long purchaserId, String accountPassword) {
        TPurchaserBank tPurchaserBank = tPurchaserBankService.queryObject(cardId);
        if (tPurchaserBank == null || !purchaserId.equals(tPurchaserBank.getPurchaserId())) {
            throw new InvalidParameterException("银行卡不存在或不是你的卡");
        }
        TPurchaserAccount tPurchaserAccount = initAccount(purchaserId);
        if (tPurchaserAccount.getAmount().compareTo(money) == -1) {
            throw new InvalidParameterException("可提现金额不足");
        }
        TPurchaser tPurchaser = tPurchaserService.queryObject(purchaserId);
        if (!tPurchaser.getAccountPassword().equals(new Sha256Hash(accountPassword, tPurchaser.getAccountSort()).toHex())) {
            throw new InvalidParameterException("提现密码错误");
        }
        if (tPurchaser.getProperty() != ExtTPurchaser.PROPERTY_COACH) {
            throw new InvalidParameterException("你不是教练，不能执行提现操作~");
        }
        TGymCoach tGymCoach = tGymCoachService.selectByCoachId(purchaserId);
        if (tGymCoach != null) {
                throw new InvalidParameterException("只有自由教练才可以提现，如果您已是自由教练，请解绑健身房");
        }
        TPurchaserAccountLog tPurchaserAccountLog = new TPurchaserAccountLog();
        tPurchaserAccountLog.setAmount(tPurchaserAccount.getAmount());
        tPurchaserAccount.setAmount(tPurchaserAccount.getAmount().subtract(money));
        update(tPurchaserAccount);
        tPurchaserAccountLog.setAmountAfter(tPurchaserAccount.getAmount());
        tPurchaserAccountLog.setBankId(cardId);
        tPurchaserAccountLog.setPurchaserId(purchaserId);
        tPurchaserAccountLog.setNotSettleAmount(tPurchaserAccount.getNotSettleAmount());
        tPurchaserAccountLog.setNotSettleAmountAfter(tPurchaserAccount.getNotSettleAmount());
        tPurchaserAccountLog.setType(ExtTPurchaserAccountLog.TYPE_WITHDRAW);
        return tPurchaserAccountLogService.save(tPurchaserAccountLog);
    }

    @Override
    public int save(TPurchaserAccount t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tPurchaserAccountMapper.insertSelective(t);
    }

    @Override
    public int update(TPurchaserAccount t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getPurchaserId());
        return tPurchaserAccountMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TPurchaserAccount tShopAccount = queryObject(id);
        if (tShopAccount == null) {
            return 0;
        }
        tShopAccount.setUpdateTime(new Date());
        tShopAccount.setDeleteFlag(true);
        return update(tShopAccount);
    }

    @Override
    public TPurchaserAccount queryObject(Long id) {
        return tPurchaserAccountMapper.selectByPrimaryKey(id);
    }
}
