package com.note.design_patterns.behavioral.observer2;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-12-19 14:12
 **/
public interface Observer {
    void update(MySubject subject);
    void update(Object o);
}