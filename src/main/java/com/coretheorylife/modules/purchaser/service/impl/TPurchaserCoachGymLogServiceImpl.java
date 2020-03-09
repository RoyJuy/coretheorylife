package com.coretheorylife.modules.purchaser.service.impl;

import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.utils.DateUtils;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.purchaser.dao.TPurchaserCoachGymLogMapper;
import com.coretheorylife.modules.purchaser.dao.ext.ExtTPurchaserCoachGymLogMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserCoachGymLog;
import com.coretheorylife.modules.purchaser.entity.TPurchaserCoachGymLogExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserCoachGymLog;
import com.coretheorylife.modules.purchaser.service.TPurchaserCoachGymLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("tPurchaserCoachGymLogService")
public class TPurchaserCoachGymLogServiceImpl extends BaseServiceImpl<TPurchaserCoachGymLog, TPurchaserCoachGymLogExample> implements TPurchaserCoachGymLogService {

    @Autowired
    private TPurchaserCoachGymLogMapper tPurchaserCoachGymLogMapper;
    @Autowired
    private ExtTPurchaserCoachGymLogMapper extTPurchaserCoachGymLogMapper;

    @Override
    public int queryPurchaseCountByGym(Map<String, Object> queryMap) {
        return extTPurchaserCoachGymLogMapper.queryPurchaseCountByGym(queryMap);
    }

    @Override
    public int queryGymIncrease(Long gymId, String createDate) {
        // 增长的
        Map<String, Object> map = new HashMap<>();
        // 如果是增加的，那么当前记录的健身房的id是有值的，所以根据健身房id判断即可
        map.put("gymId", gymId);
        map.put("createDate", createDate);
        map.put("queryType", ExtTPurchaserCoachGymLog.QUERY_TYPE_INCREASE);
        return queryPurchaseCountByGym(map);
    }

    @Override
    public int queryGymFewer(Long gymId, String createDate) {
        Map<String, Object> map = new HashMap<>();
        // 如果是减少的，那么当前记录里面健身房的id就是空，所以只能根据旧的健身房id判断是哪个健身房的记录
        map.put("oldGymId", gymId);
        map.put("createDate", createDate);
        map.put("queryType", ExtTPurchaserCoachGymLog.QUERY_TYPE_FEWER);
        return queryPurchaseCountByGym(map);
    }

    @Override
    public List<TPurchaserCoachGymLog> queryList(Long purchaserId, Date createDate, Integer type) {
        TPurchaserCoachGymLogExample example = new TPurchaserCoachGymLogExample();
        TPurchaserCoachGymLogExample.Criteria criteria = example.createCriteria();
        criteria.andPurchaserIdEqualTo(purchaserId);
        criteria.andCreateDateEqualTo(createDate);
        criteria.andTypeEqualTo(type);
        return tPurchaserCoachGymLogMapper.selectByExample(example);
    }

    @Override
    public List<HashMap<String, Object>> queryPurchaseDateListByGym(Map<String, Object> queryMap) {
        return extTPurchaserCoachGymLogMapper.queryPurchaseDateListByGym(queryMap);
    }

    @Override
    public HashMap<String, Integer> queryPurchaseDateMapByGym(Map<String, Object> queryMap) {
        HashMap<String, Integer> result = new HashMap<>();
        List<HashMap<String, Object>> list = queryPurchaseDateListByGym(queryMap);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (HashMap<String, Object> map : list) {
            result.put(dateFormat.format(map.get("createDate")), Integer.valueOf(map.get("count").toString()));
        }
        return result;
    }

