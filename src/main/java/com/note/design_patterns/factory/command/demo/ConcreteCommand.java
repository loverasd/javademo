package com.note.design_patterns.factory.command.demo;

/**
 * @program: demo
 * @description: 具体命令
 * @author: chenp
 * @create: 2019-04-01 20:01
 **/
public class ConcreteCommand implements CommandOreder {
    Receiver receiver;
    public ConcreteCommand(Receiver receiver ) {
    }

    @Override
    public void execute() {
        receiver.action();
    }

    @Override
    public void undo() {

    }
}