package com.note.design_patterns.command.on;

import com.note.design_patterns.command.Command;
import com.note.design_patterns.command.model.Stereo;

/**
 * @program: demo
 * @description: 音响
 * @author: chenp
 * @create: 2019-04-14 16:10
 **/
public class StereoOnForcd implements Command {
    Stereo stereo;
    public StereoOnForcd(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
    }

    @Override
    public void undo() {
        stereo.off();
    }
}