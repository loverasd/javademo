package com.note.design_patterns.behavioral.command.off;

import com.note.design_patterns.behavioral.command.Command;
import com.note.design_patterns.behavioral.command.demo1.GarageDoor;

/**
 * @program: demo
 * @description: 车库门关
 * @author: chenp
 * @create: 2019-04-14 16:13
 **/
public class GarageDoorClose implements Command {
    GarageDoor garageDoor ;
    public GarageDoorClose(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.lightOff();
        garageDoor.down();
    }

    @Override
    public void undo() {
        garageDoor.lightOn();
        garageDoor.up();
    }
}