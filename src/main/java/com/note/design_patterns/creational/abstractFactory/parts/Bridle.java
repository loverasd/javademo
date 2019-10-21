package com.note.design_patterns.creational.abstractFactory.parts;

import lombok.Data;

/**
 * @program: javademo
 * @description: 辔头
 * @author: chenp
 * @create: 2019-01-03 15:16
 **/
@Data
public class Bridle implements BridleInterface{
    public Double length;
    public String material;

    @Override
    public void length() {
        System.out.println(length);
    }
}