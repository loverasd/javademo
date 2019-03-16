package com.note;


import org.springframework.data.util.Optionals;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-10-30 09:24
 **/
public class TestOptional {
    static String s = "Publish and subscribe to streams of records, similar to a message queue or enterprise messaging system";

    public static void main(String[] args) {
        String[] ss = s.split(" ");
        //返回一个字符全大写的流
        Stream<Object> any = Arrays.stream(ss).map(String::toUpperCase);
//        any.forEach(s-> System.out.println(s));
        //包含多个流的流  [['P','u','b','l','i','s','h',],['a','n','d',],...,]
        Stream<Stream<Character>> streamStream = Arrays.stream(ss).map(s -> characterStream(s));
        //只包含一个流 ['P','u','b','l','i','s','h','a','n','d']
        Stream<Character> characterStream = Arrays.stream(ss).flatMap(s -> characterStream(s));
        Optional<String> any1 = Arrays.stream(ss).sorted(Comparator.comparing(String::length)).findAny();
        boolean present = any1.isPresent();
        System.out.println(inverse(10).get());
        boolean b = false;

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        //一个流只能用一次
        Map<String, String> collect = locales.collect(Collectors.toMap(
                l -> l.getDisplayLanguage(),
                l -> l.getDisplayLanguage(l),
                (existingValue, newValue) -> existingValue
        ));
        //map集合遍历
//        collect.entrySet().stream().forEach(s-> System.out.println(s));
//        collect.keySet().stream().forEach(s-> System.out.println(s));
//        collect.entrySet().forEach(s-> System.out.print(s.getKey()+" "+s.getValue()) );

//        Map<String, List<Locale>> collect1 =
//                locales.collect(Collectors.groupingBy(Locale::getCountry));

        // locales  流已经被用了，不能再次使用。java.lang.IllegalStateException: stream has already been operated upon or closed
        locales = Stream.of(Locale.getAvailableLocales()); //重新初始化流

        Map<Boolean, List<Locale>> en = locales.collect(Collectors.partitioningBy(l -> l.getLanguage().equals("en")));
        en.get(true).stream().forEach(s -> System.out.println(s));
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7);
        int sum = intStream.map(s -> s * s).sum();

        System.out.println(sum);
        Optional<Integer> num1 = Optional.of(10000);
        System.out.println("==================");
        Optional<Date> date1 = num1.map(t -> new Date(t));
        System.out.println(date1.get());
        Optional<String> optionalString = Optional.of("wo shi shui");
        String optionalA = optionalString.get();
        System.out.println();


    }

    public static Optional<Integer> inverse(Integer integer) {
        return integer == 0 ? Optional.empty() : Optional.of(1 / integer);
    }

    public static Stream<Character> characterStream(String s) {
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray()) {
            result.add(c);
        }
        return result.stream();
    }


    interface A {
        void foo();
    }

    interface B {
        void foo();
    }
}