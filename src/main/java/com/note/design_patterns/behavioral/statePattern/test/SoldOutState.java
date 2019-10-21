package com.note.design_patterns.behavioral.statePattern.test;

/**
 * @Classname SoldOutState
 * @Description TODO
 * @Date 2019/6/4 16:47
 * @Created by x1c
 */
public class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("gumball sold out");
        ejectQuarter();
    }

    @Override
    public void ejectQuarter() {
        System.out.println("退 钱");
    }

    @Override
    public void turnCrank() {
        System.out.println("gumball sold out");
    }

    @Override
    public void dispense() {
        System.out.println("gumball sold out");
    }
}
