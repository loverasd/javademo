package com.note.design_patterns.behavioral.command.off;

import com.note.design_patterns.behavioral.command.Command;
import com.note.design_patterns.behavioral.command.model.Light;

/**
 * @program: demo
 * @description: 关灯命令
 * @author: chenp
 * @create: 2019-04-14 16:12
 **/
public class LightOffCommand implements Command {
    Light light;
    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}