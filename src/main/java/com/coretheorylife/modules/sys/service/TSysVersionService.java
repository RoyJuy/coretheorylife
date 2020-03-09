package com.coretheorylife.modules.sys.service;

import com.coretheorylife.modules.common.service.BaseService;
import com.coretheorylife.modules.sys.entity.TSysVersion;
import com.coretheorylife.modules.sys.entity.TSysVersionExample;

import java.util.Map;

public interface TSysVersionService extends BaseService<TSysVersion, TSysVersionExample> {

    Map<String, Object> checkVersion(String platform, String versionNo);

    TSysVersion queryByPlatform(String platform);
}
