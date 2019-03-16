package com.note.genericity;

import java.util.Iterator;

/**
 * @program: javademo
 * @description: fabocci适配器
 * @author: chenp
 * @create: 2018-09-01 15:22
 **/
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;
    public IterableFibonacci(int count){ n = count;}
    public  Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };

    }

    public static void main(String[] args) {
        for (int i : new IterableFibonacci(18))
            System.out.print(i+" ");
    }

}