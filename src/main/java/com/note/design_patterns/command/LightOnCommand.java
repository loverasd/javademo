package com.note.design_patterns.command;

/**
 * @program: demo
 * @description:
 * @author: chenp
 * @create: 2019-04-01 08:10
 **/
public class LightOnCommand implements Command {
   Light light;


   public LightOnCommand(Light light){
       this.light = light;
   }
    @Override
    public void execute() {
        light.on();
    }
}