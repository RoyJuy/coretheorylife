package com.coretheorylife.modules.purchaser.service.impl;

import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.exception.ResourceNotExistsException;
import com.coretheorylife.common.fileupload.FileEntity;
import com.coretheorylife.common.fileupload.FileUploadHelper;
import com.coretheorylife.common.utils.RedisUtils;
import com.coretheorylife.common.sms.entity.SmsRedisEntity;
import com.coretheorylife.common.sms.utils.SmsSender;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.gym.entity.TGym;
import com.coretheorylife.modules.gym.entity.TGymCoach;
import com.coretheorylife.modules.gym.service.TGymCoachService;
import com.coretheorylife.modules.gym.service.TGymService;
import com.coretheorylife.modules.purchaser.copier.TPurchaserCopier;
import com.coretheorylife.modules.purchaser.dao.TPurchaserMapper;
import com.coretheorylife.modules.purchaser.dao.ext.ExtTPurchaserMapper;
import com.coretheorylife.modules.purchaser.entity.*;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaser;
import com.coretheorylife.modules.purchaser.service.TPurchaserCoachGymService;
import com.coretheorylife.modules.purchaser.service.TPurchaserHealthExamService;
import com.coretheorylife.modules.purchaser.service.TPurchaserHealthService;
import com.coretheorylife.modules.purchaser.service.TPurchaserService;
import com.coretheorylife.modules.shop.entity.TShop;
import com.google.gson.Gson;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tPurchaserServiceImpl")
public class TPurchaserServiceImpl extends BaseServiceImpl<TPurchaser, TPurchaserExample> implements TPurchaserService {

    @Autowired
    private TPurchaserMapper tPurchaserMapper;

    @Autowired
    private ExtTPurchaserMapper extTPurchaserMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @Autowired
    private TPurchaserHealthService tPurchaserHealthService;

    @Autowired
    private TPurchaserHealthExamService tPurchaserHealthExamService;

    @Autowired
    private TGymCoachService tGymCoachService;

    @Autowired
    private TGymService tGymService;

    @Autowired
    private TPurchaserCoachGymService tPurchaserCoachGymService;

    @Value("${spring.profiles.active}")
    private String profiles;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int save(TPurchaser t) {
        TPurchaser tPurchaser = queryByMobile(t.getMobile());
        if (tPurchaser != null) {
            throw new InvalidParameterException("用户已存在");
        }
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        if (t.getPassword() != null) {
            String salt = RandomStringUtils.randomAlphanumeric(20);
            t.setSort(salt);
            t.setPassword(new Sha256Hash(t.getPassword(), salt).toHex());
        }
        return extTPurchaserMapper.insertSelective(t);
    }

