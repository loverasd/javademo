package com.note.myregix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-09-27 18:23
 **/
public class Test2 {
    public static void main(String[] args) {
//        String s = "1231,12301,06,057,";
//        String s1 = s.replaceAll(",$", "");
        ArrayList a = new ArrayList(10);
        String s2[] = new String[]{
                "01", "02", "03", "04", "05", "06", "07"
        };
        List<String> strings = Arrays.asList(s2);
        StringBuilder stringBuilder = new StringBuilder();
        strings.parallelStream().forEach(x -> {
            stringBuilder.append("'" + x + "',");
        });
        System.out.println(stringBuilder.toString());
//        System.out.println(s1);
        String s = stringBuilder.toString().replaceAll(",$", "");
        System.out.println(

        );
    }
}