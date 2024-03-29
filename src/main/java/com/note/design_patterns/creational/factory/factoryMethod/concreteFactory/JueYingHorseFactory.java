package com.note.design_patterns.creational.factory.factoryMethod.concreteFactory;


import com.note.design_patterns.creational.factory.factoryMethod.AbstractFactory;
import com.note.design_patterns.creational.factory.factoryMethod.Horse;
import com.note.design_patterns.creational.factory.factoryMethod.horse.JueYingHorse;

/**
 * @program: javademo
 * @description: 绝影工厂
 * @author: chenp
 * @create: 2019-01-02 14:53
 **/
public class JueYingHorseFactory implements AbstractFactory {

    @Override
    public Horse create() {
        return  new JueYingHorse();
    }
}