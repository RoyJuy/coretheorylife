package com.coretheorylife.common.fileupload;

import java.io.File;

/**
 * 创 建 人：Connor
 * 创建时间：2017/12/22 16:42
 * 说    明：
 */
public class FileEntity {

    /**
     * create by Connor on 2018-07-10
     * url split
     */
    public static final String SPLIT = ",";
    public static final String DEFAULT_SAVE_DIR = "resource";

    /**
     * 保存文件夹
     */
    private String saveDirectory = DEFAULT_SAVE_DIR;
    /**
     * 文件名称 20171227-163043-11.png
     */
    private String fileName;
    /**
     * 文件类型或后缀  image/png
     */
    private String contentType;
    /**
     * 路径前缀 http://192.168.1.187:8088/sys/menu
     */
    private String prePath;
    /**
     * 文件完成存储路径 http://192.168.1.187:8088/sys/menu/20171227-163043-11.png
     */
    private String completeSavePath;
    /**
     * 相对路径 /20171227-163043-11.png
     */
    private String relativeSavePath;
    /**
     * 源文件名  示例图.jpg
     */
    private String originalFilename;
    /**
     * 文件参数名
     */
    private String fileKey;


    public FileEntity(String saveDirectory, String fileName) {
        this.saveDirectory = saveDirectory;
        this.fileName = fileName;
    }

    public FileEntity() {
    }

    public String getFileName() {
        return fileName;
    }

    public String getSaveDirectory() {
        return saveDirectory;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getPrePath() {
        if (prePath == null) {
            return "";
        }
        return prePath;
    }

    public void setPrePath(String prePath) {
        this.prePath = prePath;
        setCompleteSavePath((prePath != null ? prePath : "") + (getRelativeSavePath() != null ? getRelativeSavePath() : ""));
    }

    public String getCompleteSavePath() {
        return completeSavePath;
    }

    public void setCompleteSavePath(String completeSavePath) {
        this.completeSavePath = completeSavePath;
    }

    public String getRelativeSavePath() {
        return relativeSavePath;
    }

    public void setRelativeSavePath(String relativeSavePath) {
        this.relativeSavePath = relativeSavePath;
    }

    public void setSaveDirectory(String saveDirectory) {
        this.saveDirectory = saveDirectory;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getFileKey() {
        return fileKey;
    }

    public void setFileKey(String fileKey) {
        this.fileKey = fileKey;
    }

    public File getFile() {
        if (getSaveDirectory() == null || getFileName() == null) {
            return null;
        } else {
            setRelativeSavePath("/" + getFileName());
            return new File(getSaveDirectory() + getRelativeSavePath());
        }
    }

}
