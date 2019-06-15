package com.note.design_patterns.command.demo1;

import com.note.design_patterns.command.Command;
import com.note.design_patterns.command.model.Light;

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

    @Override
    public void undo() {

    }
}