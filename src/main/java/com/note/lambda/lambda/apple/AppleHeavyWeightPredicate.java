package com.note.lambda.lambda.apple;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-01-16 17:17
 **/
public class AppleHeavyWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple){
        return apple.getWeight() > 150;
    }

    @Override
    public boolean test(Apple apple, Apple a) {
        return false;
    }


}