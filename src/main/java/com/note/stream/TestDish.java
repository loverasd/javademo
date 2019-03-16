package com.note.stream;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @program: javademo
 * @description: jdk8 stream操作
 * @author: chenp
 * @create: 2018-09-06 10:34
 **/
@Setter
@Getter
public class TestDish {
    public static void main(String[] args) {
        Supplier<List<Dish>> builderStream = Dish::builderStream;
        List<Dish> dishes = builderStream.get();
        List<String> collect = dishes.parallelStream().filter(s -> s.getCalories() > 300)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName).limit(2).collect(Collectors.toList());
        collect.parallelStream().forEach(System.out::println);

        /**
         *  给定两个数字列表，如何返回所有的数对呢？例如，给定列表[1, 2, 3]和列表[3, 4]，应
         * 该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。
         */
        System.out.println("-------------");
        List<Integer> list = Arrays.asList(1,2,3);
        List<Integer> list1 = Arrays.asList(4,5);
        List<int[]> collect1 = list.stream().flatMap(i -> list1.stream().map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        collect1.forEach(s->{
            Arrays.stream(s).forEach(System.out::print);
            System.out.println();
        });
        /**
         * reduce
         */
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
        Integer reduce = numbers.stream().reduce(1, (a, b) -> a * b);
        /**
         * 包含装箱的成本每个integer 会被拆成int基本类型
         */
        Integer reduce1 = numbers.stream().reduce(0, Integer::sum);
        IntStream intStream = dishes.stream().mapToInt(Dish::getCalories);//消除了拆箱成本
        Stream<Integer> boxed = intStream.boxed(); //装箱
        OptionalInt max = dishes.stream().mapToInt(Dish::getCalories).max();
        System.out.println("reduce:"+reduce);
        System.out.println("reduce1:"+reduce1);

        /**
         * 生成勾股数
         */
        Stream<int[]> stream = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
        stream.limit(5).forEach(t-> System.out.println(t[0]+","+t[1]+","+t[2]));
        /**
         * 创建流
         */
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5); //值创建流
        Stream<Object> empty = Stream.empty();
        int[] arrays = {2,3,4,5,6};
        IntStream stream1 = Arrays.stream(arrays);//数组创建流
        //创建文件流
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())){
            lines.flatMap(line->Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }

}