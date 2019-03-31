package com.note.design_patterns.singleton;

/**
 * @program: javademo
 * @description: 静态内部类实现单例模式 推荐
 * @author: chenp
 * @create: 2019-03-25 13:02
 **/
public class StaticInnerLClass {
    private StaticInnerLClass(){

    }
    private static class Inner{
        private static final StaticInnerLClass instance = new StaticInnerLClass();
    }
    public StaticInnerLClass getInstance(){
        return Inner.instance;
    }
}