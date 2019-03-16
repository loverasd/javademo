package test1;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-09-07 09:09
 **/
public class Test2 {
    String  s ="\r &nbsp; &nbsp; ，";
    @Test
    public void test(){
        String s = "2、人伤特约：发生保险事故造成人员伤亡的，伤亡人员医疗费用超出《道路交通事故受伤人员临床诊疗指南》和国家基本医疗保险同类医疗费用标准的部分，保险人不负责赔偿。";
        int i = s.length();
        int j = 56;
        String temp ="";
        StringBuilder sb = new StringBuilder();

        while(i > j ){
            sb.append(s.substring(0,j)+"\\r");
            temp = s.substring(j);
            i = temp.length();
        }
        sb.append(temp);
        System.out.println(sb.toString());
    }
    @Test
    public void test2(){
        String s = "a12313112313";
        String[] as = s.split("4");
        System.out.println(as.length);
        System.out.println(as[0].length());
        System.out.println(as[1].length());
    }
    @Test
    public void test3(){
        String  s ="\r &nbsp; &nbsp; ，";
        System.out.println(s.length());
        s.replace("\r &nbsp; &nbsp; ，","，\r &nbsp; &nbsp; ");
        System.out.println(s);
        if (s.contains("，")){
            System.out.println("你好");
        }
    }
    @Test
    public void test4(){
//        splitRows();
    }
    public String splitRows(String str,int rowNums, String lineBreak){
        String s= str;
        StringBuilder sb= new StringBuilder();
        String temp = "";
        int i = s.length();
        int j = rowNums;
        if (i <= j){
            temp = s;
        }
        while (i > j){
            sb.append(s.substring(0,j)+lineBreak);
            temp = s.substring(j);
            i = temp.length();
        }
        str = sb.append(temp).toString();
        System.out.println(s);
        return str;
    }
    @Test
    public void test6(){
        String s="nia,asdada,a,asdadsd,ad,";
        String s1 = s.replaceAll(",$", "");
        System.out.println(s1);
    }
}