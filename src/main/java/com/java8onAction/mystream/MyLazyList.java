package com.java8onAction.mystream;

import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-03-18 10:42
 **/
public class MyLazyList<T> implements MyList<T> {
    final T head;

    final Supplier<MyList<T>> tail;

    public MyLazyList(T head, Supplier<MyList<T>> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public T head() {
        return this.head;
    }

    @Override
    public MyList<T> tail() {
        return tail.get();
    }


}