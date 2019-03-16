package com.concurrent.synchtest;

/**
 * @program: javademo
 * @description: 线程安全的可变整数
 * @author: chenp
 * @create: 2018-10-29 20:55
 **/
public class SynchronizedInteger {
    private  int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }
}