package myreflection.service;

import myreflection.model.SiChuanHX;

/**
 * @program: demo
 * @description:
 * @author: chenp
 * @create: 2019-04-19 12:04
 * @company: sinosoft
 **/
public class TestHX {
    public static void main(String[] args) {
        SiChuanHX[] values = SiChuanHX.values();
        for (SiChuanHX s: values){
            System.out.print(s.name());
            System.out.println(":::::"+s.getHxName());
        }
        String a = "1111";
        String b = "2222";

        String c = a;
        a = "aaaa";
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }
}