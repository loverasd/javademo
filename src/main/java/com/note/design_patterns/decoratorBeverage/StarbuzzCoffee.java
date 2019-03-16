package com.note.design_patterns.decoratorBeverage;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-12-23 16:26
 **/
public class StarbuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription()+" $"+ beverage.cost());
        Beverage beverage1 = new DarkRoast();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);
        System.out.println(beverage1.getDescription()+" \n total price: $"+beverage1.cost());

    }
}