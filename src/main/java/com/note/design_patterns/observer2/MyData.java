package com.note.design_patterns.observer2;

import lombok.Getter;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-12-19 14:13
 **/
public class MyData implements MySubject {
    @Getter
    String data;
    ArrayList array;
    Observer observer;

    private MyData() {
    }

    public MyData(Observer observer) {
        this.observer = observer;
        array = new ArrayList();
        register(observer);
    }

    @Override
    public void register(Observer observer) {
        this.observer = observer;
        array.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        int i = array.indexOf(observer);
        if (i > -1) {
            array.remove(i);
        }
    }

    @Override
    public void notifyObsever() {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) instanceof Observer) {
                ((Observer) array.get(i)).update(this);
            }
        }
//        observer.update(this);
    }

    public void setChanged() {
        notifyObsever();
    }

    public void makeChange(String s) {
        this.data = s;
        setChanged();
    }

}