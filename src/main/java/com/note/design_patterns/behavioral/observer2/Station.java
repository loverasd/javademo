package com.note.design_patterns.behavioral.observer2;

import java.util.stream.Stream;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-12-19 14:49
 **/
public class Station {
    public static void main(String[] args) {
        Observer observer = new Observer1();
        MyData subject = new MyData(observer);
        subject.makeChange("123123131");
        Stream<String> stringStream = Stream.of("123456789".split(""));
        String s1 = stringStream.filter(s -> s.equals("1")).findFirst().get();
        System.out.println(s1);

    }
}