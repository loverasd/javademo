package com.note.design_patterns.strategyLambda;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-01-22 16:48
 **/
public class Test {
    public static void main(String[] args) {
        String s="1231231321";
        Validator v = new Validator(new IsNumeric());
        boolean validate = v.validate(s);
        //lambda 添加
        Validator v2 = new Validator(a->a.matches("//d+"));
        boolean validate1 = v2.validate(s);
        System.out.println(validate);
        System.out.println(validate1);
    }
}