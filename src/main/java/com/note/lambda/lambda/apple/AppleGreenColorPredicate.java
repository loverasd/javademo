package com.note.lambda.lambda.apple;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-01-16 17:19
 **/
public class AppleGreenColorPredicate implements ApplePredicate{
    public boolean test(Apple apple){
        return "green".equals(apple.getColor());
    }

    @Override
    public boolean test(Apple apple, Apple a) {
        return false;
    }
}