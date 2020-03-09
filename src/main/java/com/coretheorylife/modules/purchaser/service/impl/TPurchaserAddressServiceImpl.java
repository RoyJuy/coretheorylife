package com.coretheorylife.modules.purchaser.service.impl;

import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.purchaser.dao.TPurchaserAddressMapper;
import com.coretheorylife.modules.purchaser.dao.ext.ExtTPurchaserAddressMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserAddress;
import com.coretheorylife.modules.purchaser.entity.TPurchaserAddressExample;
import com.coretheorylife.modules.purchaser.entity.ext.ExtTPurchaserAddress;
import com.coretheorylife.modules.purchaser.service.TPurchaserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("tPurchaserAddressService")
public class TPurchaserAddressServiceImpl extends BaseServiceImpl<TPurchaserAddress, TPurchaserAddressExample> implements TPurchaserAddressService {

    @Autowired
    private TPurchaserAddressMapper tPurchaserAddressMapper;

    @Autowired
    private ExtTPurchaserAddressMapper extTPurchaserAddressMapper;

    @Override
    public int save(TPurchaserAddress t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        /**
         * 如果当前用户没有别的银行卡，设置当前银行卡为默认
         */
        Map<String, Object> map = new HashMap<>();
        map.put("purchaserId", t.getPurchaserId());
        map.put("deleteFlag", false);
        List<ExtTPurchaserAddress> list = queryList(map);
        if (list.isEmpty()) {
            t.setDefaultAddress(true);
        } else if (t.getDefaultAddress() != null && t.getDefaultAddress()) {
            for (ExtTPurchaserAddress bean : list) {
                if (bean.getId().equals(t.getId())) {
                    t.setDefaultAddress(true);
                } else {
                    bean.setDefaultAddress(false);
                    updateUnCheck(bean);
                }
            }
        }
        return tPurchaserAddressMapper.insertSelective(t);
    }

    @Override
    public int update(TPurchaserAddress t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getPurchaserId());
        Map<String, Object> map = new HashMap<>();
        map.put("purchaserId", t.getPurchaserId());
        map.put("deleteFlag", false);
        List<ExtTPurchaserAddress> list = queryList(map);
        if (t.getDefaultAddress() != null) {
            if (t.getDefaultAddress()) {
                for (ExtTPurchaserAddress bean : list) {
                    if (bean.getId().equals(t.getId())) {
                        t.setDefaultAddress(true);
                    } else {
                        bean.setDefaultAddress(false);
                        tPurchaserAddressMapper.updateByPrimaryKeySelective(bean);
                    }
                }
            } else {
                boolean flag = false;
                for (ExtTPurchaserAddress bean : list) {
                    if (bean.getDefaultAddress() && !bean.getId().equals(t.getId())) {
                        flag = true;
                    }
                }
                if (!flag) {
                    throw new InvalidParameterException("当前无默认收货地址，修改失败");
                }
            }
        }
        return tPurchaserAddressMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Long id) {
        TPurchaserAddress t = queryObject(id);
        if (t == null) {
            return 0;
        }
        t.setDeleteFlag(true);
        t.setUpdateTime(new Date());
        return updateUnCheck(t);
    }

    @Override
    public TPurchaserAddress queryObject(Long id) {
        return tPurchaserAddressMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateUnCheck(TPurchaserAddress t) {
        t.setUpdateTime(new Date());
        t.setUpdateUser(t.getPurchaserId());
        return tPurchaserAddressMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public List<ExtTPurchaserAddress> queryList(Map<String, Object> keys) {
        return extTPurchaserAddressMapper.queryList(keys);
    }

    @Override
    public List<ExtTPurchaserAddress> queryList() {
        return extTPurchaserAddressMapper.queryList();
    }

    @Override
    public int queryTotal(Map<String, Object> keys) {
        return extTPurchaserAddressMapper.queryTotal(keys);
    }

    @Override
    public int queryTotal() {
        return extTPurchaserAddressMapper.queryTotal();
    }
}
