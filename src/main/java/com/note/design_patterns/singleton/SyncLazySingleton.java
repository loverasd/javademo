package com.note.design_patterns.singleton;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

/**
 * @program: javademo
 * @description: 单例模式2-1 懒汉式 线程安全
 * @author: chenp
 * @create: 2019-03-25 08:41
 **/
public class SyncLazySingleton {
    private volatile static SyncLazySingleton instance = null;//

    private SyncLazySingleton() {

    }
    public static SyncLazySingleton getInstance() {
        if (instance ==null){
            synchronized (new Object()) {
                if (instance == null) {
                    return instance = new SyncLazySingleton();
                }else {
                    return instance;
                }
            }
        }else {
            return instance;
        }
    }

    public static void main(String[] args) {
        int count = 5000;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                try {
                    //使线程在锁存器倒计数至零之前一直等待
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(SyncLazySingleton.getInstance());

            }).start();
            countDownLatch.countDown();
        }
    }
}