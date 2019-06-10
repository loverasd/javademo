package com.note.design_patterns.proxy.dynamicProxy;

/**
 * @Classname DBOperator
 * @Description TODO
 * @Date 2019/6/10 17:56
 * @Created by x1c
 */
public class DBOperator implements IDBOperator {
    public DBOperator() {
        try {
            Thread.sleep(1000); //模拟连接数据库的耗时操作
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void request() throws InterruptedException {
        System.out.println("get data ...");
    }
}
