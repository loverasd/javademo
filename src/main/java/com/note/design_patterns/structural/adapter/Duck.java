package com.note.design_patterns.structural.adapter;

/**
 * @program: demo
 * @description: 鸭子
 * @author: chenp
 * @create: 2019-04-27 15:15
 * @company: sinosoft
 **/
public interface Duck {
    /**
     * 呱呱叫
     */
    public void quack();

    /**
     * 飞
     */
    public void fly();
}