package com.note.design_patterns.observer;

/**
 * @program: javademo
 * @description: 观察者
 * @author: chenp
 * @create: 2018-12-18 17:56
 **/
public interface Observer {
    void update(float temperature, float humidity, float presure);
}