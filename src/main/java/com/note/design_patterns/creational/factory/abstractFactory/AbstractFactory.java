package com.note.design_patterns.creational.factory.abstractFactory;

public interface AbstractFactory {
/**
 * @program: javademo
 *
 * @description: 工厂接口
 *
 * @author: chenp
 *
 * @create: 2019-01-02 14:21
 **/
    //创建马
    Horse createHorse();
    //创建马鞍
    Saddle createSaddle();
    //

}
