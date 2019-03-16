package test1;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: javademo
 * @description: 原子类操作
 * @author: chenp
 * @create: 2018-08-26 00:00
 **/
public class Counter {
    private static AtomicInteger num = new AtomicInteger();
    private static CountDownLatch countDownLatch = new CountDownLatch(30);
    public static void main(String[] args) {
         num.set(3);
         new Thread(){
             @Override
             public void run() {
                 super.run();
             }
         };
         for (int i =0; i<30; i++){
             new Thread(()->{
                 for (int j=0; j<10000; j++){
                   num.incrementAndGet();
                 }
             });

         }
        Random random = new Random(34);
        int j=0;
        while (j<6){
            int i = random.nextInt(33);
            System.out.println(i);
            j++;
        }



    }
}