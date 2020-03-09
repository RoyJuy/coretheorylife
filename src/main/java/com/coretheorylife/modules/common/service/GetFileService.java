package com.coretheorylife.modules.common.service;


import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * 获取文件资源
 * 作者：Connor 2018年7月6日
 */
public interface GetFileService {

    void doImgPush(HttpServletResponse res, File file, String fileName, String type) throws Exception;
}
