package com.note.design_patterns.structural.bridge;

/**
 * @Classname BridgeTest
 * @Description TODO
 * @Date 2019/6/17 9:36
 * @Created by x1c
 */
public class BridgeTest {
    public static void main(String[] args) {
        SimpleAccount simpleAccount = new SimpleAccount(100);
        simpleAccount.draw();

        if (simpleAccount.isBalanceLow()){
            // you can also change the Logger implementation at runtime
            simpleAccount.setMyLogger(MyLogger.warn());
        }
        simpleAccount.draw(1);
    }
}
