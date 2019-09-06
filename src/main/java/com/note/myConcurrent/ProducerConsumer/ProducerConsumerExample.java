package com.note.myConcurrent.ProducerConsumer;

/**
 * @Classname ProducerConsumerExample
 * @Date 2019-08-12 15:48
 * @Created by chenpan
 * @Description 生产者消费者测试
 */
public class ProducerConsumerExample {
    public static void main(String[] args) {
        Drop drop = new Drop();

        Thread producer = new Thread(new Producer(drop));
        Thread consumer = new Thread(new Consumer(drop));
        producer.start();
        consumer.start();

    }
}
