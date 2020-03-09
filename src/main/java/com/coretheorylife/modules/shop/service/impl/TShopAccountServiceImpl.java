package com.coretheorylife.modules.shop.service.impl;

import com.coretheorylife.common.annotation.ZookeeperLock;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.shop.dao.TShopAccountMapper;
import com.coretheorylife.modules.shop.dao.ext.ExtTShopAccountMapper;
import com.coretheorylife.modules.shop.entity.*;
import com.coretheorylife.modules.shop.entity.ext.ExtTShopAccount;
import com.coretheorylife.modules.shop.entity.ext.ExtTShopAccountLog;
import com.coretheorylife.modules.shop.service.TShopAccountLogService;
import com.coretheorylife.modules.shop.service.TShopAccountService;
import com.coretheorylife.modules.shop.service.TShopBankService;
import com.coretheorylife.modules.shop.service.TShopService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tShopAccountService")
public class TShopAccountServiceImpl extends BaseServiceImpl<TShopAccount, TShopAccountExample> implements TShopAccountService {

    private static final String LOCK_PREFIX = "shop_account_withDraw";

    private static final String INIT_LOCK_PREFIX = "shop_account_init";

    @Autowired
    private TShopAccountMapper tShopAccountMapper;

    @Autowired
    private ExtTShopAccountMapper extTShopAccountMapper;

    @Autowired
    private TShopAccountLogService tShopAccountLogService;

    @Autowired
    private TShopBankService tShopBankService;

    @Autowired
    private TShopService tShopService;

    @Override
    public List<ExtTShopAccount> queryList(Map<String, Object> keys) {
        return extTShopAccountMapper.queryList(keys);
    }

    @Override
    public List<ExtTShopAccount> queryList() {
        return extTShopAccountMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTShopAccountMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTShopAccountMapper.queryTotal();
    }

    @Override
    @ZookeeperLock(lockPathPrefix = INIT_LOCK_PREFIX)
    public TShopAccount initAccount(Long shopId) {
        TShopAccountExample example = new TShopAccountExample();
        TShopAccountExample.Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(shopId);
        criteria.andDeleteFlagEqualTo(false);
        List<TShopAccount> list = tShopAccountMapper.selectByExample(example);
        if (list.isEmpty()) {
            // 重新生成账户
            TShopAccount tShopAccount = new TShopAccount();
            tShopAccount.setShopId(shopId);
            tShopAccount.setCreateTime(new Date());
            tShopAccount.setUpdateTime(new Date());
            extTShopAccountMapper.insertSelective(tShopAccount);
            // 因为要查询基本的默认值，所以还是重新查一遍最合适
            return queryObject(tShopAccount.getId());
        } else {
            return list.get(0);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    @ZookeeperLock(lockPathPrefix = LOCK_PREFIX, suffixIndex = 2)
    public int withDraw(BigDecimal money, Long cardId, Long shopId, String accountPassword) {
        TShopBank tShopBank = tShopBankService.queryObject(cardId);
        if (tShopBank == null || !shopId.equals(tShopBank.getShopId())) {
            throw new InvalidParameterException("银行卡不存在或不是你的卡");
        }
        TShopAccount tShopAccount = initAccount(shopId);
        if (tShopAccount.getAmount().compareTo(money) == -1) {
            throw new InvalidParameterException("可提现金额不足");
        }
        TShop tShop = tShopService.queryObject(shopId);
        if (!tShop.getAccountPassword().equals(new Sha256Hash(accountPassword, tShop.getAccountSort()).toHex())) {
            throw new InvalidParameterException("提现密码错误");
        }
        TShopAccountLog tShopAccountLog = new TShopAccountLog();
        tShopAccountLog.setAmount(tShopAccount.getAmount());
        tShopAccount.setAmount(tShopAccount.getAmount().subtract(money));
        update(tShopAccount);
        tShopAccountLog.setAmountAfter(tShopAccount.getAmount());
        tShopAccountLog.setBankId(cardId);
        tShopAccountLog.setShopId(shopId);
        tShopAccountLog.setNotSettleAmount(tShopAccount.getNotSettleAmount());
        tShopAccountLog.setNotSettleAmountAfter(tShopAccount.getNotSettleAmount());
        tShopAccountLog.setType(ExtTShopAccountLog.TYPE_WITHDRAW);
        return tShopAccountLogService.save(tShopAccountLog);
    }

    @Override
    public int save(TShopAccount t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tShopAccountMapper.insertSelective(t);
    }

    @Override
    public int update(TShopAccount t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getShopId());
        return tShopAccountMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TShopAccount tShopAccount = queryObject(id);
        if (tShopAccount == null) {
            return 0;
        }
        tShopAccount.setUpdateTime(new Date());
        tShopAccount.setDeleteFlag(true);
        return update(tShopAccount);
    }

    @Override
    public TShopAccount queryObject(Long id) {
        return tShopAccountMapper.selectByPrimaryKey(id);
    }
}
