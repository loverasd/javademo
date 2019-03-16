package com.note.lambda.lambda;

import java.io.File;
import java.io.IOException;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @program: javademo
 * @description: lambda simple test
 * @author: chenp
 * @create: 2018-09-13 10:03
 **/
public class Test1 {
    public static void main(String[] args) throws IOException {
        /**
         * () -> 5 //不需要参数，返回值5
         * x  -> 2*x
         * (x,y) -> x-y
         * (int x , int y) -> x+y
         * (String x) -> System.out.print(s)
         */
        System.out.println((byte)'a');//97+26
        System.out.println((byte)'A');//65
        System.out.println((char)122);
        char[] chars = new char[123];
        int j=0;
        for (byte i=65; i<123; i++){
            chars[j++] = (char) i;
        }
        Stream<Integer> integerStream = Stream.of(1,2,3,4);
        Stream<String> stringStream = Stream.of("taobao");
        /**
         * 三条语句的作用都是一样的，只是使用了lambda表达式和方法引用的语法来简化代码。
         * 每条语句其实都是生成一个无限长度的Stream，其中值是随机的。这个无限长度Stream是懒加载，
         * 一般这种无限长度的Stream都会配合Stream的limit()方法来用
         */
        Stream.generate(new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random()*100;
            }
        });
        Stream.generate(()->Math.random());
        Stream.generate(Math::random);
        /**
         *iterate方法：也是生成无限长度的Stream，和generator不同的是，
         * 其元素的生成是重复对给定的种子值(seed)调用用户指定函数来生成的。
         * 其中包含的元素可以认为是：seed，f(seed),f(f(seed))无限循环
         */
        Stream.iterate(1,item->item+1).limit(10).forEach(System.out::println);
        File file = new File("");
        file.createNewFile();

    }
}