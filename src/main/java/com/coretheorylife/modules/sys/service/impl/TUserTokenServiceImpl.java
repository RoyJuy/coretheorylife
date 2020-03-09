package com.coretheorylife.modules.sys.service.impl;

import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.sys.dao.TUserTokenMapper;
import com.coretheorylife.modules.sys.entity.TUserToken;
import com.coretheorylife.modules.sys.entity.TUserTokenExample;
import com.coretheorylife.modules.common.oauth2.TokenGenerator;
import com.coretheorylife.modules.sys.service.TUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("tUserTokenService")
public class TUserTokenServiceImpl extends BaseServiceImpl<TUserToken, TUserTokenExample> implements TUserTokenService {

    /**
     * token过期时间 这里是30天
     */
    public final static Long EXPIRED_TIME = 30L * 24 * 60 * 60 * 1000;

    @Autowired
    private TUserTokenMapper tUserTokenMapper;

    @Override
    public int save(TUserToken tUserToken) {
        tUserToken.setCreateTime(new Date());
        tUserToken.setUpdateTime(new Date());
        tUserToken.setExpiredTime(new Date(new Date().getTime() + EXPIRED_TIME));
        return tUserTokenMapper.insertSelective(tUserToken);
    }

    @Override
    public int update(TUserToken tUserToken) {
        tUserToken.setUpdateTime(new Date());
        tUserToken.setExpiredTime(new Date(new Date().getTime() + EXPIRED_TIME));
        return tUserTokenMapper.updateByPrimaryKeySelective(tUserToken);
    }

    @Override
    public int delete(Long id) {
        return tUserTokenMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TUserToken queryObject(Long id) {
        return null;
    }

    @Override
    public TUserToken queryByToken(String token) {
        if (token == null) {
            return null;
        }
        TUserTokenExample example = new TUserTokenExample();
        TUserTokenExample.Criteria criteria = example.createCriteria();
        criteria.andTokenEqualTo(token);
        List<TUserToken> tokens = tUserTokenMapper.selectByExample(example);
        return tokens.size() == 0 ? null : tokens.get(0);
    }

    @Override
    public TUserToken queryByUserId(Long userId) {
        if (userId == null) {
            return null;
        }
        TUserTokenExample example = new TUserTokenExample();
        TUserTokenExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<TUserToken> tokens = tUserTokenMapper.selectByExample(example);
        return tokens.size() == 0 ? null : tokens.get(0);
    }

    @Override
    public int deleteByToken(String token) {
        TUserToken tUserToken = queryByToken(token);
        if (tUserToken == null) {
            return 0;
        } else {
            return delete(tUserToken.getId());
        }
    }

    @Override
    public TUserToken createToken(Long userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();
        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRED_TIME);
        //判断是否生成过token
        TUserToken tokenEntity = queryByUserId(userId);
        if (tokenEntity == null) {
            tokenEntity = new TUserToken();
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
