package com.coretheorylife.modules.common.service.impl;

import com.coretheorylife.modules.common.service.GetFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

@Service("getFileService")
public class GetFileServiceImpl implements GetFileService {

    @Value("${webUploadPath}")
    String rootUploadPath;

    @Override
    public void doImgPush(HttpServletResponse res, File file , String fileName , String type) throws Exception{
        String realFileName = fileName;
        res.reset();
        res.setContentType("image/jpeg");
        res.setContentType("text/html; charset=UTF-8");
        res.setHeader("Content-disposition",
                "attachment; filename=" + realFileName + "." + type);
        res.addHeader("Content-Length", "" + file.length());
        byte[] buff = new byte[1024];
        BufferedInputStream bis;
        OutputStream os;
        os = res.getOutputStream();
        bis = new BufferedInputStream(new FileInputStream(file));
        int i = bis.read(buff);
        while (i != -1) {
            os.write(buff, 0, buff.length);
            os.flush();
            i = bis.read(buff);
        }
        if (bis != null) {
            bis.close();
        }
        if (os != null) {
            os.close();
        }
        if (bis != null) {
            bis.close();
        }
    }

}
