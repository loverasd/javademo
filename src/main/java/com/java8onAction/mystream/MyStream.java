package com.java8onAction.mystream;

import java.util.function.Predicate;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-03-18 11:02
 **/
public class MyStream {
    public static MyLazyList<Integer> from(int n) {
        return new MyLazyList<Integer>(n, () -> from(n + 1));
    }

    /**
     * 判断是否为质数
     *
     * @param list
     * @return
     */
//    public static MyList<Integer> primes(MyList<Integer> list) {
//        return new MyLazyList<>(
//                list.head(),
//                () -> primes(list.tail()
//                        .filter(n -> n % list.head() != 0)
//                )
//        );
//    }
    public static MyList<Integer> primes(MyList<Integer> numbers) {
        return new MyLazyList<>(
                numbers.head(),
                () -> primes(
                        numbers.tail()
                                .filter(n -> n % numbers.head() != 0)
                )
        );
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>(10, new MyLinkedList<>(20, new Empty<>()));
        System.out.println(myLinkedList.head);
        System.out.println(myLinkedList.tail().head());
        MyLazyList<Integer> from = from(2);
        Integer head1 = primes(from).head();
        Integer head2 = primes(from).tail().head();
        Integer head3 = primes(from).tail().tail().head();
        System.out.println(head1 + ":" + head2 + ":" + head3);
        System.out.println(from.head);
        System.out.println(from.tail().head());
    }
}