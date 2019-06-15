package com.note.design_patterns.command.off;

import com.note.design_patterns.command.Command;
import com.note.design_patterns.command.model.CeilingFan;

/**
 * @program: demo
 * @description: 关吊扇命令
 * @author: chenp
 * @create: 2019-04-14 16:13
 **/
public class CeiLingFanOff implements Command {
    CeilingFan ceilingFan;
    public CeiLingFanOff(CeilingFan ceilingFan) {
        this.ceilingFan =ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.off();
    }

    @Override
    public void undo() {
        ceilingFan.on();
    }
}