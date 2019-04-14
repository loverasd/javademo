package com.java8onAction.mystream;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-03-18 10:31
 **/
public class MyLinkedList<T> implements MyList<T> {
    T head;
    MyList<T> tail;

    public MyLinkedList(T head, MyList<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public T head() {
        return this.head;
    }

    @Override
    public MyList<T> tail() {
        return this.tail;
    }

    public boolean isEmpty(){
        return false;
    }
}