package com.note.design_patterns.decorator;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-12-23 14:53
 **/
public class ConcreatComponent implements Component {

    @Override
    public void mA() {
        System.out.println("I'm A");
    }

    @Override
    public void mB() {
        System.out.println("I'm B");
    }
}