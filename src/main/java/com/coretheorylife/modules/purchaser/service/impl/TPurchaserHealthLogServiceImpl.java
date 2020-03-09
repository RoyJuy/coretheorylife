package com.coretheorylife.modules.purchaser.service.impl;

import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.utils.CollectionUtils;
import com.coretheorylife.common.utils.DateUtils;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.purchaser.copier.TPurchaserHealthLogCopier;
import com.coretheorylife.modules.purchaser.dao.TPurchaserHealthLogMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealth;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthExam;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthLog;
import com.coretheorylife.modules.purchaser.entity.TPurchaserHealthLogExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtHealthTools;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserHealth;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserHealthLog;
import com.coretheorylife.modules.purchaser.service.TPurchaserHealthExamService;
import com.coretheorylife.modules.purchaser.service.TPurchaserHealthLogService;
import com.coretheorylife.modules.purchaser.service.TPurchaserHealthService;
import com.coretheorylife.modules.shop.entity.ext.ExtTOrder;
import com.coretheorylife.modules.shop.service.TOrderService;
import org.omg.CORBA.INV_FLAG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("tPurchaserHealthLogService")
public class TPurchaserHealthLogServiceImpl extends BaseServiceImpl<TPurchaserHealthLog, TPurchaserHealthLogExample> implements TPurchaserHealthLogService {

    @Autowired
    private TPurchaserHealthLogMapper tPurchaserHealthLogMapper;

    @Autowired
    private TPurchaserHealthService tPurchaserHealthService;

    @Autowired
    private TOrderService tOrderService;

    @Autowired
    private TPurchaserHealthExamService tPurchaserHealthExamService;

    @Override
    public int save(TPurchaserHealthLog t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tPurchaserHealthLogMapper.insertSelective(t);
    }

