package com.note.myConcurrent;

import java.util.HashMap;

/**
 * @Classname GuardedBlocks
 * @Date 2019-08-12 10:49
 * @Created by chenpan
 * @Description 测试 。wait
 */
public class GuardedBlocks {
    boolean joy =false;
    public static void main(String[] args) {

    }

    public void guardedJoy() {
        // Simple loop guard. Wastes
        // processor time. Don't do this!
        // 简单的循环示例，浪费处理器时间，不要这样做。⚠️
        while(!joy) {}
        System.out.println("Joy has been achieved!");
        HashMap<String, String> stringStringHashMap = new HashMap<>();

    }

    public synchronized void guardedJoy1() {//wait的调用需要 内部锁 eg: b.wait() 需要b 的内部锁，
                                            // 而在在同步方法里是获取内部锁的最快捷的方式
        // This guard only loops once for each special event, which may not
        // be the event we're waiting for.
        //需要为特殊的事件执行一次，尽管该事件不是我们要等的事件
        while(!joy) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        System.out.println("Joy and efficiency have been achieved!");
    }
    public synchronized void notifyJoy() {
        joy = true;
        notifyAll();
    }

}
