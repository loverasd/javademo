package com.note.design_patterns.bridge;

/**
 * @Classname SimpleAccount
 * @Description TODO
 * @Date 2019/6/17 9:31
 * @Created by x1c
 */
public class SimpleAccount extends AbstractAccount {
    private int balance;

    public SimpleAccount(int balance) {
        this.balance = balance;
    }

    public boolean isBalanceLow() {
        return balance < 50;
    }

    public void draw() {
        boolean showPerform = balance > 50;
        if (showPerform) {
            operate(balance + "", showPerform);
        }
    }

    public void draw(int balance) {
        this.balance = balance;
        boolean showPerform = balance > 50;
        if (showPerform) {
            operate(balance + "", showPerform);
        }
    }
}
