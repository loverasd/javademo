package com.note.design_patterns.factory.abstractFactory.concreteFactory;


import com.note.design_patterns.factory.abstractFactory.AbstractFactory;
import com.note.design_patterns.factory.abstractFactory.Horse;
import com.note.design_patterns.factory.abstractFactory.Saddle;
import com.note.design_patterns.factory.abstractFactory.horse.JueYingHorse;
import com.note.design_patterns.factory.abstractFactory.saddle.GoldSaddle;

/**
 * @program: javademo
 * @description: 绝影高配工厂
 * @author: chenp
 * @create: 2019-01-02 14:53
 **/
public class JueYingSaddleFactory implements AbstractFactory {
    @Override
    public Horse createHorse() {
        return new JueYingHorse();
    }

    @Override
    public Saddle createSaddle() {
        return new GoldSaddle();
    }
}