package com.coretheorylife.modules.shop.service.impl;

import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.fileupload.FileEntity;
import com.coretheorylife.common.fileupload.FileUploadHelper;
import com.coretheorylife.common.utils.RedisUtils;
import com.coretheorylife.common.sms.entity.SmsRedisEntity;
import com.coretheorylife.common.sms.utils.SmsSender;
import com.coretheorylife.common.utils.SnowflakeIdGenerator;
import com.coretheorylife.config.IdGeneratorConfig;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.purchaser.service.TPurchaserRateService;
import com.coretheorylife.modules.shop.dao.TShopMapper;
import com.coretheorylife.modules.shop.dao.ext.ExtTShopMapper;
import com.coretheorylife.modules.shop.entity.TShop;
import com.coretheorylife.modules.shop.entity.TShopExample;
import com.coretheorylife.modules.shop.entity.TShopQualifications;
import com.coretheorylife.modules.shop.entity.ext.ExtTShop;
import com.coretheorylife.modules.shop.entity.ext.ExtTShopQualifications;
import com.coretheorylife.modules.shop.service.TShopAccountService;
import com.coretheorylife.modules.shop.service.TShopQualificationsService;
import com.coretheorylife.modules.shop.service.TShopService;
import com.google.gson.Gson;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("tShopServiceImpl")
public class TShopServiceImpl extends BaseServiceImpl<TShop, TShopExample> implements TShopService {

    @Autowired
    private TShopMapper tShopMapper;

    @Autowired
    private ExtTShopMapper extTShopMapper;

    @Autowired
    private TShopAccountService tShopAccountService;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @Autowired
    private TShopQualificationsService tShopQualificationsService;

    @Autowired
    private TPurchaserRateService tPurchaserRateService;

    @Value("${spring.profiles.active}")
    private String profiles;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int save(TShop t) {
        TShop tShop = queryByMobile(t.getMobile());
        if (tShop != null) {
            throw new InvalidParameterException("用户已存在");
        }
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        if (t.getPassword() != null) {
            String salt = RandomStringUtils.randomAlphanumeric(20);
            t.setSort(salt);
            t.setPassword(new Sha256Hash(t.getPassword(), salt).toHex());
        }
        int i = extTShopMapper.insertSelective(t);
        // 初始化账户
        tShopAccountService.initAccount(t.getId());
        // 初始化两个资质
        tShopQualificationsService.initQualificationsIndustry(t.getId());
        tShopQualificationsService.initQualificationsMain(t.getId());
        return i;
    }

    @Override
    public int update(TShop t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getId());
        return tShopMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TShop t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        return update(t);
    }

    @Override
    public TShop queryObject(Long id) {
        return tShopMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ExtTShop> queryList(Map<String, Object> keys) {
        return extTShopMapper.queryList(keys);
    }

    @Override
    public List<ExtTShop> queryList() {
        return extTShopMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTShopMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTShopMapper.queryTotal();
    }

    @Override
    public List<ExtTShop> queryListByLocation(Map<String, Object> keys) {
        return extTShopMapper.queryListByLocation(keys);
    }

    @Override
    public List<ExtTShop> queryListByLocation() {
        return extTShopMapper.queryListByLocation();
    }

    @Override
    public int queryTotalByLocation(Map<String, Object> keys) {
        return extTShopMapper.queryTotalByLocation(keys);
    }

    @Override
    public int queryTotalByLocation() {
        return extTShopMapper.queryTotalByLocation();
    }

    @Override
    public int updateStatus(Long shopId, int status) {
        if (status != ExtTShop.STATUS_OPEN && status != ExtTShop.STATUS_REST && status != ExtTShop.STATUS_CLOSE) {
            throw new InvalidParameterException("平台审核通过会有短信通知~");
        }
        TShopQualifications q1 = tShopQualificationsService.initQualificationsMain(shopId);
        TShopQualifications q2 = tShopQualificationsService.initQualificationsIndustry(shopId);
        if (q1.getStatus() != ExtTShopQualifications.STATUS_CROSS) {
            throw new InvalidParameterException("您的资质未审核通过或未提交");
        }
        if (q2.getStatus() != ExtTShopQualifications.STATUS_CROSS) {
            throw new InvalidParameterException("您的资质未审核通过或未提交");
        }
        TShop tShop = queryObject(shopId);
        tShop.setStatus(status);
        return update(tShop);
    }

    @Override
    public TShop queryByMobile(String mobile) {
        TShopExample example = new TShopExample();
        TShopExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(mobile);
        List<TShop> TShops = tShopMapper.selectByExample(example);
        return TShops.size() == 0 ? null : TShops.get(0);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int register(TShop tShop, String code) {
        checkCode(tShop.getMobile(), code);
        tShop.setShopCode(new SnowflakeIdGenerator(IdGeneratorConfig.workerId, IdGeneratorConfig.datacenterId).nextId() + "");
        return save(tShop);
    }

    @Override
    public int reSetPassword(TShop t, String code) {
        TShop tShop = queryObject(t.getId());
        checkCode(tShop.getMobile(), code);
        String salt = RandomStringUtils.randomAlphanumeric(20);
        t.setSort(salt);
        if (t.getPassword() != null) {
            t.setPassword(new Sha256Hash(t.getPassword(), salt).toHex());
        }
        return update(t);
    }

    @Override
    public int reSetWithdrawPassword(TShop t, String code) {
        TShop tShop = queryObject(t.getId());
        checkCode(tShop.getMobile(), code);
        String salt = RandomStringUtils.randomAlphanumeric(20);
        t.setAccountSort(salt);
        if (t.getAccountPassword() != null) {
            t.setAccountPassword(new Sha256Hash(t.getAccountPassword(), salt).toHex());
        }
        return update(t);
    }

    @Override
    public int uploadAvatar(Long shopId, HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        if (multipartRequest.getMultiFileMap().keySet().size() != 1) {
            throw new InvalidParameterException("文件数量错误");
        }
        Map<String, FileEntity> map = fileUploadHelper.uploadFile(request, new String[]{"png", "jpeg", "jpg"}, "avatar", TShopServiceImpl.class);
        TShop tShop = new TShop();
        tShop.setId(shopId);
        for (String key : map.keySet()) {
            tShop.setAvatar(map.get(key).getCompleteSavePath());
        }
        return update(tShop);
    }

    @Override
    public int uploadAvatarBase64(Long shopId, HttpServletRequest request) {
        Map<String, FileEntity> map = fileUploadHelper.uploadBase64(request, "avatar", TShopServiceImpl.class);
        TShop tShop = new TShop();
        tShop.setId(shopId);
        for (String key : map.keySet()) {
            tShop.setAvatar(map.get(key).getCompleteSavePath());
        }
        return update(tShop);
    }

    @Override
    public BigDecimal queryAvgRate(Long shopId) {
        return tPurchaserRateService.selectAvgRateByShopId(shopId);
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
