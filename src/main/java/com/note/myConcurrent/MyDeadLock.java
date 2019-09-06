package com.note.myConcurrent;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Classname MyDeadLock
 * @Date 2019-08-08 15:54
 * @Created by chenpan
 * @Description 死锁测试
 */
public class MyDeadLock {
    static class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public synchronized void bow(Friend bower) {//🔒当前对象 this
            System.out.format("%s: %s"
                            + "  has bowed to me!%n",
                    this.name, bower.getName());
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            bower.bowBack(this);//🔒 bower
        }
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                            + " has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        for (int j = 0; j < 6; j++) {
            int i = ThreadLocalRandom.current().nextInt(1, 33);
            System.out.println(i);

        }
        int i = ThreadLocalRandom.current().nextInt(1, 15);
        System.out.println(i);


        final Friend alphonse =
                new Friend("Alphonse");
        final Friend gaston =
                new Friend("Gaston");
        new Thread(() -> alphonse.bow(gaston)).start();
        new Thread(() -> gaston.bow(alphonse)).start();
    }
}
