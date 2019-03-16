package com.note.domain;

/**
 * @program: javademo
 * @description: 实体类
 * @author: chenp
 * @create: 2018-08-30 15:31
 **/
public class Coffee {
    public static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName()+" "+ id;
    }

}