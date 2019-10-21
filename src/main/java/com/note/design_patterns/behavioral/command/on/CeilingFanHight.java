package com.note.design_patterns.behavioral.command.on;

import com.note.design_patterns.behavioral.command.Command;
import com.note.design_patterns.behavioral.command.model.CeilingFan;

/**
 * @program: demo
 * @description: 车库吊扇
 * @author: chenp
 * @create: 2019-04-14 16:08
 **/
public class CeilingFanHight implements Command {

    CeilingFan ceilingFan;

    public CeilingFanHight(CeilingFan ceilingFan) {

        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.on();
    }

    @Override
    public void undo() {
        ceilingFan.off();

    }

}