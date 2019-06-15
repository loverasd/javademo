package com.note.design_patterns.command.on;

import com.note.design_patterns.command.Command;
import com.note.design_patterns.command.demo1.GarageDoor;

/**
 * @program: demo
 * @description: 车库门
 * @author: chenp
 * @create: 2019-04-14 16:09
 **/
public class GarageDoorOpen implements Command {
    GarageDoor garageDoor;
    public GarageDoorOpen(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
        garageDoor.lightOn();
    }

    @Override
    public void undo() {
        garageDoor.down();
        garageDoor.lightOff();
    }
}