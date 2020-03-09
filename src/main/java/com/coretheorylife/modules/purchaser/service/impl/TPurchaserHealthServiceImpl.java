package com.coretheorylife.modules.purchaser.service.impl;

import com.coretheorylife.common.annotation.ZookeeperLock;
import com.coretheorylife.common.utils.DateUtils;
import com.coretheorylife.common.algorithm.NutritionUtils;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.purchaser.dao.TPurchaserHealthMapper;
import com.coretheorylife.modules.purchaser.dao.ext.ExtTPurchaserHealthMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaser;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealth;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthExam;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaser;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserHealth;
import com.coretheorylife.modules.purchaser.service.TPurchaserHealthExamService;
import com.coretheorylife.modules.purchaser.service.TPurchaserHealthService;
import com.coretheorylife.modules.purchaser.service.TPurchaserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tPurchaserHealthService")
public class TPurchaserHealthServiceImpl extends BaseServiceImpl<TPurchaserHealth, TPurchaserHealthExample> implements TPurchaserHealthService {

    public static final String LOCK_PATH = "purchaser_health_save";

    @Autowired
    private TPurchaserHealthMapper tPurchaserHealthMapper;

    @Autowired
    private ExtTPurchaserHealthMapper extTPurchaserHealthMapper;

    @Autowired
    private TPurchaserService tPurchaserService;

    @Autowired
    private NutritionUtils nutritionUtils;

    @Autowired
    private TPurchaserHealthExamService tPurchaserHealthExamService;

    @Override
    public int save(TPurchaserHealth t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tPurchaserHealthMapper.insertSelective(t);
    }

