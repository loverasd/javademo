package com.note.design_patterns.behavioral.statePattern.test;

/**
 * @Classname NoQuaterState
 * @Description TODO
 * @Date 2019/6/4 17:19
 * @Created by x1c
 */
public class NoQuaterState implements State {
    GumballMachine gumballMachine;

    public NoQuaterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("you inserted a quarter");
        gumballMachine.setState(gumballMachine.hasQuaterState);
    }

    @Override
    public void ejectQuarter() {
        System.out.println("you not inserted money!!!");
    }

    @Override
    public void turnCrank() {
        System.out.println("please insert money");
    }

    @Override
    public void dispense() {
        System.out.println("please insert money");
    }
}
