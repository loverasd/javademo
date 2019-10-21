package com.note.design_patterns.behavioral.statePattern.test;

/**
 * @Classname HasQuaterState
 * @Description TODO
 * @Date 2019/6/4 17:20
 * @Created by x1c
 */
public class HasQuaterState implements State {

    GumballMachine gumballMachine ;

    public HasQuaterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("you inserted a quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("退钱中。。。。");
        gumballMachine.setState(gumballMachine.noQuaterState);
        System.out.println("已退钱。。。。。。。。。");
    }

    @Override
    public void turnCrank() {
        System.out.println(" gumball is downing");
        gumballMachine.setState(gumballMachine.soldState);
    }

    @Override
    public void dispense() {

    }
}
