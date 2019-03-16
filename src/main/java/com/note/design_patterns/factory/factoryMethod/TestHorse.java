package com.note.design_patterns.factory.factoryMethod;

import com.note.design_patterns.factory.factoryMethod.concreteFactory.DiluFactory;
import com.note.design_patterns.factory.factoryMethod.concreteFactory.JueYingHorseFactory;
import com.note.design_patterns.factory.factoryMethod.horse.DiLuHorse;
import com.note.design_patterns.factory.factoryMethod.horse.JueYingHorse;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-01-02 15:02
 **/
public class TestHorse {
    public static void main(String[] args) {

        AbstractFactory factory = new DiluFactory();

        Horse horse = factory.create();
        horse.desc();
        List<? extends Horse> list = new ArrayList<>();
        System.out.println(list.get(0));
    }
}