package com.note.design_patterns.factory.factoryMethod;

import com.note.design_patterns.factory.factoryMethod.concreteFactory.DiluFactory;
import com.note.design_patterns.factory.factoryMethod.concreteFactory.JueYingHorseFactory;
import com.note.design_patterns.factory.factoryMethod.horse.DiLuHorse;
import com.note.design_patterns.factory.factoryMethod.horse.JueYingHorse;
import net.sf.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
        List<? super Horse> list = new ArrayList<>();
        list.add(new DiLuHorse());
        System.out.println(list.get(0));
        Vector vector = new Vector();
        System.out.println(vector.size());
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
        System.out.println(format);
    }
}