    @Override
    public int update(TPurchaserHealthLog t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getPurchaserId());
        return tPurchaserHealthLogMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TPurchaserHealthLog t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TPurchaserHealthLog queryObject(Long id) {
        return tPurchaserHealthLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public ExtTPurchaserHealthLog queryByTime(String time, Long purchaserId, boolean hasOrder) {
        Date logTime;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if (time == null || time.equals("")) {
            try {
                logTime = format.parse(format.format(new Date()));
            } catch (ParseException e) {
                throw new InvalidParameterException("时间格式错误yyyy-MM-dd的字符串");
            }
        } else {
            try {
                logTime = format.parse(time);
            } catch (ParseException e) {
                throw new InvalidParameterException("时间格式错误yyyy-MM-dd的字符串");
            }
        }
        TPurchaserHealthLogExample example = new TPurchaserHealthLogExample();
        TPurchaserHealthLogExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteFlagEqualTo(false);
        criteria.andLogTimeEqualTo(logTime);
        criteria.andPurchaserIdEqualTo(purchaserId);
        example.setOrderByClause(" create_time DESC ");
        List<TPurchaserHealthLog> list = tPurchaserHealthLogMapper.selectByExample(example);
        if (list.isEmpty()) {
            // 生成一条就OK
            ExtTPurchaserHealthLog tPurchaserHealthLog = new ExtTPurchaserHealthLog();
            tPurchaserHealthLog.setPurchaserId(purchaserId);
            tPurchaserHealthLog.setLogTime(new Date());

            TPurchaserHealth tPurchaserHealth = tPurchaserHealthService.queryObjectByPurchaserId(purchaserId);
            if (tPurchaserHealth == null) {
                tPurchaserHealthLog.setAllProtein(BigDecimal.ZERO);
                tPurchaserHealthLog.setAllCarbohydrate(BigDecimal.ZERO);
                tPurchaserHealthLog.setAllAdipose(BigDecimal.ZERO);
                tPurchaserHealthLog.setAllKacl(BigDecimal.ZERO);
            } else {
                BigDecimal kcl = BigDecimal.ZERO;
                tPurchaserHealthLog.setAllCarbohydrate(tPurchaserHealth.getCarbohydrateNeed());
                tPurchaserHealthLog.setAllAdipose(tPurchaserHealth.getFatNeed());
                tPurchaserHealthLog.setAllProtein(tPurchaserHealth.getProteinNeed());
                kcl = kcl.add(tPurchaserHealth.getProteinNeed().multiply(new BigDecimal("4")));
                kcl = kcl.add(tPurchaserHealth.getCarbohydrateNeed().multiply(new BigDecimal("4")));
                kcl = kcl.add(tPurchaserHealth.getFatNeed().multiply(new BigDecimal("9")));
                tPurchaserHealthLog.setAllKacl(kcl);
            }
            tPurchaserHealthLog.setAllDayProtein(BigDecimal.ZERO);
            tPurchaserHealthLog.setAllDayCarbohydrate(BigDecimal.ZERO);
            tPurchaserHealthLog.setAllDayAdipose(BigDecimal.ZERO);
            tPurchaserHealthLog.setAllDayKacl(BigDecimal.ZERO);
            tPurchaserHealthLog.setProtein(BigDecimal.ZERO);
            tPurchaserHealthLog.setCarbohydrate(BigDecimal.ZERO);
            tPurchaserHealthLog.setAdipose(BigDecimal.ZERO);
            tPurchaserHealthLog.setKacl(BigDecimal.ZERO);
            tPurchaserHealthLog.setCreateTime(new Date());
            tPurchaserHealthLog.setUpdateTime(new Date());
            tPurchaserHealthLog.setCreateUser(purchaserId);
            tPurchaserHealthLog.setUpdateUser(purchaserId);
            tPurchaserHealthLog.setVersion(0);
            tPurchaserHealthLog.setDeleteFlag(false);
            if (hasOrder) {
                tPurchaserHealthLog.setOrderList(new ArrayList<>());
            }
            tPurchaserHealthLog = fillArgs(tPurchaserHealthLog);
            return tPurchaserHealthLog;
        } else {
            ExtTPurchaserHealthLog bean = TPurchaserHealthLogCopier.INSTANCE.asTPurchaserHealthLog(list.get(0));
            if (hasOrder) {
                Map<String, Object> map = new HashMap<>();
                map.put("createTimeBetween", DateUtils.getTodayBegin());
                map.put("createTimeTo", DateUtils.getTodayEnd());
                map.put("purchaserId", purchaserId);
                List<ExtTOrder> orders = tOrderService.queryListByShopIdOrUserId(map);
                bean.setOrderList(orders);
            }
            bean = fillArgs(bean);
            return bean;
        }
    }

    private ExtTPurchaserHealthLog fillArgs(ExtTPurchaserHealthLog bean) {
        Map<String, String> featuresMap = new HashMap<>();
        featuresMap.put("睡眠", "睡眠监测有助于更好的了解自己的身体状态。");
        featuresMap.put("心率", "随时了解您的心率变化，能更快的察觉身体的异样，保持健康。");
        bean.setFeaturesMap(featuresMap);
        TPurchaserHealth tPurchaserHealth = tPurchaserHealthService.queryObjectByPurchaserId(bean.getPurchaserId());
        bean.settPurchaserHealth(tPurchaserHealth);
        TPurchaserHealthExam tPurchaserHealthExam = tPurchaserHealthExamService.queryObjectByPurchaserId(bean.getPurchaserId());
        if (tPurchaserHealthExam == null) {
            featuresMap.put("教练", "绑定教练，让教练精确的设置每日自己身体所需要摄入的成分。");
        }
        bean.settPurchaserHealthExam(tPurchaserHealthExam);
        List<BigDecimal> list = new ArrayList<>();
        List<ExtTPurchaserHealth> healths;
        Map<String, Object> map = new HashMap<>();
        map.put("purchaserId", bean.getPurchaserId());
        healths = tPurchaserHealthService.queryList(map);
        if (healths == null || healths.isEmpty()) {
            bean.setWeightList(list);
            return bean;
        }
        TPurchaserHealth floor = healths.get(0);
        bean.setRecentWeightTime(floor.getCreateTime());
        list.add(floor.getWeight());
        for (int i = 1; i < 5; i++) {
            map.put("timeFrom", DateUtils.getTime(i) + " 00:00:00");
            map.put("timeTo", DateUtils.getTime(i) + " 23:59:59");
            healths = tPurchaserHealthService.queryList(map);
            if (healths == null || healths.isEmpty()) {
                list.add(0, floor.getWeight());
            } else {
                floor = healths.get(0);
                list.add(0, floor.getWeight());
            }
        }
        bean.setWeightList(list);
        return bean;
    }

    @Override
    public int deleteByOrderId(Long orderId) {
        TPurchaserHealthLogExample example = new TPurchaserHealthLogExample();
        TPurchaserHealthLogExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        criteria.andDeleteFlagEqualTo(false);
        List<TPurchaserHealthLog> list = tPurchaserHealthLogMapper.selectByExample(example);
        if (!list.isEmpty()) {
            delete(list.get(0).getId());
        }
        return 1;
    }

    @Override
    public List<ExtHealthTools> queryTools(String time, Long purchaserId, boolean hasOrder) {
        ExtTPurchaserHealthLog extTPurchaserHealthLog = queryByTime(time, purchaserId, hasOrder);
        Map<String, Object> map = new HashMap<>();
        List<ExtHealthTools> list = new ArrayList<>();
        ExtHealthTools tools = new ExtHealthTools();
        tools.setName("饮食");
        tools.setCode("eat");
        map.put("allKcl", extTPurchaserHealthLog.getAllKacl());
        map.put("allAdipose", extTPurchaserHealthLog.getAllAdipose());
        map.put("allCarbohydrate", extTPurchaserHealthLog.getAllCarbohydrate());
        map.put("allProtein", extTPurchaserHealthLog.getAllProtein());
        map.put("allDayKcl", extTPurchaserHealthLog.getAllDayKacl());
        map.put("allDayAdipose", extTPurchaserHealthLog.getAllDayAdipose());
        map.put("allDayCarbohydrate", extTPurchaserHealthLog.getAllDayCarbohydrate());
        map.put("allDayProtein", extTPurchaserHealthLog.getAllDayProtein());
        tools.setData(map);
        list.add(tools);

        tools = new ExtHealthTools();
        tools.setName("体重");
        tools.setCode("weight");
        map = new HashMap<>();
        map.put("weightList", extTPurchaserHealthLog.getWeightList());
        map.put("recentWeightTime", extTPurchaserHealthLog.getRecentWeightTime());
        tools.setData(map);
        list.add(tools);


        tools = new ExtHealthTools();
        tools.setName("教练");
        tools.setCode("coach");
        tools.setDes("绑定教练，让教练精确的设置每日自己身体所需要摄入的成分。");
        if (extTPurchaserHealthLog.gettPurchaserHealthExam() != null) {

            map = new HashMap<>();
            map.put("allKcl", extTPurchaserHealthLog.gettPurchaserHealthExam().getKaclNeed());
            map.put("allAdipose", extTPurchaserHealthLog.gettPurchaserHealthExam().getAdiposeNeed());
            map.put("allCarbohydrate", extTPurchaserHealthLog.gettPurchaserHealthExam().getCarbohydrateNeed());
            map.put("allProtein", extTPurchaserHealthLog.gettPurchaserHealthExam().getProteinNeed());
            tools.setData(map);

        }
        list.add(tools);

        tools = new ExtHealthTools();
        tools.setName("睡眠");
        tools.setCode("sleep");
        tools.setDes("睡眠监测有助于更好的了解自己的身体状态。");
        list.add(tools);

        tools = new ExtHealthTools();
        tools.setName("心率");
        tools.setCode("heartRate");
        tools.setDes("随时了解您的心率变化，能更快的察觉身体的异样，保持健康。");
        list.add(tools);

        return list;
    }
}
