package com.note.design_patterns.command.model;

/**
 * @program: demo
 * @description:
 * @author: chenp
 * @create: 2019-04-14 18:05
 **/
public class CeilingFan {
    public final static byte HIGHT=4;
    public final static byte MEDIUM=2;
    public final static byte LOW=1;
    public final static byte OFF=0;
    private byte speed;
    public void on(){
        System.out.println("the fan is runing");
        speed = LOW;
    }
    public void off(){
        System.out.println("the fan is downing");
        speed=OFF;
    }

    public void hight(){
        speed=HIGHT;
    }
    public void low (){
        speed = LOW;
    }
    public void  medium(){
        speed = MEDIUM;
    }
    public void off0(){
        speed = OFF;
    }
    public byte getSpeed() {
        return speed;
    }
}