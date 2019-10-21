package com.note.design_patterns.behavioral.command;

import com.note.design_patterns.behavioral.command.demo1.GarageDoor;
import com.note.design_patterns.behavioral.command.model.CeilingFan;
import com.note.design_patterns.behavioral.command.model.Light;
import com.note.design_patterns.behavioral.command.model.Stereo;
import com.note.design_patterns.behavioral.command.off.CeiLingFanOff;
import com.note.design_patterns.behavioral.command.off.GarageDoorClose;
import com.note.design_patterns.behavioral.command.off.LightOffCommand;
import com.note.design_patterns.behavioral.command.on.CeilingFanHight;

/**
 * @program: demo
 * @description: main 方法
 * @author: chenp
 * @create: 2019-04-14 18:52
 **/
public class MainTest {
    public static void main(String[] args) {
        //厨师，执行命令
        CeilingFan ceilingFan = new CeilingFan();
        Light light = new Light();
        Stereo stereo = new Stereo();
        GarageDoor garageDoor = new GarageDoor();
        //订单
        CeiLingFanOff ceiLingFanOff = new CeiLingFanOff(ceilingFan);
        CeilingFanHight ceilingFanHight = new CeilingFanHight(ceilingFan);
        GarageDoorClose garageDoorClose = new GarageDoorClose(garageDoor);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        // Invoker
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(1,ceiLingFanOff,ceilingFanHight);
        remoteControl.onButtonWasPressed(1);


    }
}