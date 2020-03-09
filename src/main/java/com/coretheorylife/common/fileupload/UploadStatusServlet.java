package com.coretheorylife.common.fileupload;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * 获取上传进度信息
 *
 * @author connor
 */
public class UploadStatusServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String timestamp = request.getParameter("timestamp");
        System.out.println("UploadStatusServlet获取上传进度信息。。。" + timestamp);
        HttpSession session = request.getSession();
        UploadStatus status = (UploadStatus) session.getAttribute("uploadStatus");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(status);
        if (status != null && status.getBytesRead() == status.getContentLength()) {//下载完成
            session.removeAttribute("uploadStatus");
        }
        PrintWriter out = response.getWriter();
        out.write(jsonStr);
        out.close();
    }
}