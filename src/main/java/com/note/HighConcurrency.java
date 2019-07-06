package com.note;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: javademo
 * @description: 高并发，模拟惊群效应
 * @author: chenp
 * @create: 2018-09-20 11:21
 **/
public class HighConcurrency {



    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:MM:ss")));
        System.out.println(Clock.system(ZoneId.systemDefault()).instant());
    }
    @Test
    public void test(){
        String str = "1、  保险人将依法报送上述信息到税务机关，"
                + "根据税收法的有关规定，投保人应当确定此部分信息的真实性，如有信息填写错误或虚假，须自行承担由此引起的相关责任！"
                + "如需保险人开具增值税专用发票，投保人应提供带有统一社会信用代码的营业执照或税务登记证证明一般纳税人身份，并应为保险人开具红字发票或作废发票提供必要的支持!"
                + "2、本保险合同中包含免除保险人责任的条款，请投保人认真阅读。3、本保险合同由保险条款、投保单、保险单、批单和特别约定组成。1 4 、x保险合 ";
        Pattern p = Pattern.compile("");//"(\\s*\\d\\s*、\\s*)(?<=[^(\\u4e00-\\u9fa5|\\d)])\\s*"
        Pattern p1 = Pattern.compile("\\d、");
        Pattern p2 = Pattern.compile("");
        Matcher m = p.matcher(str);
        int i=0;
        while (m.find()){
            m.group();
            System.out.println(m.group());
            i++;
        }
        System.out.println(i);
//        System.out.println(""+(i+1)+"、");
    }
    @Test
    public void test1(){
        Pattern pattern = Pattern.compile("ab(?=[A-Z])");
        Matcher matcher=pattern.matcher("abZW863");
        if(matcher.find()){
            System.out.println(matcher.group());
        }
    }
    @Test
    public void test2(){
        Pattern pattern = Pattern.compile("industr(?:y|ies)a");
        Matcher matcher=pattern.matcher("industries industrya industries industr1 abZW863");
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
    @Test
    public void test3(){
        Pattern pattern = Pattern.compile("industr(?=y|ies)iesa");
        Matcher matcher=pattern.matcher("industriesa industryindustries ");
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
    @Test
    public void test4(){
        Pattern pattern = Pattern.compile("i(?<=ies)");
        Matcher matcher=pattern.matcher("iesi industriesa industryindustries iesindustr");

        int i=0;
        while(matcher.find()){
            i++;
            System.out.println(matcher.group());
        }
        System.out.println(i);
    }
}