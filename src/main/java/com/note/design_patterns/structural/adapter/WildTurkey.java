package com.note.design_patterns.structural.adapter;

/**
 * @program: demo
 * @description:
 * @author: chenp
 * @create: 2019-04-27 15:19
 * @company: sinosoft
 **/
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}