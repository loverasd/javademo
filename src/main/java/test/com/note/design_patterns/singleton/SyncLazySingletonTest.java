package test.com.note.design_patterns.singleton;

import com.note.design_patterns.singleton.SyncLazySingleton;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

/**
 * SyncLazySingleton Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>三月 25, 2019</pre>
 */
public class SyncLazySingletonTest {

    @Before
    public void before() throws Exception {
        System.out.println("before -------------");
    }

    @After
    public void after() throws Exception {
        System.out.println("after ---------------");
    }

    /**
     * Method: getInstance()
     */
    @Test
    public void testGetInstance() throws Exception {
//TODO: Test goes here...

        int count = 100;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(() -> System.out.println(LocalDateTime.now() + ":" + SyncLazySingleton.getInstance())).start();
            countDownLatch.countDown();
        }

        try {
            //使线程在锁存器倒计数至零之前一直等待
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



} 
