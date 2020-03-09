package com.coretheorylife.common.fileupload;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

/**
 * @author Connor
 */
public class UploadListener implements ProgressListener {

    private UploadStatus status;

    private HttpSession session;

    public UploadListener(UploadStatus status, HttpSession session) {
        this.status = status;
        this.session = session;
    }

    public void update(long bytesRead, long contentLength, int items) {
        status.setBytesRead(bytesRead);
        status.setContentLength(contentLength);
        status.setItems(items);
        session.setAttribute("uploadStatus", status);
        if (bytesRead == contentLength) {
            System.out.println("上传完成,耗时" + (System.currentTimeMillis() - status.getStartTime()) + "毫秒。");
        }
    }
}


