package com.note.design_patterns.command;

import com.note.design_patterns.command.model.Light;
import com.note.design_patterns.command.demo1.LightOnCommand;
import com.note.design_patterns.command.demo1.SimpleRemoteControl;
import org.junit.jupiter.api.Test;

class SimpleRemoteControlTest { //命令模式客户端
    @Test
    public void test(){
        // 遥控器就是调用者，会传入一个命令对象，用来发出请求
        SimpleRemoteControl remote = new SimpleRemoteControl();
        //创建一个电灯对象，此对象也是请求的接收者
        Light light = new Light();
        //在这里创建一个命令，然后接收者传给它
        LightOnCommand lightOn = new LightOnCommand(light);
        //把命令传给调用者
        remote.setCommand(lightOn);
        //模拟按下按钮
        remote.buttonWosPressed();

    }

}