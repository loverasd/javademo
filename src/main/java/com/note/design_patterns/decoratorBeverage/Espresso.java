package com.note.design_patterns.decoratorBeverage;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-12-23 15:21
 **/
public class Espresso extends Beverage {
    Double price=3.0;
    public Espresso(){
        description = " Espresso $"+price;
    }

    @Override
    public Double cost() { // Espresso 价格
        return price;
    }

}