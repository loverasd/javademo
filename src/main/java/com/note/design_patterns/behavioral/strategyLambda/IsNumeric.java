package com.note.design_patterns.behavioral.strategyLambda;

/**
 * @program: javademo
 * @description: 是否全数字
 * @author: chenp
 * @create: 2019-01-22 16:39
 **/
public class IsNumeric implements ValidationStrategy {
    @Override
    public boolean execute(String s) {

        return s.matches("\\d+");
    }
}