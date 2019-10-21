package com.note.design_patterns.structural.decoratorBeverage;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-12-23 15:47
 **/
public class Mocha extends CondimentDecorator {
    Beverage beverage;
    double mochaPrice = 0.5;
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Mocha $" +mochaPrice;
    }

    @Override
    public Double cost() {
        return mochaPrice + beverage.cost();

    }
}