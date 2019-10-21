package com.note.design_patterns.behavioral.command.on;

import com.note.design_patterns.behavioral.command.Command;
import com.note.design_patterns.behavioral.command.model.CeilingFan;

/**
 * @program: demo
 * @description: 车库吊扇
 * @author: chenp
 * @create: 2019-04-14 16:08
 **/
public class CeilingFanHightSpeed implements Command {

    CeilingFan ceilingFan;
    byte preSpeed;

    public CeilingFanHightSpeed(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {

        ceilingFan.hight();
        preSpeed = ceilingFan.getSpeed();
    }

    @Override
    public void undo() {
        switch (preSpeed) {
            case CeilingFan.HIGHT:
                ceilingFan.hight();
                break;
            case CeilingFan.MEDIUM:
                ceilingFan.medium();
                break;
            case CeilingFan.LOW:
                ceilingFan.low();
                break;
            case CeilingFan.OFF:
                ceilingFan.off0();
                break;
        }


    }

}