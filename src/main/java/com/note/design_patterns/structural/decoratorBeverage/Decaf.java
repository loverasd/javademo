package com.note.design_patterns.structural.decoratorBeverage;

/**
 * @program: javademo
 * @description: 低咖啡因
 * @author: chenp
 * @create: 2018-12-23 15:22
 **/
public class Decaf extends Beverage {
    Double price=4.0;
    public Decaf(){
        description = " Decaf $"+price;
    }
    @Override
    public Double cost() {
        return price;
    }
}