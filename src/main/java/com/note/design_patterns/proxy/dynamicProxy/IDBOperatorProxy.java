package com.note.design_patterns.proxy.dynamicProxy;

/**
 * @Classname IDBOperatorProxy
 * @Description TODO
 * @Date 2019/6/10 17:59
 * @Created by x1c
 */
public class IDBOperatorProxy implements IDBOperator {
    IDBOperator operator = null;
    @Override
    public void request() throws InterruptedException {
        if (operator == null){
            operator = new DBOperator();
            operator.request();
        }
    }
}
