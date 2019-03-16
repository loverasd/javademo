package com.note.design_patterns.factory.factoryMethod.horse;

import com.note.design_patterns.factory.factoryMethod.Horse;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-01-02 18:50
 **/
public class DiLuHorse implements Horse {
    @Override
    public void desc() {
        System.out.println("的卢马 ");
    }
}