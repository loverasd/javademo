package com.note.design_patterns.statePattern;

import lombok.Setter;

/**
 * @Author: cp
 * @Date: 2019/6/4 16:31
 * @Version 1.0
 */
public class GumballMachine {
    //状态
    State soldOutState;//卖光
    State noQuaterState;//未投币
    State hasQuaterState;// 已投币
    State soldState;//销售
    @Setter
    State state = soldOutState;
    //糖果数量
    int count = 0;

    public GumballMachine(int numberGumball) {
        this.count = numberGumball;
        soldOutState = new SoldOutState(this);
        noQuaterState = new NoQuaterState(this);
        hasQuaterState = new HasQuaterState(this);
        soldState = new SoldState(this);
        this.count = numberGumball;
        if (numberGumball > 0){
            state = noQuaterState;
        }
    }
    public void releaseBall(){
        if (count>0){
            count--;
            System.out.println("ball had down");
        }else {
            System.out.println("the ball is null");
        }
    }
    public void insertQuarter(){
        state.insertQuarter();
        this.state=hasQuaterState;
    }
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

}
