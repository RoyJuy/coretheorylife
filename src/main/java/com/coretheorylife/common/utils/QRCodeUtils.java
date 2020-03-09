package com.coretheorylife.common.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Connor
 * 2019年11月20日
 * QR
 */
public class QRCodeUtils {
    private static int width = 200;
    private static int height = 200;
    private static String format = "png";

    public static void create(HttpServletResponse response , String content) throws Exception {
        ServletOutputStream out = response.getOutputStream();
        Map<EncodeHintType,Object> config = new HashMap<>();
        config.put(EncodeHintType.CHARACTER_SET,"UTF-8");
        config.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        config.put(EncodeHintType.MARGIN, 0);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width , height,config);
        MatrixToImageWriter.writeToStream(bitMatrix,format,out);
    }



    public static void download(HttpServletResponse response , String content) throws Exception {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", "qr.png"));
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        response.setContentType("application/octet-stream");

        ServletOutputStream out = response.getOutputStream();
        Map<EncodeHintType,Object> config = new HashMap<>();
        config.put(EncodeHintType.CHARACTER_SET,"UTF-8");
        config.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        config.put(EncodeHintType.MARGIN, 0);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width , height,config);
        MatrixToImageWriter.writeToStream(bitMatrix,format,out);
    }

}
