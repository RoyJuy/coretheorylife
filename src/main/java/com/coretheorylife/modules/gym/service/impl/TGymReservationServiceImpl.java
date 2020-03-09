package com.coretheorylife.modules.gym.service.impl;

import com.coretheorylife.common.annotation.ZookeeperLock;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.gym.dao.ext.ExtTGymReservationMapper;
import com.coretheorylife.modules.gym.entity.TGymReservation;
import com.coretheorylife.modules.gym.entity.TGymReservationExample;
import com.coretheorylife.modules.gym.entity.ext.ExtTGymReservation;
import com.coretheorylife.modules.gym.service.TGymReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("tGymReservationService")
public class TGymReservationServiceImpl extends BaseServiceImpl<TGymReservation, TGymReservationExample> implements TGymReservationService {

    public static final String LOCK_PREFIX_PURCHASER = "reservation_stock_purchaser";
    public static final String LOCK_PREFIX = "reservation_stock";

    @Autowired
    private ExtTGymReservationMapper extTGymReservationMapper;

    @ZookeeperLock(lockPathPrefix = LOCK_PREFIX_PURCHASER, fieldName = "purchaserId")
    @Override
    public int reserve(TGymReservation tGymReservation) {
        return save(tGymReservation);
    }

    @Override
    public int updateReservation(TGymReservation tGymReservation) {
        TGymReservation t = queryObject(tGymReservation.getId());
        if (t.getStatus() != ExtTGymReservation.STATUS_RESERVED) {
            throw new InvalidParameterException("只有预约成功的预约单才可以更改");
        }
        return update(t);
    }

    @ZookeeperLock(lockPathPrefix = LOCK_PREFIX)
    @Override
    public int assignationCoach(Long id, Long coachId) {
        TGymReservation tGymReservation = queryObject(id);
        if (tGymReservation.getCoachId() != null) {
            throw new InvalidParameterException("当前预约单已经有教练了，如果想更换教练请使用更换教练功能");
        }
        if (tGymReservation.getStatus() != ExtTGymReservation.STATUS_RESERVED) {
            throw new InvalidParameterException("当前状态不能指派教练");
        }
        tGymReservation.setCoachId(coachId);
        return update(tGymReservation);
    }

    @ZookeeperLock(lockPathPrefix = LOCK_PREFIX)
    @Override
    public int changeCoach(Long id, Long coachId) {
        TGymReservation tGymReservation = queryObject(id);
        if (tGymReservation.getStatus() != ExtTGymReservation.STATUS_RESERVED) {
            throw new InvalidParameterException("当前状态不能更换教练");
        }
        tGymReservation.setCoachId(coachId);
        return update(tGymReservation);
    }

    @Override
    public int signIn(Long id) {
        TGymReservation tGymReservation = queryObject(id);
        if (tGymReservation.getStatus() != ExtTGymReservation.STATUS_RESERVED) {
            throw new InvalidParameterException("当前状态不能签到");
        }
        return changeStatus(id, ExtTGymReservation.STATUS_SIGN_IN);
    }

    @Override
    public int expired(Long id) {
        return changeStatus(id, ExtTGymReservation.STATUS_EXPIRED);
    }

    @Override
    public int purchaserCancel(Long id, String remark) {
        TGymReservation tGymReservation = queryObject(id);
        if (tGymReservation.getStatus() != ExtTGymReservation.STATUS_RESERVED) {
            throw new InvalidParameterException("当前状态不能取消");
        }
        tGymReservation.setStatus(ExtTGymReservation.STATUS_PURCHASER_CANCEL);
        tGymReservation.setCancelRemark(remark);
        return update(tGymReservation);
    }

    @Override
    public int gymCancel(Long id, String remark) {
        TGymReservation tGymReservation = queryObject(id);
        if (tGymReservation.getStatus() != ExtTGymReservation.STATUS_RESERVED) {
            throw new InvalidParameterException("当前状态不能取消");
        }
        tGymReservation.setStatus(ExtTGymReservation.STATUS_GYM_CANCEL);
        tGymReservation.setCancelRemark(remark);
        return update(tGymReservation);
    }

    @Override
    public int changeStatus(Long id, int status) {
        TGymReservation tGymReservation = queryObject(id);
        tGymReservation.setStatus(status);
        return update(tGymReservation);
    }

    @Override
    public List<ExtTGymReservation> queryList(Map<String, Object> queryMap) {
        return extTGymReservationMapper.queryList(queryMap);
    }

    @Override
    public int queryTotal(Map<String, Object> queryMap) {
        return extTGymReservationMapper.queryTotal(queryMap);
    }
}
