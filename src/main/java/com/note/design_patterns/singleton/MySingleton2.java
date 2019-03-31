package com.note.design_patterns.singleton;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

/**
 * @program: javademo
 * @description:    单例模式2 懒汉式
 * 线程不安全，
 * @author: chenp
 * @create: 2019-03-25 08:35
 **/
public class MySingleton2 {
    private static MySingleton2 instance;
    private MySingleton2() {
    }
    public static MySingleton2 getInstance(){
        if (instance ==null){
            return instance = new MySingleton2();
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