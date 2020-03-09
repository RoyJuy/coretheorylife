package com.coretheorylife.modules.purchaser.service.impl;

import com.coretheorylife.common.annotation.ZookeeperLock;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.exception.ResourceNotExistsException;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.gym.entity.TGymCoach;
import com.coretheorylife.modules.gym.service.TGymCoachService;
import com.coretheorylife.modules.purchaser.dao.TPurchaserCoachGymMapper;
import com.coretheorylife.modules.purchaser.entity.*;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaser;
import com.coretheorylife.modules.purchaser.service.TPurchaserCoachGymService;
import com.coretheorylife.modules.purchaser.service.TPurchaserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("tPurchaserCoachGymService")
public class TPurchaserCoachGymServiceImpl extends BaseServiceImpl<TPurchaserCoachGym, TPurchaserCoachGymExample> implements TPurchaserCoachGymService {

    public static final String LOCK_PREFIX = "purchaser_coach_save";

    @Autowired
    private TPurchaserCoachGymMapper tPurchaserCoachGymMapper;

    @Autowired
    private TGymCoachService tGymCoachService;

    @Autowired
    private TPurchaserService tPurchaserService;

    @ZookeeperLock(lockPathPrefix = LOCK_PREFIX)
    @Override
    public int bind(Long purchaserId, Long coachId) {
        if (purchaserId.equals(coachId)) {
            throw new InvalidParameterException("不可以自己绑定自己哦");
        }
        TPurchaser tPurchaser = tPurchaserService.queryObject(purchaserId);
        if (tPurchaser.getProperty() == ExtTPurchaser.PROPERTY_COACH) {
            throw new InvalidParameterException("你已经是教练啦");
        }
        tPurchaser = tPurchaserService.queryObject(coachId);
        if (tPurchaser == null) {
            throw new ResourceNotExistsException("教练不存在");
        }
        if (tPurchaser.getProperty() != ExtTPurchaser.PROPERTY_COACH) {
            throw new InvalidParameterException("当前绑定用户不是教练");
        }
        TPurchaserCoachGym check = selectByPurchaserId(purchaserId);
        if (check != null) {
            if (check.getCoachId() != null) {
                throw new InvalidParameterException("该用户已经绑定教练，如需更改，请先解绑");
            } else {
                check.setCoachId(coachId);
                return update(check);
            }
        } else {
            TGymCoach tGymCoach = tGymCoachService.selectByCoachId(coachId);
            TPurchaserCoachGym t = new TPurchaserCoachGym();
            if (tGymCoach != null) {
                t.setGymId(tGymCoach.getGymId());
            }
            t.setCoachId(coachId);
            t.setPurchaserId(purchaserId);
            return save(t);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int unbind(Long purchaserId) {
        TPurchaserCoachGym check = selectByPurchaserId(purchaserId);
        if (check == null || check.getCoachId() == null) {
            throw new InvalidParameterException("该用户没有绑定教练");
        }
        Long id = check.getId();
        if (check.getGymId() != null) {
            // 如果用户绑定了健身房 那么保留和健身房的绑定
            check.setId(null);
            check.setCoachId(null);
            save(check);
        }
        return delete(id);
    }

    @Override
    public TPurchaserCoachGym selectByPurchaserId(Long purchaserId) {
        TPurchaserCoachGymExample example = new TPurchaserCoachGymExample();
        TPurchaserCoachGymExample.Criteria criteria = example.createCriteria();
        criteria.andPurchaserIdEqualTo(purchaserId);
        criteria.andDeleteFlagEqualTo(false);
        List<TPurchaserCoachGym> list = tPurchaserCoachGymMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public int save(TPurchaserCoachGym t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tPurchaserCoachGymMapper.insertSelective(t);
    }

    @Override
    public int update(TPurchaserCoachGym t) {
        t.setUpdateTime(new Date());
        return tPurchaserCoachGymMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TPurchaserCoachGym t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TPurchaserCoachGym queryObject(Long id) {
        return tPurchaserCoachGymMapper.selectByPrimaryKey(id);
    }
}
