package com.work.delayedExceter;

import java.util.concurrent.*;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-02-25 17:56
 **/
public class MyDelayedExecutor {
    static final class DelayedExecutor implements Executor {
        final long delay;
        final TimeUnit unit;
        final Executor executor;
        DelayedExecutor(long delay, TimeUnit unit, Executor executor) {
            this.delay = delay; this.unit = unit; this.executor = executor;
        }
        public void execute(Runnable r) {
            MyDelayedExecutor.Delayer.delay(new MyDelayedExecutor.TaskSubmitter(executor, r), delay, unit);
        }
    }
    /**
     * Singleton delay scheduler, used only for starting and
     * cancelling tasks.
     */
    static final class Delayer {
        static ScheduledFuture<?> delay(Runnable command, long delay,
                                        TimeUnit unit) {
            return delayer.schedule(command, delay, unit);
        }

        static final class DaemonThreadFactory implements ThreadFactory {
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                t.setName("CompletableFutureDelayScheduler");
                return t;
            }
        }

        static final ScheduledThreadPoolExecutor delayer;
        static {
            (delayer = new ScheduledThreadPoolExecutor(
                    1, new MyDelayedExecutor.Delayer.DaemonThreadFactory())).
                    setRemoveOnCancelPolicy(true);
        }
    }
    /** Action to submit user task */
    static final class TaskSubmitter implements Runnable {
        final Executor executor;
        final Runnable action;
        TaskSubmitter(Executor executor, Runnable action) {
            this.executor = executor;
            this.action = action;
        }
        public void run() { executor.execute(action); }
    }
}