package com.note.design_patterns.structural.decoratorBeverage;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-12-23 15:19
 **/
public class HouseBlend extends Beverage {
    double price=1.0;
    public HouseBlend(){
        description = " HouseBend $"+price;
    }
    @Override
    public Double cost() {
        return price;
    }
}