package com.coretheorylife.modules.shop.service.impl;

import com.coretheorylife.common.annotation.ZookeeperLock;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.shop.dao.TGoodsLogMapper;
import com.coretheorylife.modules.shop.entity.TGoodsLog;
import com.coretheorylife.modules.shop.entity.TGoodsLogExample;
import com.coretheorylife.modules.shop.service.TGoodsLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service("tGoodsLogService")
public class TGoodsLogServiceImpl extends BaseServiceImpl<TGoodsLog, TGoodsLogExample> implements TGoodsLogService {

    @Autowired
    private TGoodsLogMapper tGoodsLogMapper;

    @Override
    public int save(TGoodsLog t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tGoodsLogMapper.insertSelective(t);
    }

    @Override
    public int update(TGoodsLog t) {
        t.setUpdateTime(new Date());
        return tGoodsLogMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TGoodsLog t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TGoodsLog queryObject(Long id) {
        return tGoodsLogMapper.selectByPrimaryKey(id);
    }

    @ZookeeperLock(lockPathPrefix = TOrderServiceImpl.LOCK_PREFIX, suffixIndex = 2)
    @Override
    public void resetStock(Long goodsId, int number, Long shopId) {
        TGoodsLog tGoodsLog = new TGoodsLog();
        tGoodsLog.setGoodsId(goodsId);
        tGoodsLog.setNumber(number);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        Date date = calendar.getTime();
        DateFormat format = new SimpleDateFormat("yyyy-MM");
        String str = format.format(date);
        tGoodsLog.setLogTime(str);
        save(tGoodsLog);
    }
}
