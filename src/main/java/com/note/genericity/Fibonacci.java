package com.note.genericity;

import com.note.myutil.Generator;

/**
 * @program: javademo
 * @description: 斐波那契数列生成器
 * @author: chenp
 * @create: 2018-08-31 16:02
 **/
public class Fibonacci implements Generator<Integer> {
    private int i = 0;

    @Override
    public Integer next() {
        return fib(i++);
    }
    private Integer fib(int a){
        if (a == 0 ) return 0;
        if (a<2) return 1;
        return fib(a-2)+fib(a-1);
    }

//    public static void main(String[] args) {
//        Fibonacci fibonacci = new Fibonacci();
//        for (;fibonacci.i<20;){
//    System.out.println(fibonacci.next());
//
//        }
//    }
}