package com.note.url;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Base64;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-11-16 19:02
 **/
public class TestURL {
    public static void main(String[] args) throws Exception {
        String url = "http://124.127.206.202:7602/ePolicyServices/insurancePolicyController.do?downFiles=key&companyNo=HNIC&pkid=86c0d955-edc2-48ad-b17b-6592408bb4c5&type=0&sercet=e332bb4a9cba4b778648b166b1acc024";
        String url1 = "http://172.20.241.98:7602/ePolicyServices/insurancePolicyController.do?downFiles=key&companyNo=HNIC&pkid=a8fcaee3ecc54ecc945d301a6d3e3e88&type=0&sercet=ea3e284ed3004683ac3c7edc117febed";

        getFile(url1);
        String fileName = getFileName(url1);
        String s = downloadEncoder(url);
        String[] split = s.split(",");
        System.out.println(split[0]);
        System.out.println(split[1]);
    }

    public static void getFile(String url1) throws Exception {
        CloseableHttpClient httpClient = null;
        HttpResponse res = null;

        try {

            httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url1);
            res = httpClient.execute(httpPost);

            Header[] allHeaders = res.getAllHeaders();
            String fileName = null;
            for (Header header : allHeaders) {
                if (header.getName().equals("Content-Disposition")) {
                    String[] split = header.getValue().split("=");
                    fileName = split[1];
                }
            }
            System.out.println(fileName);
           /* if (fileName == null) {
                throw new Exception("文件获取失败");
            }

            fileOutputStream = new FileOutputStream(new File("E:\\" + fileName));

            HttpEntity entity = res.getEntity();
            content = entity.getContent();
            byte[] bytes = readInputStream(content);
            fileOutputStream.write(bytes);
            fileOutputStream.flush();*/


//
//            fileOutputStream.write(content.readAllBytes());
//            fileOutputStream.flush();


// error
//            fileOutputStream.flush();
//            byte[] a = new byte[10240];
//
//            while ( content.read(a) != -1) {
//                fileOutputStream.write(a);
//                fileOutputStream.flush();
//                a = new byte[10240];
//            }
//            fileOutputStream.flush();


        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            httpClient.close();
            ((CloseableHttpResponse) res).close();
        }

    }

    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

    public static String getFileName(String url) throws Exception {
        String fileName = "";
        CloseableHttpClient httpClient = null;
        HttpResponse res = null;
        try {
            httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            res = httpClient.execute(httpPost);

            Header[] allHeaders = res.getAllHeaders();
            for (Header header : allHeaders) {
                if (header.getName().equals("Content-Disposition")) {
                    String[] split = header.getValue().split("=");
                    fileName = split[1];
                }
            }
            if (fileName == null) {
                throw new Exception("文件获取失败");
            }
            return fileName;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {

            httpClient.close();
            ((CloseableHttpResponse) res).close();
        }
    }

    public static String downloadEncoder(String url) throws Exception {
        String fileName = "";
        InputStream content = null;
        CloseableHttpClient httpClient = null;
        HttpResponse res = null;
        try {
            httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            res = httpClient.execute(httpPost);

            Header[] allHeaders = res.getAllHeaders();
            for (Header header : allHeaders) {
                if (header.getName().equals("Content-Disposition")) {
                    String[] split = header.getValue().split("=");
                    fileName = split[1];
                }
            }
            if (fileName == null) {
                throw new Exception("文件获取失败");
            }
            content = res.getEntity().getContent();

            byte[] bytes = readInputStream(content);

            File savePath = new File("E:\\"  + fileName);
            OutputStream out = new FileOutputStream(savePath);
            //写入文件
            out.write(bytes);
            //返回base64文件编码的字符串
            String string = Base64.getEncoder().encodeToString(bytes);
            return fileName + "," + string;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            content.close();
            httpClient.close();
            ((CloseableHttpResponse) res).close();
        }

    }
}
