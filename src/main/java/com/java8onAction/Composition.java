package com.java8onAction;

import java.util.function.Function;

/**
 * @program: javademo
 * @description: 函数组合
 * @author: chenp
 * @create: 2019-03-28 19:45
 **/
public class Composition {
    static <A,B,C> Function<A,C> compose(Function<B,C> g , Function<A,B> f){
        return x->g.apply(f.apply(x));
    }
    static <A> Function<A,A> repeat(int n, Function<A,A> f){
        return n == 0 ? x -> x: compose(f,repeat(n-1,f));
    }
    public static void main(String[] args) {
        System.out.println(repeat(1, (Integer x) -> 2 * x).apply(10));
    }
}