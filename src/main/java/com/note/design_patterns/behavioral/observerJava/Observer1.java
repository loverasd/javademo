package com.note.design_patterns.behavioral.observerJava;

import java.util.Observable;
import java.util.Observer;

/**
 * @program: javademo
 * @description: 观察者java
 * @author: chenp
 * @create: 2018-12-19 10:49
 **/
public class Observer1 implements Observer,DisplayElement {
    private float temperature; //温度
    private float humidity; //湿度
    private Observable observable;
    public Observer1(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData){
            WeatherData weatherData = (WeatherData)o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    public void display(){
        System.out.println("java:公告板:"+"温度:"+temperature+" 湿度:"+humidity);
    }
}