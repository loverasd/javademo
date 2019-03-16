package com.note.design_patterns.factory.factoryMethod.concreteFactory;

import com.note.design_patterns.factory.factoryMethod.AbstractFactory;
import com.note.design_patterns.factory.factoryMethod.Horse;
import com.note.design_patterns.factory.factoryMethod.horse.DiLuHorse;

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