package com.note.design_patterns.behavioral.observer2;

import java.time.LocalDateTime;

/**
 * @program: javademo
 * @description: 观察者1
 * @author: chenp
 * @create: 2018-12-19 14:30
 **/
public class Observer1 implements Observer {
    @Override
    public void update(MySubject subject) {
        LocalDateTime now = LocalDateTime.now();
        int second = now.getSecond();
        if (second%2 == 0){
            System.out.println(now.toString());
            display(((MyData)subject).getData());
        }else {
            System.out.println("此次更新的数据不符合要求不展示");
        }
    }

    @Override
    public void update(Object o) {

    }

    public void display(String s){
        System.out.println("展示数据："+s);
    }
}