package com.example.demo.dao;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * @program: javademo
 * @description: 遍历properties
 * @author: chenp
 * @create: 2018-08-27 11:01
 **/
public class ShowProperties {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\document\\jvm.properties");

        //OutputStream outputStream = new FileOutputStream(file);

        //System.getProperties().store(outputStream,"Comment");//文件
        String str =    "录";
        System.out.println(Charset.defaultCharset());
        String s = new String(str.getBytes("utf-8"), "utf-8");

        System.out.println(s);
    }

    /**
     * @param properties
     */
    private static void showKeys(Properties properties) {
        Enumeration<?> enu = properties.propertyNames();
        while (enu.hasMoreElements()) {
            Object key = enu.nextElement();
            System.out.println(key);
        }
    }

    /**
     * @param properties
     */
    private static void showValues(Properties properties) {
        Enumeration<Object> enu = properties.elements();
        while (enu.hasMoreElements()) {
            Object value = enu.nextElement();
            System.out.println(value);
        }
    }

    /**
     * @param properties
     */
    private static void showKeysAndValues(Properties properties) {
        Iterator<Map.Entry<Object, Object>> it = properties.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Object, Object> entry = it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("key   :" + key);
            System.out.println("value :" + value);
            System.out.println("---------------");
        }
    }

}