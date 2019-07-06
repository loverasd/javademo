package com.note.design_patterns.command.demo1;

/**
 * @program: demo
 * @description:
 * @author: chenp
 * @create: 2019-04-01 08:32
 **/
public class GarageDoor {
    public void up(){
        System.out.println("this is open");
    }
    public void down(){
        System.out.println("this is closed");
    }
    public void stop(){
        System.out.println("this is stoped");
    }
    public void lightOn(){
        System.out.println("this is light on");
    }
    public void lightOff(){
        System.out.println("this is light off");
    }
}
