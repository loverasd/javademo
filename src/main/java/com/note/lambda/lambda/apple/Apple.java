package com.note.lambda.lambda.apple;

import lombok.Data;

import java.util.Objects;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-01-16 17:13
 **/
@Data
public class Apple {
    private int weight;

    private String color;
    private String country;

    public Apple() {
    }

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }
    public Apple(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return weight == apple.weight &&
                Objects.equals(color, apple.color) &&
                Objects.equals(country, apple.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, color, country);
    }
}