package com.haomu.app.common.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtil {
    // param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
    public static String get(String url) {
        InputStream in = null;
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("Content-Type","text/plain");
            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36");
            conn.setConnectTimeout(1000 * 5);
            conn.setReadTimeout(1000 * 5);
            conn.connect();
            in = conn.getInputStream();
            return readAll(conn.getInputStream());
        }catch (Exception e){
            System.out.println("发送GET请求出现异常！" + e.getMessage());
        }finally {
            try {
                if(in != null){
                    in.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return "";
    }

    private static String readAll(InputStream in) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[512];
        int len = 0;
        while ((len = in.read(buffer)) != -1)
            outStream.write(buffer, 0, len);
        return outStream.toString("UTF-8");
    }
}
