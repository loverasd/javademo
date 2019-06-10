package com.note.design_patterns.proxy.dynamicProxy;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @Classname TestProxy
 * @Description TODO
 * @Date 2019/6/10 18:00
 * @Created by x1c
 */
public class TestProxy {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
//        IDBOperatorProxy proxy = new IDBOperatorProxy();
        IDBOperator operator = new DBOperator();
        System.out.println("time:" + Duration.between(now, LocalDateTime.now()).toNanos() + "  ns");
        System.out.println("rollback");
    }
}
