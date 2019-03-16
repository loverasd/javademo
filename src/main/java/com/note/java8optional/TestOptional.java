package com.note.java8optional;

import java.util.Optional;

/**
 * @program: javademo
 * @description: 测试Optional
 * @author: chenp
 * @create: 2019-01-29 08:23
 **/
public class TestOptional {
    public static void main(String[] args) {
        String str = "string is not null";
        //声明空的Optional
        Optional<String> optStr1 = Optional.empty();
        //声明非空的Optional 若 str is null throw NullPointException immediately
        Optional<String> optStr2 = Optional.of(str);
        //创建一个接收 null的 Optional
        Optional<String> is_nullable = Optional.ofNullable("is nullable");
        Double aDouble = is_nullable.map(String::length)
                .map(Math::sqrt)//Optional 里嵌套Optional use flatMap
                .map(Math::abs)
                .orElse(3.00); //若为空设置默认值为 3.00
        System.out.println(aDouble);

    }
}