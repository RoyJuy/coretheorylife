package com.coretheorylife.modules.purchaser.service.impl;

import com.coretheorylife.modules.common.oauth2.TokenGenerator;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.purchaser.dao.TPurchaserTokenMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserToken;
import com.coretheorylife.modules.purchaser.entity.TPurchaserTokenExample;
import com.coretheorylife.modules.purchaser.service.TPurchaserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("tPurchaserTokenServiceImpl")
public class TPurchaserTokenServiceImpl extends BaseServiceImpl<TPurchaserToken, TPurchaserTokenExample> implements TPurchaserTokenService {

    /**
     * token过期时间 这里是30天
     */
    public final static Long EXPIRED_TIME = 30L * 24 * 60 * 60 * 1000;

    @Autowired
    private TPurchaserTokenMapper tPurchaserTokenMapper;

    @Override
    public int save(TPurchaserToken TPurchaserToken) {
        TPurchaserToken.setCreateTime(new Date());
        TPurchaserToken.setUpdateTime(new Date());
        TPurchaserToken.setExpiredTime(new Date(new Date().getTime() + EXPIRED_TIME));
        return tPurchaserTokenMapper.insertSelective(TPurchaserToken);
    }

    @Override
    public int update(TPurchaserToken TPurchaserToken) {
        TPurchaserToken.setUpdateTime(new Date());
        TPurchaserToken.setExpiredTime(new Date(new Date().getTime() + EXPIRED_TIME));
        return tPurchaserTokenMapper.updateByPrimaryKeySelective(TPurchaserToken);
    }

    @Override
    public int delete(Long id) {
        return tPurchaserTokenMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TPurchaserToken queryObject(Long id) {
        return null;
    }

    @Override
    public TPurchaserToken queryByToken(String token) {
        if (token == null) {
            return null;
        }
        TPurchaserTokenExample example = new TPurchaserTokenExample();
        TPurchaserTokenExample.Criteria criteria = example.createCriteria();
        criteria.andTokenEqualTo(token);
        List<TPurchaserToken> tokens = tPurchaserTokenMapper.selectByExample(example);
        return tokens.size() == 0 ? null : tokens.get(0);
    }

    @Override
    public TPurchaserToken queryByUserId(Long userId) {
        if (userId == null) {
            return null;
        }
        TPurchaserTokenExample example = new TPurchaserTokenExample();
        TPurchaserTokenExample.Criteria criteria = example.createCriteria();
        criteria.andPurchaserIdEqualTo(userId);
        List<TPurchaserToken> tokens = tPurchaserTokenMapper.selectByExample(example);
        return tokens.size() == 0 ? null : tokens.get(0);
    }

    @Override
    public int deleteByToken(String token) {
        TPurchaserToken TPurchaserToken = queryByToken(token);
        if (TPurchaserToken == null) {
            return 0;
        } else {
            return delete(TPurchaserToken.getId());
        }
    }

    @Override
    public TPurchaserToken createToken(Long PurchaserId) {
        //生成一个token
        String token = TokenGenerator.generateValue();
        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRED_TIME);
        //判断是否生成过token
        TPurchaserToken tokenEntity = queryByUserId(PurchaserId);
        if (tokenEntity == null) {
            tokenEntity = new TPurchaserToken();
            tokenEntity.setPurchaserId(PurchaserId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpiredTime(expireTime);
            //保存token
            save(tokenEntity);
        } else {
            //tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpiredTime(expireTime);
            //更新token
            update(tokenEntity);
        }
        //redisUtils.set(token, tokenEntity, EXPIRED_TIME);
        return tokenEntity;
    }
}