    @Override
    public int update(TPurchaserHealth t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getPurchaserId());
        return tPurchaserHealthMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TPurchaserHealth t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TPurchaserHealth queryObject(Long id) {
        return tPurchaserHealthMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ExtTPurchaserHealth> queryList(Map<String, Object> keys) {
        return extTPurchaserHealthMapper.queryList(keys);
    }

    @Override
    public List<ExtTPurchaserHealth> queryList() {
        return extTPurchaserHealthMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTPurchaserHealthMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTPurchaserHealthMapper.queryTotal();
    }

    @Override
    public TPurchaserHealth queryObjectByPurchaserId(Long purchaserId) {
        TPurchaserHealthExample example = new TPurchaserHealthExample();
        TPurchaserHealthExample.Criteria criteria = example.createCriteria();
        criteria.andPurchaserIdEqualTo(purchaserId);
        criteria.andDeleteFlagEqualTo(false);
        List<TPurchaserHealth> list = tPurchaserHealthMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    @ZookeeperLock(lockPathPrefix = LOCK_PATH, fieldName = "purchaserId")
    public TPurchaserHealth save(ExtTPurchaserHealth t) {
        if (t.getExercise() == null) {
            t.setExercise(ExtTPurchaserHealth.EXERCISE_DAILY);
        }
        if (t.getTarget() == null) {
            t.setStatus(ExtTPurchaserHealth.STATUS_SYS);
            t.setDreamWeight(t.getWeight());
            t.setTarget(NutritionUtils.SPORT_TYPE_KEEP);
        }
        TPurchaserHealthExam tPurchaserHealthExam = tPurchaserHealthExamService.queryObjectByPurchaserId(t.getPurchaserId());
        if (tPurchaserHealthExam == null) {
            t.setExamer(false);
        } else {
            t.setExamer(true);
        }
        TPurchaserHealth tPurchaserHealth = queryObjectByPurchaserId(t.getPurchaserId());
        if (tPurchaserHealth != null) {
            delete(tPurchaserHealth.getId());
        }
        TPurchaser tPurchaser = tPurchaserService.queryObject(t.getPurchaserId());
        tPurchaser.setBirthday(t.getBirthday());
        tPurchaser.setSex(t.getSex());
        tPurchaserService.update(tPurchaser);
        // 用户没有填写基础代谢
        //计算基础代谢
        BigDecimal basalMetabolism = nutritionUtils.getREE(DateUtils.getAge(tPurchaser.getBirthday()), t.getWeight(), t.getSex() == 1, t.getPurchaserId());
        t.setBasalMetabolism(basalMetabolism);
        // 计算标准体重
        t.setStandardWeight(NutritionUtils.getDreamWeight(t.getHeight()));
        // 计算行为代谢
        switch (t.getExercise()) {
            case ExtTPurchaserHealth.EXERCISE_NOT_SPORT:
                t.setSportMetabolism(new BigDecimal("0.3"));
                break;
            case ExtTPurchaserHealth.EXERCISE_DAILY:
                t.setSportMetabolism(new BigDecimal("0.4"));
                break;
            case ExtTPurchaserHealth.EXERCISE_1_2:
                t.setSportMetabolism(new BigDecimal("0.44"));
                break;
            case ExtTPurchaserHealth.EXERCISE_3_4:
                t.setSportMetabolism(new BigDecimal("0.5"));
                break;
            case ExtTPurchaserHealth.EXERCISE_5_7:
                t.setSportMetabolism(new BigDecimal("0.65"));
                break;
        }
        // 体脂有可能是空的
        //设置需要的蛋白质
        t.setProteinNeed(NutritionUtils.getProtein(t.getWeight(), t.getTarget()));

        //设置需要的碳水
        t.setCarbohydrateNeed(NutritionUtils.getCarbohydrate(t.getWeight(), t.getTarget() == null ? NutritionUtils.SPORT_TYPE_KEEP : t.getTarget()));

        //设置需要的脂肪
        BigDecimal baseNeedKcal = nutritionUtils.getBaseNeedKcal(t.getSportMetabolism(), t.getWeight(), t.getSex() == 1, DateUtils.getAge(tPurchaser.getBirthday()));
        BigDecimal fatNeed = baseNeedKcal.subtract(t.getProteinNeed().add(t.getCarbohydrateNeed()).multiply(new BigDecimal("4")));
        t.setFatNeed(fatNeed.divide(new BigDecimal(9), 2, BigDecimal.ROUND_HALF_UP));
        if (t.getFatNeed().compareTo(BigDecimal.ZERO) == -1 || t.getTarget() == NutritionUtils.SPORT_TYPE_LOSS_FAT) {
            t.setFatNeed(BigDecimal.ZERO);
        }
        t.setKclNeed(NutritionUtils.getKcl(t.getProteinNeed(), t.getFatNeed(), t.getCarbohydrateNeed()));
        save((TPurchaserHealth) t);
        return queryObjectByPurchaserId(t.getPurchaserId());
    }

    @Override
    public TPurchaserHealth updateAfterSave(TPurchaserHealth t) {
        TPurchaserHealth tPurchaserHealth = queryObjectByPurchaserId(t.getPurchaserId());
        TPurchaser tPurchaser = tPurchaserService.queryObject(t.getPurchaserId());
        if (t.getWeight() != null) {
            tPurchaserHealth.setWeight(t.getWeight());
        }
        if (t.getHeight() != null) {
            tPurchaserHealth.setHeight(t.getHeight());
        }
        if (t.getDreamWeight() != null) {
            tPurchaserHealth.setDreamWeight(t.getDreamWeight());
        }
        if (t.getDreamDate() != null) {
            tPurchaserHealth.setDreamDate(t.getDreamDate());
        }
        tPurchaserHealth.setTarget(t.getTarget());
        tPurchaserHealth.setExercise(t.getExercise());
        if (! tPurchaserHealth.getExamer()) {
            // 体测用户
            // 计算行为代谢
            switch (tPurchaserHealth.getExercise()) {
                case ExtTPurchaserHealth.EXERCISE_NOT_SPORT:
                    tPurchaserHealth.setSportMetabolism(new BigDecimal("0.3"));
                    break;
                case ExtTPurchaserHealth.EXERCISE_DAILY:
                    tPurchaserHealth.setSportMetabolism(new BigDecimal("0.4"));
                    break;
                case ExtTPurchaserHealth.EXERCISE_1_2:
                    tPurchaserHealth.setSportMetabolism(new BigDecimal("0.44"));
                    break;
                case ExtTPurchaserHealth.EXERCISE_3_4:
                    tPurchaserHealth.setSportMetabolism(new BigDecimal("0.5"));
                    break;
                case ExtTPurchaserHealth.EXERCISE_5_7:
                    tPurchaserHealth.setSportMetabolism(new BigDecimal("0.65"));
                    break;
            }
            // 体脂有可能是空的
            //设置需要的蛋白质
            tPurchaserHealth.setProteinNeed(NutritionUtils.getProtein(tPurchaserHealth.getWeight(), tPurchaserHealth.getTarget()));

            //设置需要的碳水
            tPurchaserHealth.setCarbohydrateNeed(NutritionUtils.getCarbohydrate(tPurchaserHealth.getWeight(), tPurchaserHealth.getTarget() == null ? NutritionUtils.SPORT_TYPE_KEEP : tPurchaserHealth.getTarget()));

            //设置需要的脂肪
            BigDecimal baseNeedKcal = nutritionUtils.getBaseNeedKcal(tPurchaserHealth.getSportMetabolism(), tPurchaserHealth.getWeight(), tPurchaser.getSex() == 1, DateUtils.getAge(tPurchaser.getBirthday()));
            BigDecimal fatNeed = baseNeedKcal.subtract(tPurchaserHealth.getProteinNeed().add(tPurchaserHealth.getCarbohydrateNeed()).multiply(new BigDecimal("4")));
            tPurchaserHealth.setFatNeed(fatNeed.divide(new BigDecimal(9), 2, BigDecimal.ROUND_HALF_UP));
            if (tPurchaserHealth.getFatNeed().compareTo(BigDecimal.ZERO) == -1 || tPurchaserHealth.getTarget() == NutritionUtils.SPORT_TYPE_LOSS_FAT) {
                tPurchaserHealth.setFatNeed(BigDecimal.ZERO);
            }
            update(tPurchaserHealth);
            BigDecimal basalMetabolism = nutritionUtils.getREE(DateUtils.getAge(tPurchaser.getBirthday()), tPurchaserHealth.getWeight(), tPurchaser.getSex() == 1, t.getPurchaserId());
            tPurchaserHealth.setBasalMetabolism(basalMetabolism);
            // 计算标准体重
            tPurchaserHealth.setStandardWeight(NutritionUtils.getDreamWeight(tPurchaserHealth.getHeight()));
        }
        tPurchaserHealth.setKclNeed(NutritionUtils.getKcl(tPurchaserHealth.getProteinNeed(), tPurchaserHealth.getFatNeed(), tPurchaserHealth.getCarbohydrateNeed()));
        return tPurchaserHealth;
    }

}
