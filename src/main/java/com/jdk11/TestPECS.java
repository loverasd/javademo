package com.jdk11;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: javademo
 * @description: PECS 原则 测试类
 * @author: chenp
 * @create: 2019-03-27 16:35
 **/

public class TestPECS {
    static class Food {}
    static class Fruit extends Food {}
    static class Apple extends Fruit {}

    /**
     *
     *              Food
     *              /  \
     *          fruit
     *            /
     *          apple
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
//






























































































































//        Fruit object = fruits.get(0);    // compile success
//
//        List<? super Fruit> fruits = new ArrayList<>();
//        fruits.add(new Food());     // compile error
//        fruits.add(new Fruit());    // compile success
//        fruits.add(new Apple());    // compile success
//
//        fruits = new ArrayList<Fruit>(); // compile success
//        fruits = new ArrayList<Apple>(); // compile error
//        fruits = new ArrayList<Food>(); // compile success
//        fruits = new ArrayList<? super Fruit>(); // compile error: 通配符类型无法实例化
//
//        Fruit object = fruits.get(0); // compile error
    }
}