package com.note.threadLocal;

import com.fasterxml.jackson.datatype.jsr310.ser.YearSerializer;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-02-20 16:35
 **/
public class MyThreadLocalTest {
    private static final ThreadLocal<String> LOCAL= new ThreadLocal<>();

    public static void main(String[] args) {
        LOCAL.set("dog");
        System.out.println(LOCAL.get());
    }
}