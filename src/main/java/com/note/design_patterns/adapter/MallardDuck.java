package com.note.design_patterns.adapter;

import edu.princeton.cs.algs4.StdOut;

/**
 * @program: demo
 * @description: 绿头鸭
 * @author: chenp
 * @create: 2019-04-27 15:17
 * @company: sinosoft
 **/
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'am fly");
    }
}