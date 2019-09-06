package com.note.myConcurrent;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.HOURS;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @Classname MyExecutor
 * @Date 2019-08-13 14:01
 * @Created by chenpan
 * @Description 多线程执行程序
 */
public class MyExecutor {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final ExecutorService executorService = Executors.newFixedThreadPool(1);
    private final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    private final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    private final ExecutorService workStealingPool = Executors.newWorkStealingPool();

    private final Callable<Object> callable= Executors.callable(() -> {
        System.out.println("nihao");
    });

    public void beepForAnHour() {
        Runnable beeper = () -> System.out.println("beep");
        ScheduledFuture<?> beeperHandle =
                scheduler.scheduleAtFixedRate(beeper, 10, 10, SECONDS);
        Runnable canceller = () -> beeperHandle.cancel(false);
        scheduler.schedule(canceller, 1, HOURS);
    }

    public static void main(String[] args) {
        Callable<Object> callable= Executors.callable(() -> {
            System.out.println("nihao");
        });
        new MyExecutor().beepForAnHour();
    }
}
