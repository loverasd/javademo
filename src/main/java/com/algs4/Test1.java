package com.algs4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: javademo
 * @description: algs4标准库 StdIn StdOut StdDraw StdRandom StdStats In Out
 * @author: chenp
 * @create: 2018-09-25 19:49
 **/
public class Test1 {
    public static void main(String[] args) {
        String str = "1、你好，2、你是谁，3、你吃过西瓜、苹果、鸡蛋吗？";
        String str1 = "1、Q231312312412、Qqewqweq、你好啊";
        String str3 = "1、几月及2、你是谁";
        String s = str.replaceAll("、", ".");
        String s1 = str3.replaceAll("(?<=\\d)、",".");
        System.out.println(s1);
    }

    public String replaceStr(String str){
        return null;
    }

}