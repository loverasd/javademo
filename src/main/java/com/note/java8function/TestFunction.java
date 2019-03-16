package com.note.java8function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @program: javademo
 * @description: java8 测试接口
 * @author: chenp
 * @create: 2019-01-28 14:33
 **/
public class TestFunction {
    public static void main(String[] args) {
        BiConsumer<String,Integer> biConsumer = (a,b)->System.out.println(a+":"+b);
        biConsumer.accept("a",1);
        BiFunction<String ,String,Integer> biFunction = (a,b)->{
            System.out.println(a+":"+b);
            return a.hashCode()+b.hashCode();
        };
        Integer apply = biFunction.apply("a", "b");
        BinaryOperator<String> binaryOperator = (a,b)->{
            System.out.println();
            return "BinaryOperator";
        };
        String apply1 = binaryOperator.apply("a", "b");

    }


}