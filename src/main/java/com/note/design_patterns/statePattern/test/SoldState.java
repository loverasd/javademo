package com.note.design_patterns.statePattern.test;

/**
 * @Classname SoldState
 * @Description TODO
 * @Date 2019/6/4 17:21
 * @Created by x1c
 */
public class SoldState implements State {

    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("wait a moment");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("sorry , it will not be eject");
    }

    @Override
    public void turnCrank() {
        System.out.println("it will not down twice");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.count>0){
            gumballMachine.setState(gumballMachine.noQuaterState);
        }else {
            gumballMachine.setState(gumballMachine.soldOutState);
        }
    }
}
