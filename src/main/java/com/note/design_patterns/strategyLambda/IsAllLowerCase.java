package com.note.design_patterns.strategyLambda;

/**
 * @program: javademo
 * @description: 是否是全小写
 * @author: chenp
 * @create: 2019-01-22 16:38
 **/
public class IsAllLowerCase implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}
