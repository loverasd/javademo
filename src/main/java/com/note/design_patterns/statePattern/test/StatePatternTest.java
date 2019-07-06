package com.note.design_patterns.statePattern.test;

import com.note.design_patterns.statePattern.test.GumballMachine;

/**
 * @Classname StatePatternTest
 * @Description TODO
 * @Date 2019/6/6 11:26
 * @Created by x1c
 */
public class StatePatternTest {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

    }
}
