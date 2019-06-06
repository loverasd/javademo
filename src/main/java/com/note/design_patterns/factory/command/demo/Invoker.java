package com.note.design_patterns.factory.command.demo;

/**
 * @program: demo
 * @description: 服务员
 * @author: chenp
 * @create: 2019-04-01 20:00
 **/
public class Invoker {
    CommandOreder commandOreder;

    public void setCommandOreder(CommandOreder commandOreder) {
        this.commandOreder = commandOreder;
    }

    public void pressOn(){
        commandOreder.execute();
    }
}