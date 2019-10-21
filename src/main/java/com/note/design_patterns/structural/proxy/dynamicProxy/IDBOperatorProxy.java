package com.note.design_patterns.structural.proxy.dynamicProxy;

import java.util.ArrayList;

/**
 * @Classname IDBOperatorProxy
 * @Description TODO
 * @Date 2019/6/10 17:59
 * @Created by x1c
 */
public class IDBOperatorProxy implements IDBOperator {
    IDBOperator operator = null;
    @Override
    public ArrayList<Object> request() throws InterruptedException {
        if (operator == null){
            operator = new DBOperator();
            operator.request();
        }
        return null;
    }
}
