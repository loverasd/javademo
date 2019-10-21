package com.note.design_patterns.creational.factory.abstractFactory.saddle;

import com.note.design_patterns.creational.factory.abstractFactory.Saddle;

/**
 * @program: javademo
 * @description: 金马鞍
 * @author: chenp
 * @create: 2019-01-02 15:07
 **/
public class GoldSaddle implements Saddle {
    @Override
    public void material() {
        System.out.println("999纯金打造");
    }

    @Override
    public void color() {
        System.out.println("金色。。。。");
    }
}