package com.note.design_patterns.structural.decoratorBeverage;

/**
 * @program: javademo
 * @description: 深焙
 * @author: chenp
 * @create: 2018-12-23 15:20
 **/
public class DarkRoast extends Beverage {
    Double price=2.0;
    public DarkRoast(){
        description = " DarkRoast $"+price;
    }

    @Override
    public Double cost() {
        return price;
    }

}