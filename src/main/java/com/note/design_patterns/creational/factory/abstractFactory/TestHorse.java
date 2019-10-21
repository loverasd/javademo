package com.note.design_patterns.creational.factory.abstractFactory;

import com.note.design_patterns.creational.factory.abstractFactory.concreteFactory.JueYingSaddleFactory;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-01-02 15:02
 **/
public class TestHorse {
    public static void main(String[] args) {
        AbstractFactory factory = new JueYingSaddleFactory();
        factory.createHorse().desc();
        factory.createSaddle().color();
    }
}