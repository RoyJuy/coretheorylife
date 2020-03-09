package com.coretheorylife.common.fileupload;

import com.coretheorylife.common.utils.DateUtils;
import com.coretheorylife.common.utils.LogUtil;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Path;
import java.util.*;

/**
 * 作者：Connor 2018-07-09
 * 上传文件的工具类
 */
public class FileSaveUtil {

    public static final String[] IMAGE_FILE_TYPE = {"bmp", "jpg", "jpeg", "png", "tiff", "gif", "pcx", "tga", "exif", "fpx", "svg", "psd", "cdr"};
    public static final String[] WORD_FILE_TYPE = {"docx", "doc"};
    public static final String[] PPT_FILE_TYPE = {"ppt", "pptx"};
    public static final String[] EXCEL_FILE_TYPE = {"xls", "xlsx"};
    public static final String[] PDF_FILE_TYPE = {"pdf"};
    public static final String[] TXT_FILE_TYPE = {"txt"};
    public static final String[] ZIP_FILE_TYPE = {"zip", "rar"};

    /**
     * @param rootLocation 主目录
     * @param dirName      文件存储路径，用户可自定义
     * @param request
     * @return Map<fileKey                               ,                               ZipFileEntity>
     * @throws IOException
     */
    public Map<String, FileEntity> save(Path rootLocation, String dirName, HttpServletRequest request) throws IOException {
        //主目录
        String rootPath = rootLocation.resolve("").toString();

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 获取对应file对象
        MultiValueMap<String, MultipartFile> multiFileMap = multipartRequest.getMultiFileMap();//请求中获得多上传文件
        String prePathStr = "/" + FileEntity.DEFAULT_SAVE_DIR + "/" + dirName;
        LogUtil.debug(FileSaveUtil.class, "前缀：" + prePathStr);
        //获得文件对象
        File saveFile = new File(rootPath + "/" + dirName);
        List<FileEntity> fileEntityList = new ArrayList<>();
        String local;
        String newUrl;
        List<MultipartFile> fileSet;
        for (Map.Entry<String, List<MultipartFile>> temp : multiFileMap.entrySet()) {
            fileSet = temp.getValue();
            String fileKey = temp.getKey();
            for (MultipartFile multipartFile : fileSet) {
                // 获取对应文件
                if (multipartFile.getSize() != 0L) {//文件长度不为空
                    FileEntity fileEntity = saveUpdateFile(multipartFile, saveFile.getPath(), request);
                    fileEntity.setPrePath(prePathStr);
                    fileEntity.setOriginalFilename(multipartFile.getOriginalFilename());
                    fileEntity.setFileKey(fileKey);
                    local = fileEntity.getCompleteSavePath().substring(0, fileEntity.getCompleteSavePath().indexOf(FileEntity.DEFAULT_SAVE_DIR) + FileEntity.DEFAULT_SAVE_DIR.length() + 1);
                    newUrl = fileEntity.getCompleteSavePath().substring(fileEntity.getCompleteSavePath().indexOf(FileEntity.DEFAULT_SAVE_DIR));
                    newUrl = newUrl.substring(newUrl.indexOf("/") + 1, newUrl.lastIndexOf("/"));
                    newUrl = newUrl.replaceAll("/", FileEntity.SPLIT);
                    fileEntity.setCompleteSavePath(local + newUrl + fileEntity.getRelativeSavePath());
                    fileEntityList.add(fileEntity);
                }
            }
        }
        return listToMap(fileEntityList);
    }

    /**
     * @param rootLocation 主目录
     * @param dirName      文件存储路径，用户可自定义
     * @return Map<fileKey                               ,                               ZipFileEntity>
     * @throws IOException
     */
    public Map<String, FileEntity> saveBase64(Path rootLocation, String dirName, HttpServletRequest request) throws IOException {
        String imageFile = request.getParameter("base64");
        //imageFile = imageFile.replaceAll("data:image/jpeg;base64,", "");
        imageFile = imageFile.substring(imageFile.indexOf(";base64,") + 8, imageFile.length());
        BASE64Decoder decoder = new BASE64Decoder();
        // Base64解码
        byte[] imageByte = null;
        try {
            imageByte = decoder.decodeBuffer(imageFile);
            for (int i = 0; i < imageByte.length; ++i) {
                if (imageByte[i] < 0) {// 调整异常数据
                    imageByte[i] += 256;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String rootPath = rootLocation.resolve("").toString();
        String fileName = DateUtils.getStringTodayForFileName() + ".png";
        String prePathStr = "/" + FileEntity.DEFAULT_SAVE_DIR + "/" + dirName + "/" + fileName;
        File saveFile = new File(rootPath + "/" + dirName + "/" + fileName);
        try {
            File filePath = new File(rootPath + "/" + dirName);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            saveFile.createNewFile();
            if (!saveFile.exists()) {
                saveFile.createNewFile();
            }
            OutputStream imageStream = new FileOutputStream(saveFile);
            imageStream.write(imageByte);
            imageStream.flush();
            imageStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileEntity file = new FileEntity(rootPath + "/" + dirName, fileName);
        file.setContentType("image/png");
        file.setCompleteSavePath(dirName + "/" + fileName);
        file.setPrePath(prePathStr);
        Map<String, FileEntity> map = new HashMap<>();
        map.put("base64", file);
        return map;
    }

    private FileEntity saveUpdateFile(MultipartFile uploadFile, String path, HttpServletRequest request) throws IOException {
        String originalFilename = uploadFile.getOriginalFilename();//获取文件原名
        LogUtil.debug(this.getClass(), "文件原始名称为:" + originalFilename);
        String contentType = uploadFile.getContentType();//获取文件类型既后缀
        String type = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        String fileName = DateUtils.getStringTodayForFileName() + "." + type;

        FileEntity file = new FileEntity(path, fileName);
        file.setContentType(contentType);
        file.setOriginalFilename(originalFilename);
        LogUtil.debug(this.getClass(), "文件保存路径：" + file.getSaveDirectory());
        // 通过org.apache.commons.io.FileUtils的writeByteArrayToFile对图片进行保存
        FileUtils.writeByteArrayToFile(file.getFile(), uploadFile.getBytes());

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(file.getFile());
        factory.setSizeThreshold(1024 * 100);
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("utf-8");
        upload.setFileSizeMax(1024 * 1024 * 1000);
        upload.setSizeMax(1024 * 1024 * 5000);
        upload.setProgressListener(new UploadListener(new UploadStatus(), request.getSession()));
        return file;
    }


    private Map<String, FileEntity> listToMap(List<FileEntity> fileEntityList) {
        Map<String, FileEntity> map = new HashMap<>();
        for (FileEntity entity : fileEntityList) {
            map.put(entity.getFileKey(), entity);
        }
        return map;
    }

    /**
     * 获取当前jar包所在系统中的目录
     */
    public static File getBaseJarPath(Class<?> clazz) {
        ApplicationHome home = new ApplicationHome(clazz);
        File jarFile = home.getSource();
        return jarFile.getParentFile();
    }
}
