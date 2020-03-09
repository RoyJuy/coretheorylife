package com.coretheorylife.modules.gym.service.impl;

import com.coretheorylife.common.fileupload.FileEntity;
import com.coretheorylife.common.fileupload.FileUploadHelper;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.gym.dao.TGymQualificationsMapper;
import com.coretheorylife.modules.gym.entity.TGymQualifications;
import com.coretheorylife.modules.gym.entity.TGymQualificationsExample;
import com.coretheorylife.modules.gym.service.TGymQualificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tGymQualificationsService")
public class TGymQualificationsServiceImpl extends BaseServiceImpl<TGymQualifications, TGymQualificationsExample> implements TGymQualificationsService {


    @Autowired
    private TGymQualificationsMapper tGymQualificationsMapper;

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @Override
    public int save(TGymQualifications t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tGymQualificationsMapper.insertSelective(t);
    }

    @Override
    public int update(TGymQualifications t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getGymId());
        return tGymQualificationsMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public TGymQualifications queryObject(Long id) {
        return tGymQualificationsMapper.selectByPrimaryKey(id);
    }

    @Override
    public TGymQualifications init(Long GymId) {
        TGymQualifications tGymQualifications = queryByGymId(GymId);
        if (tGymQualifications == null) {
            tGymQualifications = new TGymQualifications();
            tGymQualifications.setGymId(GymId);
            save(tGymQualifications);
            return queryByGymId(GymId);
        } else {
            return tGymQualifications;
        }
    }

    @Override
    public TGymQualifications queryByGymId(Long GymId) {
        TGymQualificationsExample example = new TGymQualificationsExample();
        TGymQualificationsExample.Criteria criteria = example.createCriteria();
        criteria.andGymIdEqualTo(GymId);
        criteria.andDeleteFlagEqualTo(false);
        List<TGymQualifications> list = tGymQualificationsMapper.selectByExample(example);
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @Override
    public String uploadQualificationsBase64(Long GymId, HttpServletRequest request) {
        Map<String, FileEntity> map = fileUploadHelper.uploadBase64(request, "gym_qualifications", TGymQualificationsServiceImpl.class);
        for (String key : map.keySet()) {
            return map.get(key).getCompleteSavePath();
        }
        return "";
    }
}
