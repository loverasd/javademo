package com.note.queue;

import java.util.concurrent.*;

/**
 * @program: Core_0.1
 * @author: chenp
 * @create: 2018-10-18 15:10
 * @description: 延时执行ftp下载
 **/
public class FTPDownloadTimer implements Delayed {
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


    public FTPDownloadTimer(long delay, String bizNo, String bizType) {
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