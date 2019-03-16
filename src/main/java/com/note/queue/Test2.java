package com.note.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @program: javademo
 * @author: chenp
 * @create: 2018-10-18 16:40
 * @description:
 **/
public class Test2 {
    public static void main(String[] args) {
        DelayQueue<DelayedElement> delayQueue = new DelayQueue<>();
        producer(delayQueue);

        consumer(delayQueue);
    }
    public static void producer(final DelayQueue<DelayedElement> delayQueue){
        new Thread(()->{
            int i=0;
            while (true){
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                DelayedElement element = new DelayedElement(1000,i+++"test",i+++"");
                delayQueue.put(element);
            }
        }).start();
        /**
         * 每秒打印延迟队列中的对象个数
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("delayQueue size:"+delayQueue.size());
                }
            }
        }).start();
    }
    /**
     * 消费者，从延迟队列中获得数据,进行处理
     * @param delayQueue
     */
    private static void consumer(final DelayQueue<DelayedElement> delayQueue){
        new Thread(()-> {
                while (true){
                    DelayedElement element = null;
                    try {
                        element =  delayQueue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(element.getBizNo());
                    System.out.println(System.currentTimeMillis()+"---"+element);
                }
        }).start();
    }
}



class DelayedElement implements Delayed {

    private final long delay; //延迟时间
    private final long expire;  //到期时间
    private final String bizNo;
    private final String bizType;
    private final long now; //创建时间


    public long getDelay() {
        return delay;
    }

    public String getBizNo() {
        return bizNo;
    }

    public String getBizType() {
        return bizType;
    }


    public DelayedElement(long delay, String bizNo, String bizType) {
        this.delay = delay;
        this.bizNo=bizNo;
        this.bizType=bizType;
        this.expire = System.currentTimeMillis() + delay;    //到期时间 = 当前时间+延迟时间
        this.now = System.currentTimeMillis();
    }

    /**
     * 需要实现的接口，获得延迟时间   用过期时间-当前时间
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.expire - System.currentTimeMillis() , TimeUnit.MILLISECONDS);
    }

    /**
     * 用于延迟队列内部比较排序   当前时间的延迟时间 - 比较对象的延迟时间
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) -o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DelayedElement{");
        sb.append("delay=").append(delay);
        sb.append(", expire=").append(expire);
        sb.append(", now=").append(now);
        sb.append('}');
        return sb.toString();
    }
}