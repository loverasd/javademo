package com.note.design_patterns.behavioral.observer;

/**
 * @program: javademo
 * @description: 观察者1
 * @author: chenp
 * @create: 2018-12-18 18:26
 **/
public class Observer2 implements Observer,DisplayElement {
    private float temperature; //温度
    private float humidity; //湿度
    private float pressure;
    private Subject weatherData;

    public Observer2(Subject weatherData ){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float presure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = presure;
        display();
    }

    @Override
    public void display() {
        System.out.print(
                "公告板2---------\n"+"当前温度："+temperature+"\n当前湿度："+humidity);
    }
}