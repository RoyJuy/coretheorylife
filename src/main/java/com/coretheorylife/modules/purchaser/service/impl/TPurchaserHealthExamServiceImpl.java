package com.coretheorylife.modules.purchaser.service.impl;

import com.coretheorylife.common.annotation.ZookeeperLock;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.purchaser.dao.TPurchaserHealthExamMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealth;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthExam;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthExamExample;
import com.coretheorylife.modules.purchaser.service.TPurchaserHealthExamService;
import com.coretheorylife.modules.purchaser.service.TPurchaserHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service("tPurchaserHealthExamService")
public class TPurchaserHealthExamServiceImpl extends BaseServiceImpl<TPurchaserHealthExam, TPurchaserHealthExamExample> implements TPurchaserHealthExamService {

    public static final String LOCK_PATH = "purchaser_health_exam_save";

    @Autowired
    private TPurchaserHealthExamMapper tPurchaserHealthExamMapper;

    @Autowired
    private TPurchaserHealthService tPurchaserHealthService;

    @Transactional(rollbackFor = Exception.class)
    @ZookeeperLock(lockPathPrefix = LOCK_PATH, fieldName = "purchaserId")
    @Override
    public int save(TPurchaserHealthExam t) {
        TPurchaserHealth tPurchaserHealth = tPurchaserHealthService.queryObjectByPurchaserId(t.getPurchaserId());
        if (tPurchaserHealth == null) {
            throw new InvalidParameterException("当前用户还未完善基本信息，请先填写基本信息");
        }

        tPurchaserHealth.setExamer(true);
        tPurchaserHealth.setBasalMetabolism(t.getBasalMetabolism());
        tPurchaserHealthService.update(tPurchaserHealth);

        TPurchaserHealthExam tPurchaserHealthExam = queryObjectByPurchaserId(t.getPurchaserId());
        if (tPurchaserHealthExam != null) {
            delete(tPurchaserHealthExam.getId());
        }

        // 计算卡路里以及 百分比占比 计算BMI
        t.setMuscleRate(t.getMuscle().divide(t.getWeight(), 3, BigDecimal.ROUND_HALF_UP));
        t.setBodyFatRate(t.getBodyFat().divide(t.getWeight(), 3, BigDecimal.ROUND_HALF_UP));
        t.setBodyWaterRate(t.getBodyWater().divide(t.getWeight(), 3, BigDecimal.ROUND_HALF_UP));
        t.setProteinRate(t.getProtein().divide(t.getWeight(), 3, BigDecimal.ROUND_HALF_UP));
        t.setVisceralFatRate(t.getVisceralFat().divide(t.getWeight(), 3, BigDecimal.ROUND_HALF_UP));
        t.setBoneMassRate(t.getBoneMass().divide(t.getWeight(), 3, BigDecimal.ROUND_HALF_UP));
        t.setBmi(t.getWeight().divide(tPurchaserHealth.getHeight().divide(new BigDecimal(100)).pow(2), 3, BigDecimal.ROUND_HALF_UP));
        // 计算卡路里
        BigDecimal kcl = BigDecimal.ZERO;
        kcl = kcl.add(t.getProteinNeed().multiply(new BigDecimal("4")));
        kcl = kcl.add(t.getCarbohydrateNeed().multiply(new BigDecimal("4")));
        kcl = kcl.add(t.getAdiposeNeed().multiply(new BigDecimal("9")));
        t.setKaclNeed(kcl);
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tPurchaserHealthExamMapper.insertSelective(t);
    }

    @Override
    public int update(TPurchaserHealthExam t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getPurchaserId());
        return tPurchaserHealthExamMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TPurchaserHealthExam t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TPurchaserHealthExam queryObject(Long id) {
        return tPurchaserHealthExamMapper.selectByPrimaryKey(id);
    }

    @Override
    public TPurchaserHealthExam queryObjectByPurchaserId(Long purchaseId) {
        TPurchaserHealthExamExample examExample = new TPurchaserHealthExamExample();
        TPurchaserHealthExamExample.Criteria criteria = examExample.createCriteria();
        criteria.andPurchaserIdEqualTo(purchaseId);
        criteria.andDeleteFlagEqualTo(false);
        List<TPurchaserHealthExam> list = tPurchaserHealthExamMapper.selectByExample(examExample);
        return list.isEmpty() ? null : list.get(0);
    }
}
