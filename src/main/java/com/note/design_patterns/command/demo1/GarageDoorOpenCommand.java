package com.note.design_patterns.command.demo1;

import com.note.design_patterns.command.Command;

/**
 * @program: demo
 * @description: GarageDoor command
 * @author: chenp
 * @create: 2019-04-01 08:35
 **/
public class GarageDoorOpenCommand implements Command {
    GarageDoor garageDoor;
    public GarageDoorOpenCommand(GarageDoor garageDoor ) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }

    @Override
    public void undo() {

    }
}