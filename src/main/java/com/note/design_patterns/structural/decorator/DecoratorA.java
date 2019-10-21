package com.note.design_patterns.structural.decorator;

import java.util.Objects;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-12-24 11:06
 **/
public class DecoratorA extends Decorator {
    private Component component;
    public DecoratorA(Component component){
        this.component = component;
    }

    @Override
    public void mA() {

    }

    @Override
    public void mB() {

    }

    public static void main(String[] args) {
        String s= "123";
        String s1="321";
        int a = Objects.hashCode(s);
        System.out.println(Integer.toBinaryString(a));
        int b = Objects.hashCode(s1);
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(a ^ b));


    }
}