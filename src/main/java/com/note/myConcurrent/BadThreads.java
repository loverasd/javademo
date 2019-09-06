package com.note.myConcurrent;

import java.util.concurrent.Executors;

/**
 * @Classname BadThreads
 * @Date 2019-08-15 16:25
 * @Created by chenpan
 * @Description 线程误用
 */
public class BadThreads {
    static volatile String  message=null;

    private static class CorrectorThread
            extends Thread {

        public void run() {
            try {
                sleep(1000);
            } catch (InterruptedException e) {}
            // Key statement 1:
            message = "Mares do eat oats.";
        }
    }

    public static void main(String args[])
            throws InterruptedException {
            CorrectorThread correctorThread = new CorrectorThread();

            correctorThread.start();
            message = "Mares do not eat oats.";
            Thread.activeCount();
            Thread.sleep(2000);
            // Key statement 2:
            System.out.println(message);

    }
}
