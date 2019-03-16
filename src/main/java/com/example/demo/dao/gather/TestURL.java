package com.example.demo.dao.gather;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

/**
 * @program: javademo
 * @description: this is url 处理
 * @author: chenp
 * @create: 2018-08-25 20:21
 **/
public class TestURL {
    public static void main(String[] args) {

    }
    public StringBuilder getContent(String domainName) throws Exception {
        StringBuilder document= new StringBuilder();

        URL url = new URL(domainName);
        URLConnection conn = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = null;
        while ((line = reader.readLine()) != null){
            document.append(line);
        }
        return document;
    }
    @Test
    public void test1(){
        String a ="刘";
        byte[] bs = a.getBytes();
        for (int i=0; i<bs.length;i++){
            System.out.println(Integer.toBinaryString(bs[i]));
        }
        char c = 'a';

    }
    @Test
    public void test2(){
        System.getProperty("file.encoding");
        Properties p =System.getProperties();
    }



}