package com.coretheorylife.modules.gym.service.impl;

import com.coretheorylife.common.annotation.ZookeeperLock;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.exception.ResourceNotExistsException;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.gym.dao.TGymCoachMapper;
import com.coretheorylife.modules.gym.dao.ext.ExtTGymCoachMapper;
import com.coretheorylife.modules.gym.entity.TGym;
import com.coretheorylife.modules.gym.entity.TGymCoach;
import com.coretheorylife.modules.gym.entity.TGymCoachExample;
import com.coretheorylife.modules.gym.entity.ext.ExtTGymCoach;
import com.coretheorylife.modules.gym.service.TGymCoachService;
import com.coretheorylife.modules.gym.service.TGymService;
import com.coretheorylife.modules.purchaser.dao.CoachTagMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaser;
import com.coretheorylife.modules.purchaser.entity.TPurchaserCoachGym;
import com.coretheorylife.modules.purchaser.entity.TPurchaserCoachGymLog;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaser;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserCoachGymLog;
import com.coretheorylife.modules.purchaser.service.TPurchaserCoachGymLogService;
import com.coretheorylife.modules.purchaser.service.TPurchaserCoachGymService;
import com.coretheorylife.modules.purchaser.service.TPurchaserService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("tGymCoachService")
public class TGymCoachServiceImpl extends BaseServiceImpl<TGymCoach, TGymCoachExample> implements TGymCoachService {

    public static final String LOCK_PREFIX = "gym_coach_save";

    @Autowired
    private TGymCoachMapper tGymCoachMapper;

    @Autowired
    private TPurchaserService tPurchaserService;

    @Autowired
    private ExtTGymCoachMapper extTGymCoachMapper;

    @Autowired
    private TGymService tGymService;

    @Autowired
    private TPurchaserCoachGymService tPurchaserCoachGymService;

    @Autowired
    private TPurchaserCoachGymLogService tPurchaserCoachGymLogService;

    @Autowired
    private CoachTagMapper coachTagMapper;

    @Override
    public int save(TGymCoach t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tGymCoachMapper.insertSelective(t);
    }

    @Override
    public int update(TGymCoach t) {
        t.setUpdateTime(new Date());
        return tGymCoachMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TGymCoach t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TGymCoach queryObject(Long id) {
        return tGymCoachMapper.selectByPrimaryKey(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @ZookeeperLock(lockPathPrefix = LOCK_PREFIX, suffixIndex = 1)
    @Override
    public int bind(Long gymId, Long id) {
        TGym tGym = tGymService.queryObject(gymId);
        if (tGym == null) {
            throw new ResourceNotExistsException("找不到该健身房");
        }
        TPurchaser tPurchaser = tPurchaserService.queryObject(id);
        if (tPurchaser.getProperty() == ExtTPurchaser.PROPERTY_COACH) {
            TGymCoach check = selectByCoachId(id);
            if (check != null) {
                throw new InvalidParameterException("该教练已经绑定健身房，如需更改，请先解绑");
            }
            TGymCoach t = new TGymCoach();
            t.setGymId(gymId);
            t.setCoachId(id);
            return save(t);
        } else {
            // 记录用户绑定日志
            TPurchaserCoachGymLog tPurchaserCoachGymLog = new TPurchaserCoachGymLog();
            tPurchaserCoachGymLog.setPurchaserId(id);
            tPurchaserCoachGymLog.setGymId(gymId);
            tPurchaserCoachGymLog.setType(ExtTPurchaserCoachGymLog.TYPE_INCREASE);
            tPurchaserCoachGymLog.setQueryType(ExtTPurchaserCoachGymLog.QUERY_TYPE_INCREASE);
            tPurchaserCoachGymLogService.save(tPurchaserCoachGymLog);

            TPurchaserCoachGym tPurchaserCoachGym = new TPurchaserCoachGym();
            tPurchaserCoachGym.setPurchaserId(id);
            tPurchaserCoachGym.setGymId(gymId);
            return tPurchaserCoachGymService.save(tPurchaserCoachGym);
        }
    }

    @Override
    public int unbind(Long id) {
        TPurchaser tPurchaser = tPurchaserService.queryObject(id);
        if (tPurchaser.getProperty() == ExtTPurchaser.PROPERTY_COACH) {
            TGymCoach check = selectByCoachId(id);
            if (check == null) {
                throw new ResourceNotExistsException("该教练没有绑定健身房");
            }
            return delete(check.getId());
        } else {
            TPurchaserCoachGym tPurchaserCoachGym = tPurchaserCoachGymService.selectByPurchaserId(id);
            if (tPurchaserCoachGym != null) {
                // 记录用户流失日志
                TPurchaserCoachGymLog tPurchaserCoachGymLog = new TPurchaserCoachGymLog();
                tPurchaserCoachGymLog.setPurchaserId(id);
                tPurchaserCoachGymLog.setOldCoachId(tPurchaserCoachGym.getCoachId());
                tPurchaserCoachGymLog.setOldGymId(tPurchaserCoachGym.getGymId());
                tPurchaserCoachGymLog.setType(ExtTPurchaserCoachGymLog.TYPE_FEWER);
                tPurchaserCoachGymLog.setQueryType(ExtTPurchaserCoachGymLog.QUERY_TYPE_FEWER);
                tPurchaserCoachGymLogService.save(tPurchaserCoachGymLog);
                return tPurchaserCoachGymService.delete(tPurchaserCoachGym.getId());
            } else {
                throw new ResourceNotExistsException("该用户没有绑定健身房");
            }
        }
    }

    @Override
    public TGymCoach selectByCoachId(Long coachId) {
        TGymCoachExample example = new TGymCoachExample();
        TGymCoachExample.Criteria criteria = example.createCriteria();
        criteria.andCoachIdEqualTo(coachId);
        criteria.andDeleteFlagEqualTo(false);
        List<TGymCoach> list = tGymCoachMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<TPurchaser> selectCoachListByGymId(Long gymId) {
        return extTGymCoachMapper.selectCoachListByGymId(gymId);
    }
}
