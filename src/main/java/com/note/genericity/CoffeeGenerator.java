package com.note.genericity;

import com.note.domain.*;
import com.note.myutil.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * @program: javademo
 * @description: 咖啡生成器
 * @author: chenp
 * @create: 2018-08-30 15:40
 **/
public class CoffeeGenerator implements Generator<Coffee>,Iterable<Coffee> {
    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class,Breve.class};
    private static Random rand = new Random(47);
    //for iteration
    private int size = 0;

    public CoffeeGenerator() {
    }

    public CoffeeGenerator(int sz) { size = sz;}

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
    class CoffeeIterator implements Iterator<Coffee>{
        int count = size;
        public boolean hasNext() { return count > 0;}

        @Override
        public Coffee next() {
            count-- ;
            return CoffeeGenerator.this.next();
        }

        @Override
        public void remove() { //Not implemented
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator generator = new CoffeeGenerator();
        for (int i=0; i<5; i++){
            System.out.print(generator.next()+" ");
        }
        for (Coffee c: new CoffeeGenerator(5)){
            System.out.println(c);
        }
    }
}