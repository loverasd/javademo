package com.note.myregix;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-09-29 10:49
 **/
public class Test4 {
    public static void main(String[] args) {
        System.out.println("ni 1hao hao");
        String str = "ni 1hao hao";
        String s = str.replaceAll("h(?<=1)", "0");
        Pattern p = Pattern.compile("h(?<=1)");
        Matcher matcher = p.matcher(str);
        while (matcher.find()){
            System.out.println(matcher.toString());
        }
        String s1 = matcher.replaceAll("0");

        System.out.println(s);
        System.out.println(s1);
    }
}