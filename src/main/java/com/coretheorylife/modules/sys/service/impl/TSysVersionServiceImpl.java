package com.coretheorylife.modules.sys.service.impl;

import com.coretheorylife.common.utils.VersionUtils;
import com.coretheorylife.modules.common.service.impl.BaseServiceImpl;
import com.coretheorylife.modules.sys.entity.TSysVersion;
import com.coretheorylife.modules.sys.entity.TSysVersionExample;
import com.coretheorylife.modules.sys.service.TSysVersionService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("tSysVersionServiceImpl")
public class TSysVersionServiceImpl extends BaseServiceImpl<TSysVersion, TSysVersionExample> implements TSysVersionService {

    @Override
    public Map<String, Object> checkVersion(String platform, String versionNo) {
        Map<String, Object> resultMap = new HashMap<>();
        TSysVersion tSysVersion = queryByPlatform(platform);
        if (tSysVersion == null || tSysVersion.getVersionNo().equals("")) {
            resultMap.put("needUpdate", false);
            return resultMap;
        }
        if (VersionUtils.compareVersion(versionNo, tSysVersion.getVersionNo()) == -1) {
            resultMap.put("needUpdate", true);
            resultMap.put("updateLevel", 0);
            resultMap.put("url", tSysVersion.getUrl());
            resultMap.put("message", tSysVersion.getMessage());
        } else {
            resultMap.put("needUpdate", false);
        }
        return resultMap;
    }

    @Override
    public TSysVersion queryByPlatform(String platform) {
        TSysVersionExample example = new TSysVersionExample();
        TSysVersionExample.Criteria criteria = example.createCriteria();
        criteria.andPlatformEqualTo(platform);
        List<TSysVersion> list = selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }
}
