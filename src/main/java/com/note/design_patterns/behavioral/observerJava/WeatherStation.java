package com.note.design_patterns.behavioral.observerJava;


/**
 * @program: javademo
 * @description: 气象站
 * @author: chenp
 * @create: 2018-12-19 09:49
 **/
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        Observer1 observer1 = new Observer1(weatherData);
        weatherData.setMeasurements((float) Math.random(),(float)Math.random(),(float) Math.random());
    }
}