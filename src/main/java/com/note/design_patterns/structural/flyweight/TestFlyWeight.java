package com.note.design_patterns.structural.flyweight;

/**
 * @Classname TestFlyWeight
 * @Description TODO
 * @Date 2019/6/15 14:03
 * @Created by x1c
 */
public class TestFlyWeight {
    public static void main(String[] args) {
        String fly = "fly";
        String fly2 = "fly";
        System.out.println(fly == fly2);
        fly.intern();
    }
}
