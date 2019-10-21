package com.note.design_patterns.creational.singleton;

/**
 * @program: javademo
 * @description: 单例模式1 饿汉式
 * 类加载就初始化，多线程安全
 * @author: chenp
 * @create: 2019-03-12 17:17
 **/
public class MySingleton {

    private MySingleton() {
    }

    private static final MySingleton mySingleton = new MySingleton();

    public static MySingleton getInstance() {
        return mySingleton;
    }

}