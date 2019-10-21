package com.note.design_patterns.creational.factory.factoryMethod.horse;

import com.note.design_patterns.creational.factory.factoryMethod.Horse;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-01-02 10:21
 **/
public class JueYingHorse implements Horse {
    @Override
    public void desc() {
        System.out.println("绝影马，曹操所用");
    }
}