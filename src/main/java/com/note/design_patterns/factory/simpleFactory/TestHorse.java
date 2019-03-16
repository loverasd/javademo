package com.note.design_patterns.factory.simpleFactory;

/**
 * @program: javademo
 * @description: 测试
 * @author: chenp
 * @create: 2019-01-02 10:47
 **/
public class TestHorse {

    public static void main(String[] args) {
        int type = 2;
        Horse horse = SimpleHorseFactory.createHorse(type);
        horse.desc();
    }
}