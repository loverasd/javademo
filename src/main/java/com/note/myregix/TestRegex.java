package com.note.myregix;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: javademo
 * @description: 正则表达式练习
 * @author: chenp
 * @create: 2018-09-17 18:14
 **/
public class TestRegex {

    @Test
    public void test(){
//        String reg = ".+(?=</span>)";
//        reg="[abc]/i";
//        String str = "<spAn class=\"read-count\" sb ap  a/i ai ci Ai>阅读数：641</span>";
        String str  = "^@\\d.";
        String text = "@123\n@456@789";
        Pattern pattern = Pattern.compile(text);
        Matcher mc = pattern.matcher(str);

        while (mc.find()){
            System.out.print(mc.group()+" ");
        }

    }
}