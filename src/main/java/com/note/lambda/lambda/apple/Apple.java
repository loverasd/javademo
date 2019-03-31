package com.note.lambda.lambda.apple;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-01-16 17:13
 **/
@Data
public class Apple implements Serializable, Cloneable {
    private int weight;

    private String color;
    private String country;

    public Apple() {
    }

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }
    @JSONField(name = "zhongliang")
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.setColor("red");
        apple.setCountry("meiguo");
        apple.setWeight(20);
        System.out.println(apple);
        String s = JSON.toJSONString(apple);
        System.out.println(s);
    }
}