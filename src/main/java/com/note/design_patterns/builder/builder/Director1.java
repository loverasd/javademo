package com.note.design_patterns.builder.builder;

/**
 * @program: javademo
 * @description: 主管/导演
 * @author: chenp
 * @create: 2019-01-03 11:49
 **/
public abstract class Director1 extends Builder1{
    Builder1 builder;
    public Director1(Builder1 builder){
        this.builder = builder;
    }

    final public void construct(){
        builder.buildHorse();
        builder.buildSaddle();
        builder.buildHorseshoe();
        builder.buildBridle();
        checked();
    }
    public void construct1(){
        buildHorse();
        buildSaddle();
        buildHorseshoe();
        buildBridle();
        checked();
    }
    public abstract void checked();
}