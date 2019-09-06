package com.note.myConcurrent.ProducerConsumer;

/**
 * @Classname Drop
 * @Date 2019-08-12 11:17
 * @Created by chenpan
 * @Description 共享数据对象
 */
public class Drop {
    // Message sent from producer
    // to consumer. 、生产者发送给消费者的东西
    private String message;
    // True if consumer should wait for producer to send message,
    //      true 消费者应等候生产者发送信息
    // false if producer should wait for consumer to retrieve message.
    //  false 生产者应等候消费者接收信息
    private boolean empty = true;

    public synchronized String take() {
        // Wait until message is
        // available.
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        // Toggle status.
        empty = true;
        // Notify producer that
        // status has changed.
        notifyAll();
        return message;
    }

    public synchronized void put(String message) {
        // Wait until message has
        // been retrieved.
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        // Toggle status.
        empty = false;
        // Store message.
        this.message = message;
        // Notify consumer that status
        // has changed.
        notifyAll();
    }
}
