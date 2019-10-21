package com.note.design_patterns.behavioral.observer;

import java.util.ArrayList;

/**
 * @program: javademo
 * @description: 天气数据
 * @author: chenp
 * @create: 2018-12-18 18:06
 **/
public class WeatherData implements Subject {
    private final ArrayList observers;
    private float temperature;
    private float humidity;
    private float pressure;


    public WeatherData(){
        observers = new ArrayList();
    }
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.removeIf(s->s.equals(o));
    }

    @Override
    public void notifyObserver() {
        for (int i=0; i<observers.size(); i++){
            Observer observer = (Observer)observers.get(i);
            observer.update(temperature,humidity,pressure);
        }
    }

    public void measurementsChanged(){
        notifyObserver();
    }

    public void setMeasurements(float temperature, float humidity, float pressuser ){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressuser;
        measurementsChanged();
    }
}