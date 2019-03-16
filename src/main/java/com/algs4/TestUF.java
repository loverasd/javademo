package com.algs4;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: javademo
 * @description: 连通性算法
 * @author: chenp
 * @create: 2018-09-28 17:13
 **/
public class TestUF {

    public static void main(String[] args) {
        int[] a = new int[]{1, 25, 3, 5, 2, 7, 2, 9};

    }

    public static void insert(int[] a) {
        int[] b = new int[a.length];

        for (int i = 0; i < a.length; i++) {

            for (int j = i; j >= 0; j--) {

            }
        }
    }

    @Test
    public void test() {
        List<String> li = new ArrayList<>();
        li.add("123131231E131");
        List<String> e = li.stream().filter(s -> !s.contains("E")).collect(Collectors.toList());
        System.out.println(e.size());
    }
    @Test
    public void testList(){
        List<String> list = new ArrayList<>();
        list.add("1231E");
        list.add("123112");
        list.add("1231");
        list.add("1231E");
//        for (String s : list
//        ) {
//            if (s.contains("E")){
//                list.remove(s);
//            }
//        }
//        if (list.size()==0){
//            System.out.println("ok");
//        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("E")){
                list.remove(i);
            }
        }
        if (list.size() ==0){
            System.out.println("ok");
        }else {
            list.parallelStream().forEach(s-> System.out.println(s));
        }
    }

    @Test
    public void test2(){
        String  path ="E:\\work\\Core-Code-Core\\modules\\component\\com\\sinosoft\\biz\\print\\AllPDFPrint\\impl\\BizPDFPrintServiceImpl.java";
        File file = new File(path);
        try {
            FileInputStream in = new FileInputStream(path);
            FileChannel channel = in.getChannel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}