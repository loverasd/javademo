package com.note.rxjava;


import io.reactivex.rxjava3.core.Flowable;

import java.util.HashMap;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-02-20 16:04
 **/
public class Test1 {
    public static void main(String[] args) {
        Flowable.just("hello world").subscribe(System.out::println);
        HashMap<String,String> map = new HashMap<>();
        map.put("1","a");
        map.put("1","b");
    }
}