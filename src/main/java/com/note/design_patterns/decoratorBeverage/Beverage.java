package com.note.design_patterns.decoratorBeverage;

/**
 * @program: javademo
 * @description: 饮料类
 * @author: chenp
 * @create: 2018-12-23 15:17
 **/
public abstract class  Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }
    public abstract Double cost();
}