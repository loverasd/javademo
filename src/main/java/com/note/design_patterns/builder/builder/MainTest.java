package com.note.design_patterns.builder.builder;

import com.note.design_patterns.builder.builder.product.product.WarHorse;
import com.note.design_patterns.builder.builder1.Computer;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-01-03 15:42
 **/
public class MainTest {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
//        Director director = new Director();

//        director.construct(builder);
//        Director director = new Director(builder);
//        director.construct();
        WarHorse warHorse = builder.getWarHorse();
        System.out.println(warHorse.toString());
        Computer.ComputerBuilder computerBuilder = new Computer.ComputerBuilder();
        computerBuilder.setCpu("asdsada")
                .setMainBoard("jianpan");


    }
}