package com.coretheorylife.common.fileupload;

import com.coretheorylife.common.exception.InvalidParameterException;
import com.coretheorylife.common.exception.ResourceTypeException;
import com.coretheorylife.common.utils.LogUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 作者：Connor 2018-07-09
 * 上传文件的工具类
 */
@Configuration
public class FileUploadHelper {

    @Value("${webUploadPath}")
    String rootUploadPath;

    public String getRootUploadPath() {
        return rootUploadPath;
    }

    public void setRootUploadPath(String rootUploadPath) {
        this.rootUploadPath = rootUploadPath;
    }


    /**
     * 上传格式为type的文件到savePath
     *
     * @param request 请求，文件包含在里面
     * @param type 文件类型 String[] 例如String[] IMGTYPE = {"png"} 必须都为小写
     * @param savePath 文件保存的路径（功能名称即可） 例如 banner or article
     * @param T 记录日志的class
     * @return 符合要求的Result
     */
    public Map<String , FileEntity> uploadFile(HttpServletRequest request, String[] type, String savePath, Class<?> T) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 获取对应file对象
        MultiValueMap<String,MultipartFile> multiFileMap = multipartRequest.getMultiFileMap();//请求中获得多上传文件
        String fileName = null;
        String prefix = null;
        List<MultipartFile> fileSet = new LinkedList<>();
        for(Map.Entry<String, List<MultipartFile>> temp : multiFileMap.entrySet()){
            fileSet = temp.getValue();
        }
        for (MultipartFile multipartFile: fileSet ) {
            fileName = multipartFile.getOriginalFilename();
            if (fileName.indexOf(".") == -1) {
                throw new InvalidParameterException("未知文件类型，请检查文件后缀名");
            }
            prefix = fileName.substring(fileName.lastIndexOf(".")+1);
            if ( ! Arrays.asList(type).contains(prefix.toLowerCase())) {
                //文件名后缀不符合要求
                throw new ResourceTypeException("资源类型不合法");
            }
        }
        FileSaveUtil fileSaveUtil = new FileSaveUtil();
        Map<String , FileEntity> map = null;
        Path path = Paths.get(rootUploadPath);
        try{
            map = fileSaveUtil.save(path, savePath, request);
        }
        catch (IOException e) {
            LogUtil.debug(T, e);
        }
        return map;
    }

    /**
     * 上传格式为type的文件到savePath
     *
     * @param request 请求，文件包含在里面
     * @param savePath 文件保存的路径（功能名称即可） 例如 banner or article
     * @param T 记录日志的class
     * @return 符合要求的Result
     */
    public Map<String , FileEntity> uploadBase64(HttpServletRequest request, String savePath, Class<?> T) {
        if (request.getParameter("base64") == null) {
            throw new InvalidParameterException("文件不存在");
        }
        FileSaveUtil fileSaveUtil = new FileSaveUtil();
        Map<String , FileEntity> map = null;
//        Path path = Paths.get(ZipFileEntity.DEFAULT_SAVE_DIR);
        Path path = Paths.get(rootUploadPath);
        try{
            map = fileSaveUtil.saveBase64(path, savePath, request);
        }
        catch (IOException e) {
            LogUtil.debug(T, e);
        }
        return map;
    }
}
