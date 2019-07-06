package com.note.design_patterns.command.off;

import com.note.design_patterns.command.Command;
import com.note.design_patterns.command.model.Stereo;

/**
 * @program: demo
 * @description: 关音响
 * @author: chenp
 * @create: 2019-04-14 16:14
 **/
public class StereoOff implements Command {
    Stereo stereo;
    public StereoOff(Stereo stereo) {
        this.stereo =stereo;
    }

    @Override
    public void execute() {
    stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
    }
}