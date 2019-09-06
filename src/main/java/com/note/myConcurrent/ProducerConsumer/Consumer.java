package com.note.myConcurrent.ProducerConsumer;

/**
 * @Classname Consumer
 * @Date 2019-08-12 15:39
 * @Created by chenpan
 * @Description 消费类
 */
public class Consumer implements Runnable{
    private Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        String msg;
        while (!(msg = drop.take()).equalsIgnoreCase("DONE")) {
            System.out.println(msg);
        }
    }
}
