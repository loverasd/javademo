package com.note.design_patterns.behavioral.command;

public interface Command {
/**
 * @program: demo
 *
 * @description: 命令对象接口
 *
 * @author: chenp
 *
 * @create: 2019-04-01 08:08
 **/
    /**
     * 调用接收对象
     */
    public void execute();

    void undo();
}