    @Override
    public Map<String, Object> queryEcharts(String timeFrom, String timeTo, Long gymId) {
        Map<String, Object> resultMap = new HashMap<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date from, to;
        try {
            from = dateFormat.parse(timeFrom);
            to = dateFormat.parse(timeTo);
        } catch (ParseException e) {
            throw new InvalidParameterException("时间格式错误 yyyy-MM-dd");
        }
        if (from.getTime() > to.getTime()) {
            throw new InvalidParameterException("timeFrom 不能大于 timeTo");
        }
        List<String> list = DateUtils.getTimes(from, to);
        resultMap.put("xAxisData", list);
        resultMap.put("legendData", new String[]{"增长", "减少", "总计"});
        List<List<Integer>> seriesData = new ArrayList<>();

        List<Integer> allSeriesData = new ArrayList<>();
        List<Integer> increaseSeriesData = new ArrayList<>();
        List<Integer> fewerSeriesData = new ArrayList<>();

        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("timeFrom", timeFrom);
        queryMap.put("timeTo", timeTo);
        queryMap.put("gymId", gymId);
        queryMap.put("queryType", ExtTPurchaserCoachGymLog.QUERY_TYPE_INCREASE);
        HashMap<String, Integer> result = queryPurchaseDateMapByGym(queryMap);
        Integer temp;
        // 遍历中间所有的日期
        for (String s : list) {
            temp = result.get(s);
            if (temp == null) {
                temp = 0;
            }
            allSeriesData.add(temp);
            increaseSeriesData.add(temp);
        }
        // 解绑的
        queryMap = new HashMap<>();
        queryMap.put("timeFrom", timeFrom);
        queryMap.put("timeTo", timeTo);
        queryMap.put("oldGymId", gymId);
        queryMap.put("queryType", ExtTPurchaserCoachGymLog.QUERY_TYPE_FEWER);
        result = queryPurchaseDateMapByGym(queryMap);
        for (int i = 0; i < list.size(); i++) {
            temp = result.get(list.get(i));
            if (temp == null) {
                temp = 0;
            }
            fewerSeriesData.add(temp);
            allSeriesData.set(i, allSeriesData.get(i) - temp);
        }
        seriesData.add(increaseSeriesData);
        seriesData.add(fewerSeriesData);
        seriesData.add(allSeriesData);
        resultMap.put("seriesData", seriesData);
        return resultMap;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int save(TPurchaserCoachGymLog t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        t.setCreateTime(new Date());
        // 判断是否为用户增长或减少的记录
        if (t.getType() == ExtTPurchaserCoachGymLog.TYPE_INCREASE || t.getType() == ExtTPurchaserCoachGymLog.TYPE_FEWER) {
            int increaseCount = 0, fewerCount = 0;
            if (t.getType() == ExtTPurchaserCoachGymLog.TYPE_INCREASE) {
                increaseCount++;
            } else {
                fewerCount++;
            }
            // 如果是的话，查询当前用户在今天有没有日志记录
            // 增长记录
            List<TPurchaserCoachGymLog> increaseList = queryList(t.getPurchaserId(), new Date(), ExtTPurchaserCoachGymLog.TYPE_INCREASE);
            increaseCount += increaseList.size();

            // 减少记录
            List<TPurchaserCoachGymLog> fewerList = queryList(t.getPurchaserId(), new Date(), ExtTPurchaserCoachGymLog.TYPE_INCREASE);
            fewerCount += fewerList.size();
            // 将旧的记录全部的queryType全部更新为0
            for (TPurchaserCoachGymLog tPurchaserCoachGymLog : increaseList) {
                tPurchaserCoachGymLog.setQueryType(ExtTPurchaserCoachGymLog.QUERY_TYPE_DEFAULT);
                update(tPurchaserCoachGymLog);
            }
            for (TPurchaserCoachGymLog tPurchaserCoachGymLog : fewerList) {
                tPurchaserCoachGymLog.setQueryType(ExtTPurchaserCoachGymLog.QUERY_TYPE_DEFAULT);
                update(tPurchaserCoachGymLog);
            }
            // 然后比较当天绑定和解绑的数量，如果相等queryType也设置为0
            // 否则如果解绑的多queryType设置为解绑，否则设置为绑定，即为用户增长
            if (increaseCount > fewerCount) {
                // 用户增长
                t.setQueryType(ExtTPurchaserCoachGymLog.QUERY_TYPE_INCREASE);
            } else if (fewerCount > increaseCount) {
                // 用户减少
                t.setQueryType(ExtTPurchaserCoachGymLog.QUERY_TYPE_FEWER);
            } else {
                // 之前加了现在减了或者之前减了现在加了，认为没有发生变化
                t.setQueryType(ExtTPurchaserCoachGymLog.QUERY_TYPE_DEFAULT);
            }
        }
        // 如果不是直接保存
        return tPurchaserCoachGymLogMapper.insertSelective(t);
    }

    @Override
    public int update(TPurchaserCoachGymLog t) {
        t.setUpdateTime(new Date());
        return tPurchaserCoachGymLogMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TPurchaserCoachGymLog t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return update(t);
    }

    @Override
    public TPurchaserCoachGymLog queryObject(Long id) {
        return tPurchaserCoachGymLogMapper.selectByPrimaryKey(id);
    }
}
