package com.note.design_patterns.behavioral.command.demo;

/**
 * @program: demo
 * @description: 订单
 * @author: chenp
 * @create: 2019-04-01 20:00
 **/
public interface CommandOreder {
    public void execute();
    public void undo();
}