package com.note.design_patterns.builder.builder;

import com.note.design_patterns.builder.builder.product.product.WarHorse;
import com.note.design_patterns.builder.factory.parts.Bridle;
import com.note.design_patterns.builder.factory.parts.Horse;
import com.note.design_patterns.builder.factory.parts.Horseshoe;
import com.note.design_patterns.builder.factory.parts.Saddle;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-01-03 13:52
 **/
public class ConcreteBuilder1 extends Builder1 {

    private WarHorse warHorse;

    public ConcreteBuilder1( WarHorse warHorse) {
        this.warHorse = warHorse;
    }
    @Override
    public void buildHorse() {
        Horse horse = new Horse();
        horse.setHorseName("绝影");
        horse.setSize("八尺");
        warHorse.setHorse(horse);
        System.out.println("创建马。。。");
    }

    @Override
    public void buildSaddle() {
        Saddle saddle = new Saddle();
        saddle.setColor("棕色");
        saddle.setWeight("20千克");
        warHorse.setSaddle(saddle);
        System.out.println("创建马鞍。。。");
    }

    @Override
    public void buildBridle() {
        Bridle bridle = new Bridle();
        bridle.setLength(2.00);
        bridle.setMaterial("麻绳编织而成");
        warHorse.setBridle(bridle);
        System.out.println("创建辔头。。。");
    }

    @Override
    public void buildHorseshoe() {
        Horseshoe horseshoe = new Horseshoe();
        horseshoe.setMaterial("玄铁");
        horseshoe.setSize(32.00);
        warHorse.setHorseshoe(horseshoe);
        System.out.println("创建马蹄铁。。。");
    }

    @Override
    public WarHorse getWarHorse() {

        return warHorse;
    }

    public void checked() {

    }
}