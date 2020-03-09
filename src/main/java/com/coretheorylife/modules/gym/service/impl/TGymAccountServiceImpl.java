package com.coretheorylife.modules.gym.service.impl;

import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.gym.dao.TGymAccountMapper;
import com.coretheorylife.modules.gym.dao.ext.ExtTGymAccountMapper;
import com.coretheorylife.modules.gym.entity.*;
import com.coretheorylife.modules.gym.entity.ext.ExtTGymAccount;
import com.coretheorylife.modules.gym.entity.ext.ExtTGymAccountLog;
import com.coretheorylife.modules.gym.service.TGymAccountLogService;
import com.coretheorylife.modules.gym.service.TGymAccountService;
import com.coretheorylife.modules.gym.service.TGymBankService;
import com.coretheorylife.modules.gym.service.TGymService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tGymAccountService")
public class TGymAccountServiceImpl extends BaseServiceImpl<TGymAccount, TGymAccountExample> implements TGymAccountService {

    @Autowired
    private TGymAccountMapper tGymAccountMapper;
    @Autowired
    private ExtTGymAccountMapper extTGymAccountMapper;
    @Autowired
    private TGymService tGymService;
    @Autowired
    private TGymAccountLogService tGymAccountLogService;
    @Autowired
    private TGymBankService tGymBankService;

    @Override
    public List<ExtTGymAccount> queryList(Map<String, Object> keys) {
        return extTGymAccountMapper.queryList(keys);
    }

    @Override
    public List<ExtTGymAccount> queryList() {
        return extTGymAccountMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTGymAccountMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTGymAccountMapper.queryTotal();
    }

    @Override
    public TGymAccount initAccount(Long GymId) {
        TGymAccountExample example = new TGymAccountExample();
        TGymAccountExample.Criteria criteria = example.createCriteria();
        criteria.andGymIdEqualTo(GymId);
        criteria.andDeleteFlagEqualTo(false);
        List<TGymAccount> list = tGymAccountMapper.selectByExample(example);
        if (list.isEmpty()) {
            // 重新生成账户
            TGymAccount tGymAccount = new TGymAccount();
            tGymAccount.setGymId(GymId);
            tGymAccount.setCreateTime(new Date());
            tGymAccount.setUpdateTime(new Date());
            extTGymAccountMapper.insertSelective(tGymAccount);
            // 因为要查询基本的默认值，所以还是重新查一遍最合适
            return queryObject(tGymAccount.getId());
        } else {
            return list.get(0);
        }
    }

    @Override
    public int withDraw(BigDecimal money, Long cardId, Long GymId, String accountPassword) {
        TGymBank tGymBank = tGymBankService.queryObject(cardId);
        if (tGymBank == null || !GymId.equals(tGymBank.getGymId())) {
            throw new InvalidParameterException("银行卡不存在或不是你的卡");
        }
        TGymAccount tGymAccount = initAccount(GymId);
        if (tGymAccount.getAmount().compareTo(money) == -1) {
            throw new InvalidParameterException("可提现金额不足");
        }
        TGym tGym = tGymService.queryObject(GymId);
        if (!tGym.getAccountPassword().equals(new Sha256Hash(accountPassword, tGym.getAccountSort()).toHex())) {
            throw new InvalidParameterException("提现密码错误");
        }
        TGymAccountLog tGymAccountLog = new TGymAccountLog();
        tGymAccountLog.setAmount(tGymAccount.getAmount());
        tGymAccount.setAmount(tGymAccount.getAmount().subtract(money));
        update(tGymAccount);
        tGymAccountLog.setAmountAfter(tGymAccount.getAmount());
        tGymAccountLog.setBankId(cardId);
        tGymAccountLog.setGymId(GymId);
        tGymAccountLog.setNotSettleAmount(tGymAccount.getNotSettleAmount());
        tGymAccountLog.setNotSettleAmountAfter(tGymAccount.getNotSettleAmount());
        tGymAccountLog.setType(ExtTGymAccountLog.TYPE_WITHDRAW);
        return tGymAccountLogService.save(tGymAccountLog);
    }

    @Override
    public int save(TGymAccount t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tGymAccountMapper.insertSelective(t);
    }

    @Override
    public int update(TGymAccount t) {
        t.setUpdateTime(new Date());
        return tGymAccountMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TGymAccount tGymAccount = queryObject(id);
        if (tGymAccount == null) {
            return 0;
        }
        tGymAccount.setUpdateTime(new Date());
        tGymAccount.setDeleteFlag(true);
        return update(tGymAccount);
    }

    @Override
    public TGymAccount queryObject(Long id) {
        return tGymAccountMapper.selectByPrimaryKey(id);
    }
}
