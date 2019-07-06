package com.note.design_patterns.proxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Classname BookProxyLib
 * @Description TODO
 * @Date 2019/6/10 20:04
 * @Created by x1c
 */
public class BookProxyLib implements MethodInterceptor {
    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //回调方法
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }

    @Override //回调方法
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("事务开始");
        methodProxy.invokeSuper(o,objects);
        System.out.println(methodProxy.getSuperName()+"super name ");
        System.out.println("method:"+method);
        System.out.println("事务结束");
        return null;
    }

}
