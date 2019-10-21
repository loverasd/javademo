package com.note.design_patterns.behavioral.observer2;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-12-19 14:06
 **/
public interface MySubject {

    void register(Observer observer);
    void remove(Observer observer);
    void notifyObsever();
}