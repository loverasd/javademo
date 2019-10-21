package com.note.design_patterns.structural.proxy.dynamicProxy;

import java.util.ArrayList;

/**
 * @Classname IDBOperator
 * @Description TODO
 * @Date 2019/6/10 17:56
 * @Created by x1c
 */
public interface IDBOperator {

    ArrayList<Object> request() throws InterruptedException;

}
