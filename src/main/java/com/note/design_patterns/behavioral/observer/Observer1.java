package com.note.design_patterns.behavioral.observer;

/**
 * @program: javademo
 * @description: 观察者1
 * @author: chenp
 * @create: 2018-12-18 18:26
 **/
public class Observer1 implements Observer,DisplayElement {
    private float temperature; //温度
    private float humidity; //湿度
    private Subject weatherData;

    public Observer1 (Subject weatherData ){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }



    @Override
    public void update(float temperature, float humidity, float presure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("公告板1---------\n当前温度："+temperature+"\n当前湿度："+humidity);
    }
}