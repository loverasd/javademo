package com.note.design_patterns.decoratorBeverage;

/**
 * @program: javademo
 * @description: 豆奶
 * @author: chenp
 * @create: 2018-12-23 15:47
 **/
public class Soy extends CondimentDecorator {
    Double soyPrice = 0.7;
    Beverage beverage ;
    public Soy(Beverage beverage ){
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+",Soy $"+soyPrice;
    }

    @Override
    public Double cost() {
        return beverage.cost()+soyPrice;
    }
}