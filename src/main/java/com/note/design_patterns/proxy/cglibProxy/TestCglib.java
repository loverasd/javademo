package com.note.design_patterns.proxy.cglibProxy;

/**
 * @Classname TestCglib
 * @Description TODO
 * @Date 2019/6/10 20:11
 * @Created by x1c
 */
public class TestCglib {
    public static void main(String[] args) {
        BookProxyLib cglib = new BookProxyLib();
        BookProxyImpl instance = (BookProxyImpl)cglib.getInstance(new BookProxyImpl());
        instance.addBook();
    }
}
