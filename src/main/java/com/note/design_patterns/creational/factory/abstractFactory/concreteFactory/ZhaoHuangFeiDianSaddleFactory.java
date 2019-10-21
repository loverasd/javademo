package com.note.design_patterns.creational.factory.abstractFactory.concreteFactory;

import com.note.design_patterns.creational.factory.abstractFactory.AbstractFactory;
import com.note.design_patterns.creational.factory.abstractFactory.Horse;
import com.note.design_patterns.creational.factory.abstractFactory.Saddle;
import com.note.design_patterns.creational.factory.abstractFactory.horse.ZhaoHuangFeiDianHorse;
import com.note.design_patterns.creational.factory.abstractFactory.saddle.XuanTieSaddle;

/**
 * @program: javademo
 * @description: 爪黄飞电马
 * @author: chenp
 * @create: 2019-01-02 15:00
 **/
public class ZhaoHuangFeiDianSaddleFactory implements AbstractFactory {

    @Override
    public Horse createHorse() {
        return new ZhaoHuangFeiDianHorse();
    }

    @Override
    public Saddle createSaddle() {
        return new XuanTieSaddle();
    }
}