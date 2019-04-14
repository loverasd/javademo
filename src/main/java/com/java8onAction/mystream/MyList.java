package com.java8onAction.mystream;

import java.util.function.Predicate;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-03-18 10:28
 **/
public interface MyList<T> {
    T head();

    MyList<T> tail();

    default boolean isEmpty() {
        return true;
    }

//    default MyList<T> filter(Predicate<T> p) {
//
//        return isEmpty() ?
//                this :
//                p.test(head()) ?
//                        new MyLazyList<>(head(), () -> tail().filter(p)) :
//                        tail().filter(p);
//    }
    default MyList<T> filter(Predicate<T> p) {
        return isEmpty() ?
                this :
                p.test(head()) ?
                        new MyLazyList<>(head(), () -> tail().filter(p)) :
                        tail().filter(p);
    }

}