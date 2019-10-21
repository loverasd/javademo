package com.note.design_patterns.creational.factory.factoryMethod.concreteFactory;

import com.note.design_patterns.creational.factory.factoryMethod.AbstractFactory;
import com.note.design_patterns.creational.factory.factoryMethod.Horse;
import com.note.design_patterns.creational.factory.factoryMethod.horse.DiLuHorse;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-01-02 18:51
 **/
public class DiluFactory implements AbstractFactory {
    @Override
    public Horse create() {
        return new DiLuHorse();
    }
}