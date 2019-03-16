package test1;

import java.util.concurrent.RunnableFuture;

/**
 * @program: javademo
 * @description: stream 操作
 * @author: chenp
 * @create: 2018-08-25 21:45
 **/
public class TestStream {
    RunnableFuture runnableFuture = null;
}
class Worker implements  Runnable{

    @Override
    public void run() {
        for (int  i=0; i <10; i++  ){
            System.out.println(i+":"+"nihao，帅哥");
        }
    }
}