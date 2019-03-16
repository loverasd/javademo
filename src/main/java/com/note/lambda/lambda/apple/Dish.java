package com.note.lambda.lambda.apple;

import lombok.Data;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-01-16 17:57
 **/
@Data
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;
    public enum Type { MEAT, FISH, OTHER }

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }
}