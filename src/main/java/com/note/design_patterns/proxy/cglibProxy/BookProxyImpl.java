package com.note.design_patterns.proxy.cglibProxy;

/**
 * @Classname BookProxyImpl
 * @Description 实现类
 * @Date 2019/6/10 20:02
 * @Created by x1c
 */
public class BookProxyImpl implements BookProxy {
    @Override
    public void addBook() {
        System.out.println("add book ...");
    }
}
