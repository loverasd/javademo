package com.note.design_patterns.creational.builder.builder;

/**
 * @program: javademo
 * @description: 主管/导演
 * @author: chenp
 * @create: 2019-01-03 11:49
 **/
public class Director {
    Builder builder;
    public  Director(Builder builder){
        this.builder = builder;
        builder.buildHorse();

        builder.buildSaddle();
        builder.buildHorseshoe();
        builder.buildBridle();
    }

    public void construct(){

        builder.buildHorse();

        builder.buildSaddle();
        builder.buildHorseshoe();
        builder.buildBridle();
    }
}