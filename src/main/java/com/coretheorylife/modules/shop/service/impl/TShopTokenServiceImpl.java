package com.coretheorylife.modules.shop.service.impl;

import com.coretheorylife.modules.common.oauth2.TokenGenerator;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.shop.dao.TShopTokenMapper;
import com.coretheorylife.modules.shop.entity.TShopToken;
import com.coretheorylife.modules.shop.entity.TShopTokenExample;
import com.coretheorylife.modules.shop.service.TShopTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("tShopTokenServiceImpl")
public class TShopTokenServiceImpl extends BaseServiceImpl<TShopToken, TShopTokenExample> implements TShopTokenService {

    /**
     * token过期时间 这里是30天
     */
    public final static Long EXPIRED_TIME = 30L * 24 * 60 * 60 * 1000;

    @Autowired
    private TShopTokenMapper tShopTokenMapper;

    @Override
    public int save(TShopToken TShopToken) {
        TShopToken.setCreateTime(new Date());
        TShopToken.setUpdateTime(new Date());
        TShopToken.setExpiredTime(new Date(new Date().getTime() + EXPIRED_TIME));
        return tShopTokenMapper.insertSelective(TShopToken);
    }

    @Override
    public int update(TShopToken TShopToken) {
        TShopToken.setUpdateTime(new Date());
        TShopToken.setExpiredTime(new Date(new Date().getTime() + EXPIRED_TIME));
        return tShopTokenMapper.updateByPrimaryKeySelective(TShopToken);
    }

    @Override
    public int delete(Long id) {
        return tShopTokenMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TShopToken queryObject(Long id) {
        return null;
    }

    @Override
    public TShopToken queryByToken(String token) {
        if (token == null) {
            return null;
        }
        TShopTokenExample example = new TShopTokenExample();
        TShopTokenExample.Criteria criteria = example.createCriteria();
        criteria.andTokenEqualTo(token);
        List<TShopToken> tokens = tShopTokenMapper.selectByExample(example);
        return tokens.size() == 0 ? null : tokens.get(0);
    }

    @Override
    public TShopToken queryByUserId(Long userId) {
        if (userId == null) {
            return null;
        }
        TShopTokenExample example = new TShopTokenExample();
        TShopTokenExample.Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(userId);
        List<TShopToken> tokens = tShopTokenMapper.selectByExample(example);
        return tokens.size() == 0 ? null : tokens.get(0);
    }

    @Override
    public int deleteByToken(String token) {
        TShopToken TShopToken = queryByToken(token);
        if (TShopToken == null) {
            return 0;
        } else {
            return delete(TShopToken.getId());
        }
    }

    @Override
    public TShopToken createToken(Long shopId) {
        //生成一个token
        String token = TokenGenerator.generateValue();
        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRED_TIME);
        //判断是否生成过token
        TShopToken tokenEntity = queryByUserId(shopId);
        if (tokenEntity == null) {
            tokenEntity = new TShopToken();
            tokenEntity.setShopId(shopId);
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
