package com.note.myregix;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public void test() {
//        String reg = ".+(?=</span>)";
//        reg="[abc]/i";
//        String str = "<spAn class=\"read-count\" sb ap  a/i ai ci Ai>阅读数：641</span>";
        String s = "AA1、监管电话:江苏省保险消费投诉电话：4008012378。\n" +
                "2、其他_交强险:特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示。\n" +
                "000shangye000:&nbsp;1、第一受益人特约:本保单第一受益人为：特种车综合商业保险示特种车综合商业保险示特种车综合商业保险示。\n" +
                "2、人伤特约:发生保险事故造成人员伤亡的，伤亡人员医疗费用超出《道路交通事故受伤人员临床诊疗指南》和国家基本医疗保险同类医疗费用标准的部分，保险人不负责赔偿。\n" +
                "3、监管电话:江苏省保险消费投诉电话：4008012378。\n";

        String s1 = s.replaceAll("(?<=(^|:)\\d)、[^:：]*[:：]", "、");
        System.out.println(s1);
//        String str  = "^@\\d.";
//        String text = "@123\n@456@789";
//        Pattern pattern = Pattern.compile(text);
//        Matcher mc = pattern.matcher(str);
//
//
//        while (mc.find()){
//            System.out.print(mc.group()+" ");
//        }

        String filePath = "D:\\Workspaces\\idea-work\\Core-Code-Core\\modules\\webapps\\print\\PrintProduct\\20190702\\F131627802019000003NVEHPOLICY.pdf";
        String yesterday = LocalDate.now().minusDays(1L).format(DateTimeFormatter.BASIC_ISO_DATE);
        File file = new File(filePath);
        String parent = file.getParent();
        parent.lastIndexOf(File.separator);
        String yesPath = parent.substring(0, parent.lastIndexOf(File.separator)) + File.separator + yesterday;
        File file1 = new File(yesPath);
        if (file1.exists())
        System.out.println("s2"+yesPath);
        System.out.println("file:"+parent);

    }
}