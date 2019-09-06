package com.note.myConcurrent;

/**
 * @Classname MyInterrupt
 * @Date 2019-08-07 14:13
 * @Created by chenpan
 * @Description 中断测试
 */
public class MyInterrupt {
    public static void main(String args[])
            throws InterruptedException {
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };
        Thread out_before_does = new Thread(() ->{
                System.out.println("out before Does");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        for (int i = 0; i < importantInfo.length; i++) {
            //Pause for 4 seconds
            try {

                if (importantInfo[i].contains("Little")) {
                    Thread.currentThread().interrupt();
                }
                if (importantInfo[i].contains("Does")) {
                    System.out.println("is dose");
                    out_before_does.start();
                    out_before_does.join();
                }
                System.out.println(Thread.interrupted());
                Thread.sleep(4000);

            } catch (InterruptedException e) {
                return;
            }
            //Print a message
            System.out.println(importantInfo[i]);
        }

    }

   static class JoinThread implements Runnable {
        @Override
        public void run() {

        }
    }

}
