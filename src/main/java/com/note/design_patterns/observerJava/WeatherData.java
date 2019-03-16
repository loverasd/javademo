package com.note.design_patterns.observerJava;

import com.note.design_patterns.observer.Observer;
import com.note.design_patterns.observer.Subject;
import lombok.Data;

import java.util.ArrayList;
import java.util.Observable;

/**
 * @program: javademo
 * @description: 天气数据
 * @author: chenp
 * @create: 2018-12-18 18:06
 **/
@Data
public class WeatherData extends Observable {
    private ArrayList observers;
    private float temperature;
    private float humidity;
    private float pressure;


    public WeatherData(){

    }



    public void measurementsChanged(){
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressuser ){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressuser;
        measurementsChanged();
    }
}