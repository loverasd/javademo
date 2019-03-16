package com.note.design_patterns.decoratorBeverage;

/**
 * @program: javademo
 * @description: 淡
 * @author: chenp
 * @create: 2018-12-23 15:48
 **/
public class Whip extends CondimentDecorator {
    Double whipPrice = 0.8;
    Beverage beverage;
    public Whip(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+",Whip $"+whipPrice;
    }

    @Override
    public Double cost() {
        return beverage.cost()+whipPrice;
    }
}