package com.note.design_patterns.creational.factory.factoryMethod.concreteFactory;

import com.note.design_patterns.creational.factory.factoryMethod.AbstractFactory;
import com.note.design_patterns.creational.factory.factoryMethod.Horse;
import com.note.design_patterns.creational.factory.factoryMethod.horse.ZhaoHuangFeiDianHorse;

/**
 * @program: javademo
 * @description: 爪黄飞电马
 * @author: chenp
 * @create: 2019-01-02 15:00
 **/
public class ZhaoHuangFeiDianFactory implements AbstractFactory {

    @Override
    public Horse create() {
        return new ZhaoHuangFeiDianHorse();
    }
}