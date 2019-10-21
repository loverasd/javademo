package com.jdk11_13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @program: javademo
 * @description: try-with-resource 关闭资源
 * @author: chenp
 * @create: 2018-12-29 17:44
 **/
public class TestTryResource {
    public static void main(String[] args) throws IOException {
        String s = readLineFirst("E:\\work\\moban.txt");
        System.out.println(s);
    }

    static String readLineFirst(String path) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String s = br.readLine();
            s.hashCode();
            return s;
        }
    }

}