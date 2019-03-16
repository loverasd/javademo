package com.example.demo.dao;

import java.io.UnsupportedEncodingException;

/**
 * @program: javademo
 * @description: 测试java 编码
 * @author: chenp
 * @create: 2018-08-27 15:39
 **/
public class CharsetTest {
    public CharsetTest() throws UnsupportedEncodingException { }
    String s1 = new String("hello, kitty.中国".getBytes(), "UTF-8");
    String s2 = new String("hello, kitty.中文エキサイト네이버 중국어사전".getBytes(), "ISO-8859-1");
    String s3 = new String("hello, kitty.中文네이버 중국어사전".getBytes(), "GB2312");

    /**
     * 判断字符串的编码
     *
     * @param str
     * @return
     */
    public static String getEncoding(String str) {
        String encode[] = new String[]{
                "UTF-8",
                "ISO-8859-1",
                "GB2312",
                "GBK",
                "GB18030",
                "Big5",
                "Unicode",
                "ASCII"
        };
        for (int i = 0; i < encode.length; i++){
            try {
                if (str.equals(new String(str.getBytes(encode[i]), encode[i]))) {
                    return encode[i];
                }
            } catch (Exception ex) {
            }
        }

        return "";

    }
}