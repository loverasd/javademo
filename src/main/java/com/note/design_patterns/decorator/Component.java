package com.note.design_patterns.decorator;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-12-23 14:14
 **/
public interface Component {
    default void component(){
        System.out.println("this is Component");
    }
    void mA();
    void mB();

}