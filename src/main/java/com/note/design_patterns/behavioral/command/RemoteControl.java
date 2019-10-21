package com.note.design_patterns.behavioral.command;

import java.util.Arrays;
import java.util.Stack;
import java.util.function.Supplier;

/**
 * @program: demo
 * @description: 遥控器
 * @author: chenp
 * @create: 2019-04-14 17:04
 **/
public class RemoteControl {
    private final Command[] onCommand;
    private final Command[] offCommands;
    Command undoCommand;
    Supplier<Command> supplier;
    private final static Stack<Command> stack = new Stack<>();


    public RemoteControl() {
        onCommand = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommand[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        this.onCommand[slot] = onCommand;
        this.offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        onCommand[slot].execute();
        undoCommand =onCommand[slot];
        stack.push(onCommand[slot]);
    }


    public void offButtonWasPressed(int slot) {
        offCommands[slot].execute();
        undoCommand = onCommand[slot];
        stack.push(onCommand[slot]);
    }

    public void undoWasPressed() {
        if (!stack.empty()){
            stack.pop().execute();
        }
        undoCommand.execute();
    }

    @Override
    public String toString() {
        return "RemoteControl{" +
                "onCommand=" + Arrays.toString(onCommand) +
                ", offCommands=" + Arrays.toString(offCommands) +
                ", supplier=" + supplier +
                '}';
    }
}