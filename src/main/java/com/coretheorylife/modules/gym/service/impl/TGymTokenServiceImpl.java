package com.coretheorylife.modules.gym.service.impl;

import com.coretheorylife.modules.common.oauth2.TokenGenerator;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.gym.dao.TGymTokenMapper;
import com.coretheorylife.modules.gym.entity.TGymToken;
import com.coretheorylife.modules.gym.entity.TGymTokenExample;
import com.coretheorylife.modules.gym.service.TGymTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("tGymTokenService")
public class TGymTokenServiceImpl extends BaseServiceImpl<TGymToken, TGymTokenExample> implements TGymTokenService {

    /**
     * token过期时间 这里是30天
     */
    public final static Long EXPIRED_TIME = 30L * 24 * 60 * 60 * 1000;

    @Autowired
    private TGymTokenMapper tGymTokenMapper;

    @Override
    public int save(TGymToken TGymToken) {
        TGymToken.setCreateTime(new Date());
        TGymToken.setUpdateTime(new Date());
        TGymToken.setExpiredTime(new Date(new Date().getTime() + EXPIRED_TIME));
        return tGymTokenMapper.insertSelective(TGymToken);
    }

    @Override
    public int update(TGymToken TGymToken) {
        TGymToken.setUpdateTime(new Date());
        TGymToken.setExpiredTime(new Date(new Date().getTime() + EXPIRED_TIME));
        return tGymTokenMapper.updateByPrimaryKeySelective(TGymToken);
    }

    @Override
    public int delete(Long id) {
        return tGymTokenMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TGymToken queryObject(Long id) {
        return null;
    }

    @Override
    public TGymToken queryByToken(String token) {
        if (token == null) {
            return null;
        }
        TGymTokenExample example = new TGymTokenExample();
        TGymTokenExample.Criteria criteria = example.createCriteria();
        criteria.andTokenEqualTo(token);
        List<TGymToken> tokens = tGymTokenMapper.selectByExample(example);
        return tokens.size() == 0 ? null : tokens.get(0);
    }

    @Override
    public TGymToken queryByUserId(Long userId) {
        if (userId == null) {
            return null;
        }
        TGymTokenExample example = new TGymTokenExample();
        TGymTokenExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<TGymToken> tokens = tGymTokenMapper.selectByExample(example);
        return tokens.size() == 0 ? null : tokens.get(0);
    }

    @Override
    public int deleteByToken(String token) {
        TGymToken TGymToken = queryByToken(token);
        if (TGymToken == null) {
            return 0;
        } else {
            return delete(TGymToken.getId());
        }
    }

    @Override
    public TGymToken createToken(Long userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();
        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRED_TIME);
        //判断是否生成过token
        TGymToken tokenEntity = queryByUserId(userId);
        if (tokenEntity == null) {
            tokenEntity = new TGymToken();
            tokenEntity.setUserId(userId);
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
