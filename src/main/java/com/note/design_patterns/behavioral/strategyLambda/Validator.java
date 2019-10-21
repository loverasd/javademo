package com.note.design_patterns.behavioral.strategyLambda;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-01-22 16:41
 **/
public class Validator {
    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }
    public boolean validate(String s){
        return strategy.execute(s);
    }
}