package com.coretheorylife.modules.shop.service.impl;

import com.coretheorylife.common.fileupload.FileEntity;
import com.coretheorylife.common.fileupload.FileUploadHelper;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.shop.dao.TShopQualificationsMapper;
import com.coretheorylife.modules.shop.entity.TShopQualifications;
import com.coretheorylife.modules.shop.entity.TShopQualificationsExample;
import com.coretheorylife.modules.shop.entity.ext.ExtTShopQualifications;
import com.coretheorylife.modules.shop.service.TShopQualificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tShopQualificationsService")
public class TShopQualificationsServiceImpl extends BaseServiceImpl<TShopQualifications, TShopQualificationsExample> implements TShopQualificationsService {

    @Autowired
    private TShopQualificationsMapper tShopQualificationsMapper;

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @Override
    public int save(TShopQualifications t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        return tShopQualificationsMapper.insertSelective(t);
    }

    @Override
    public int update(TShopQualifications t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getShopId());
        return tShopQualificationsMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public TShopQualifications queryObject(Long id) {
        return tShopQualificationsMapper.selectByPrimaryKey(id);
    }

    @Override
    public TShopQualifications init(Long shopId, int type) {
        TShopQualifications tShopQualifications = queryByShopIdAndType(shopId, type);
        if (tShopQualifications == null) {
            tShopQualifications = new TShopQualifications();
            tShopQualifications.setShopId(shopId);
            tShopQualifications.setQualificationsType(type);
            if (type == ExtTShopQualifications.QUALIFICATIONS_TYPE_MAIN) {
                tShopQualifications.setCredentialsType(ExtTShopQualifications.CREDENTIALS_TYPE_BUSINESS_LICENSE);
            } else {
                tShopQualifications.setCredentialsType(ExtTShopQualifications.CREDENTIALS_TYPE_CATERING_PERMIT);
            }
            save(tShopQualifications);
            return queryByShopIdAndType(shopId, type);
        } else {
            return tShopQualifications;
        }
    }

    @Override
    public TShopQualifications initQualificationsMain(Long shopId) {
        return init(shopId, ExtTShopQualifications.QUALIFICATIONS_TYPE_MAIN);
    }

    @Override
    public TShopQualifications initQualificationsIndustry(Long shopId) {
        return init(shopId, ExtTShopQualifications.QUALIFICATIONS_TYPE_INDUSTRY);
    }


    @Override
    public TShopQualifications queryByShopIdAndType(Long shopId, int type) {
        TShopQualificationsExample example = new TShopQualificationsExample();
        TShopQualificationsExample.Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(shopId);
        criteria.andDeleteFlagEqualTo(false);
        criteria.andQualificationsTypeEqualTo(type);
        List<TShopQualifications> list = tShopQualificationsMapper.selectByExample(example);
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @Override
    public String uploadQualificationsBase64(Long shopId, HttpServletRequest request) {
        Map<String, FileEntity> map = fileUploadHelper.uploadBase64(request, "qualifications", TShopServiceImpl.class);
        for (String key : map.keySet()) {
            return map.get(key).getCompleteSavePath();
        }
        return "";
    }
}