    @Override
    public int update(TPurchaser t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getId());
        return tPurchaserMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TPurchaser t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        return update(t);
    }

    @Override
    public ExtTPurchaser queryObject(Long id) {
        TPurchaser tPurchaser = tPurchaserMapper.selectByPrimaryKey(id);
        ExtTPurchaser extTPurchaser = TPurchaserCopier.INSTANCE.asTPurchaserExt(tPurchaser);
        TPurchaserHealth tPurchaserHealth = tPurchaserHealthService.queryObjectByPurchaserId(id);
        TPurchaserHealthExam tPurchaserHealthExam = tPurchaserHealthExamService.queryObjectByPurchaserId(id);
        extTPurchaser.setPurchaserHealth(tPurchaserHealth);
        extTPurchaser.setPurchaserHealthExam(tPurchaserHealthExam);
        return extTPurchaser;
    }

    @Override
    public List<ExtTPurchaser> queryList(Map<String, Object> keys) {
        return extTPurchaserMapper.queryList(keys);
    }

    @Override
    public List<ExtTPurchaser> queryList() {
        return extTPurchaserMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTPurchaserMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTPurchaserMapper.queryTotal();
    }

    @Override
    public TPurchaser queryByMobile(String mobile) {
        TPurchaserExample example = new TPurchaserExample();
        TPurchaserExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(mobile);
        List<TPurchaser> TPurchasers = tPurchaserMapper.selectByExample(example);
        return TPurchasers.size() == 0 ? null : TPurchasers.get(0);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int register(TPurchaser tPurchaser, String code) {
        checkCode(tPurchaser.getMobile(), code);
        return save(tPurchaser);
    }

    @Override
    public int reSetPassword(TPurchaser t, String code) {
        TPurchaser tPurchaser = queryObject(t.getId());
        checkCode(tPurchaser.getMobile(), code);
        String salt = RandomStringUtils.randomAlphanumeric(20);
        t.setSort(salt);
        if (t.getPassword() != null) {
            t.setPassword(new Sha256Hash(t.getPassword(), salt).toHex());
        }
        return update(t);
    }

    @Override
    public int uploadAvatar(Long PurchaserId, HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        if (multipartRequest.getMultiFileMap().keySet().size() != 1) {
            throw new InvalidParameterException("文件数量错误");
        }
        Map<String, FileEntity> map = fileUploadHelper.uploadFile(request, new String[]{"png", "jpeg", "jpg"}, "purchaser avatar", TPurchaserServiceImpl.class);
        TPurchaser tPurchaser = new TPurchaser();
        tPurchaser.setId(PurchaserId);
        for (String key : map.keySet()) {
            tPurchaser.setAvatar(map.get(key).getCompleteSavePath());
        }
        return update(tPurchaser);
    }

    @Override
    public int uploadAvatarBase64(Long PurchaserId, HttpServletRequest request) {
        Map<String, FileEntity> map = fileUploadHelper.uploadBase64(request, "purchaser_avatar", TPurchaserServiceImpl.class);
        TPurchaser tPurchaser = new TPurchaser();
        tPurchaser.setId(PurchaserId);
        for (String key : map.keySet()) {
            tPurchaser.setAvatar(map.get(key).getCompleteSavePath());
        }
        return update(tPurchaser);
    }

    @Override
    public int updateProperty(Long purchaserId, Integer property) {
        TPurchaser tPurchaser = new TPurchaser();
        tPurchaser.setId(purchaserId);
        tPurchaser.setProperty(property);
        return update(tPurchaser);
    }

    @Override
    public TGym queryMyGym(Long id) {
        TPurchaser tPurchaser = queryObject(id);
        if (tPurchaser.getProperty() == ExtTPurchaser.PROPERTY_COACH) {
            // 教练逻辑
            TGymCoach tGymCoach = tGymCoachService.queryObject(id);
            if (tGymCoach == null || tGymCoach.getGymId() == null) {
                return null;
            }
            TGym tGym = tGymService.queryObject(tGymCoach.getGymId());
            return tGym;
        } else {
            // 普通用户
            TPurchaserCoachGym tPurchaserCoachGym = tPurchaserCoachGymService.selectByPurchaserId(id);
            if (tPurchaserCoachGym == null || tPurchaserCoachGym.getGymId() == null) {
                return null;
            }
            TGym tGym = tGymService.queryObject(tPurchaserCoachGym.getGymId());
            return tGym;
        }
    }

    @Override
    public TPurchaser queryMyCoach(Long purchaserId) {
        TPurchaser tPurchaser = queryObject(purchaserId);
        if (tPurchaser.getProperty() == ExtTPurchaser.PROPERTY_COACH) {
            return null;
        }
        TPurchaserCoachGym tPurchaserCoachGym = tPurchaserCoachGymService.selectByPurchaserId(purchaserId);
        if (tPurchaserCoachGym == null || tPurchaserCoachGym.getCoachId() == null) {
            return null;
        }
        return queryObject(tPurchaserCoachGym.getCoachId());
    }

    @Override
    public int reSetWithdrawPassword(TPurchaser t, String code) {
        TPurchaser tPurchaser = queryObject(t.getId());
        checkCode(tPurchaser.getMobile(), code);
        String salt = RandomStringUtils.randomAlphanumeric(20);
        t.setAccountSort(salt);
        if (t.getAccountPassword() != null) {
            t.setAccountPassword(new Sha256Hash(t.getAccountPassword(), salt).toHex());
        }
        return update(t);
    }

    private void checkCode(String mobile, String code) {
        if (profiles.equals("test") || profiles.equals("dev")) {
            // 测试环境和开发环境不验证
        } else {
            String str = redisUtils.get(SmsSender.SMS_SEND_KEY_PREFIX + mobile);
            if (str != null) {
                SmsRedisEntity smsRedisEntity = new Gson().fromJson(str, SmsRedisEntity.class);
                // 没过期
                if (!smsRedisEntity.getCode().equals(code)) {
                    throw new InvalidParameterException("验证码错误");
                } else {
                    redisUtils.delete(SmsSender.SMS_SEND_KEY_PREFIX + mobile);
                }
            } else {
                throw new InvalidParameterException("手机号错误或验证码已过期");
            }
        }
    }
}
