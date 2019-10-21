package com.note.design_patterns.behavioral.observer;

/**
 * @program: javademo
 * @description: 主题接口
 * @author: chenp
 * @create: 2018-12-18 17:53
 **/
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}