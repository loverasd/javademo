package com.note.design_patterns.command;

/**
 * @program: demo
 * @description:
 * @author: chenp
 * @create: 2019-04-01 08:13
 **/
public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl() {
    }

    public void setCommand(Command command){
        slot = command;
    }

    public void buttonWosPressed(){
        slot.execute();
    }
}