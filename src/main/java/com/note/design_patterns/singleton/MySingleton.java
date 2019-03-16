package com.note.design_patterns.singleton;

import com.note.lambda.lambda.apple.Apple;

/**
 * @program: javademo
 * @description: 单例模式
 * @author: chenp
 * @create: 2019-03-12 17:17
 **/
public class MySingleton {

    private MySingleton() {
    }
    private static final MySingleton mySingleton = new MySingleton();
    public static MySingleton getInstance(){
        return mySingleton;
    }

}