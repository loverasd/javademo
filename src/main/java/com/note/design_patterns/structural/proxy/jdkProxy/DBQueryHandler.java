package com.note.design_patterns.structural.proxy.jdkProxy;

import com.note.design_patterns.structural.proxy.dynamicProxy.DBOperator;
import com.note.design_patterns.structural.proxy.dynamicProxy.IDBOperator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Classname DBQueryHandler
 * @Description TODO
 * @Date 2019/6/10 19:24
 * @Created by x1c
 */
public class DBQueryHandler implements InvocationHandler {
    IDBOperator operator;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (operator == null) {
            operator = new DBOperator();
        }
        return operator.request();
    }

    public static IDBOperator createProxy() {
        IDBOperator proxy = (IDBOperator) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(), new Class[]{IDBOperator.class}, new DBQueryHandler());
        return proxy;
    }
}
