package com.note.design_patterns.structural.decoratorBeverage;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-12-23 15:45
 **/
public class Milk extends CondimentDecorator {
    Beverage beverage;
    Double milkPrice=0.6;
    public Milk(Beverage beverage ){
        this.beverage= beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+",milk $"+milkPrice;
    }

    @Override
    public Double cost() {
        return beverage.cost()+milkPrice;
    }
}