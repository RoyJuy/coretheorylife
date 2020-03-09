package com.coretheorylife.modules.gym.service.impl;

import com.coretheorylife.common.annotation.ZookeeperLock;
import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.fileupload.FileEntity;
import com.coretheorylife.common.fileupload.FileUploadHelper;
import com.coretheorylife.common.sms.entity.SmsRedisEntity;
import com.coretheorylife.common.sms.utils.SmsSender;
import com.coretheorylife.common.utils.RedisUtils;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.gym.dao.TGymMapper;
import com.coretheorylife.modules.gym.dao.ext.ExtTGymMapper;
import com.coretheorylife.modules.gym.entity.TGym;
import com.coretheorylife.modules.gym.entity.TGymExample;
import com.coretheorylife.modules.gym.entity.TGymQualifications;
import com.coretheorylife.modules.gym.entity.ext.ExtTGym;
import com.coretheorylife.modules.gym.entity.ext.ExtTGymQualifications;
import com.coretheorylife.modules.gym.service.TGymAccountService;
import com.coretheorylife.modules.gym.service.TGymQualificationsService;
import com.coretheorylife.modules.gym.service.TGymService;
import com.google.gson.Gson;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tGymService")
public class TGymServiceImpl extends BaseServiceImpl<TGym, TGymExample> implements TGymService {

    public static final String LOCK_PREFIX = "gym_user_save";

    @Autowired
    private TGymMapper tGymMapper;
    @Autowired
    private ExtTGymMapper extTGymMapper;
    @Autowired
    private TGymQualificationsService tGymQualificationsService;
    @Value("${spring.profiles.active}")
    private String profiles;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private FileUploadHelper fileUploadHelper;
    @Autowired
    private TGymAccountService tGymAccountService;

    @Override
    public List<ExtTGym> queryList(Map<String, Object> keys) {
        return extTGymMapper.queryList(keys);
    }

    @Override
    public List<ExtTGym> queryList() {
        return extTGymMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTGymMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTGymMapper.queryTotal();
    }

    @Override
    public List<ExtTGym> queryListByLocation(Map<String, Object> keys) {
        return extTGymMapper.queryListByLocation(keys);
    }

    @Override
    public List<ExtTGym> queryListByLocation() {
        return extTGymMapper.queryListByLocation();
    }

    @Override
    public int queryTotalByLocation(Map<String, Object> keys) {
        return extTGymMapper.queryTotalByLocation(keys);
    }

    @Override
    public int queryTotalByLocation() {
        return extTGymMapper.queryTotalByLocation();
    }

    @Override
    public int updateStatus(Long GymId, int status) {
        if (status != ExtTGym.STATUS_OPEN && status != ExtTGym.STATUS_REST && status != ExtTGym.STATUS_CLOSE) {
            throw new InvalidParameterException("平台审核通过会有短信通知~");
        }
        TGymQualifications q1 = tGymQualificationsService.init(GymId);
        if (q1.getStatus() != ExtTGymQualifications.STATUS_CROSS) {
            throw new InvalidParameterException("您的资质未审核通过或未提交");
        }
        TGym tGym = queryObject(GymId);
        tGym.setStatus(status);
        return update(tGym);
    }

    @Override
    public TGym queryByMobile(String mobile) {
        TGymExample example = new TGymExample();
        TGymExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(mobile);
        List<TGym> TGyms = tGymMapper.selectByExample(example);
        return TGyms.size() == 0 ? null : TGyms.get(0);
    }

    @Override
    public int reSetPassword(TGym t, String code) {
        TGym tGym = queryObject(t.getId());
        checkCode(tGym.getMobile(), code);
        String salt = RandomStringUtils.randomAlphanumeric(20);
        t.setSort(salt);
        if (t.getPassword() != null) {
            t.setPassword(new Sha256Hash(t.getPassword(), salt).toHex());
        }
        return update(t);
    }

    @Override
    public int reSetWithdrawPassword(TGym t, String code) {
        TGym tGym = queryObject(t.getId());
        checkCode(tGym.getMobile(), code);
        String salt = RandomStringUtils.randomAlphanumeric(20);
        t.setAccountSort(salt);
        if (t.getAccountPassword() != null) {
            t.setAccountPassword(new Sha256Hash(t.getAccountPassword(), salt).toHex());
        }
        return update(t);
    }

    @Override
    public int uploadAvatarBase64(Long gymId, HttpServletRequest request) {
        Map<String, FileEntity> map = fileUploadHelper.uploadBase64(request, "avatar", TGymServiceImpl.class);
        TGym tGym = new TGym();
        tGym.setId(gymId);
        for (String key : map.keySet()) {
            tGym.setAvatar(map.get(key).getCompleteSavePath());
        }
        return update(tGym);
    }

    @ZookeeperLock(lockPathPrefix = LOCK_PREFIX, fieldName = "mobile")
    @Override
    public int save(TGym t) {
        TGym tGym = queryByMobile(t.getMobile());
        if (tGym != null) {
            throw new InvalidParameterException("用户已存在");
        }
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        if (t.getPassword() != null) {
            String salt = RandomStringUtils.randomAlphanumeric(20);
            t.setSort(salt);
            t.setPassword(new Sha256Hash(t.getPassword(), salt).toHex());
        }
        int i = extTGymMapper.insertSelective(t);
        // 初始化账户
        tGymAccountService.initAccount(t.getId());
        // 初始化两个资质
        tGymQualificationsService.init(t.getId());
        return i;
    }

    @Override
    public int update(TGym t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getId());
        return tGymMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TGym t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        return update(t);
    }

    @Override
    public TGym queryObject(Long id) {
        return tGymMapper.selectByPrimaryKey(id);
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
