package com.coretheorylife.modules.common.controller;

import com.coretheorylife.common.exception.ResourceNotExistsException;
import com.coretheorylife.common.exception.StorageException;
import com.coretheorylife.common.fileupload.FileEntity;
import com.coretheorylife.common.utils.LogUtil;
import com.coretheorylife.modules.common.service.GetFileService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.nio.file.Paths;
import java.util.*;

/**
 * 文章管理
 * 作者：Connor on 2018-7-4
 */
@Api(tags = "文件管理", description = "获取文件")
@Validated
@RestController
@RequestMapping("/resource")
public class GetFileController {

    @Autowired
    private GetFileService getFileService;

    private static final String[] IMGTYPE = {"jpg", "bmp", "gif", "jpeg", "tiff", "psd", "tga", "eps", "png"};

    @Value("${webUploadPath}")
    String rootUploadPath;
    @Value("${spring.profiles.active}")
    private String active;

    @GetMapping("/{path}/{fileName}.{type}")
    public void getFile(@PathVariable("type") String type, HttpServletResponse res, @PathVariable("path") String path, @PathVariable("fileName") String fileName) {
        String rootPath = Paths.get(rootUploadPath).resolve("").toString();
//        String rootPath = Paths.get(ZipFileEntity.DEFAULT_SAVE_DIR).resolve("").toString();
        String[] paths = path.split(FileEntity.SPLIT);
        StringBuilder resultPath = new StringBuilder();
        for (String s : paths) {
            resultPath.append(s);
            resultPath.append("/");
        }
        File file = new File(rootPath + "/" + resultPath.toString() + "/" + fileName + "." + type);
        LogUtil.printParameters(this.getClass(), file, LogUtil.PRINT_TYPE_INPUT);
        if (!file.exists()) {
            if (active.equals("pro")) {
                //资源不存在
                throw new ResourceNotExistsException();
            } else {
                return;
            }
        }
        try {
            if (Arrays.asList(IMGTYPE).contains(type.toLowerCase())) {
                getFileService.doImgPush(res, file, fileName, type);
            }
        } catch (Exception e) {
            //文件保存异常
            throw new StorageException();
        }
    }
}
