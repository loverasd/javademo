package com.java8onAction.mystream;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-03-18 10:39
 **/
public class Empty<T> implements MyList<T> {
    public T head() {
        throw new UnsupportedOperationException();
    }
    public MyList<T> tail() {
        throw new UnsupportedOperationException();
    }
}