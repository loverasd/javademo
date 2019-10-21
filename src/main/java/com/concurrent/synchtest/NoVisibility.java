package com.concurrent.synchtest;

/**
 * @program: javademo
 * @description: 没有内存同步的情况下共享变量,不要这么做
 * @author: chenp
 * @create: 2018-10-29 20:38
 **/
public class NoVisibility {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread{
        public void run(){
            while (!ready) {
                Thread.yield();
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready  =false;
    }
}
