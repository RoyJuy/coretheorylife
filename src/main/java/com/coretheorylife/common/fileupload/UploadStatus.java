package com.coretheorylife.common.fileupload;

/**
 * @author Connor
 */
public class UploadStatus {

    private long bytesRead;//已上传大小(b)

    private long contentLength;//总大小

    private int items;

    private long startTime = System.currentTimeMillis();//上传开始时间

    public long getBytesRead() {
        return bytesRead;
    }

    public void setBytesRead(long bytesRead) {
        this.bytesRead = bytesRead;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
}


