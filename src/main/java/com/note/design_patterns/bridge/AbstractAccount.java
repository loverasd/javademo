package com.note.design_patterns.bridge;

/**
 * @Classname AbstractAccount
 * @Description TODO
 * @Date 2019/6/17 9:24
 * @Created by x1c
 */
public class AbstractAccount {
    private MyLogger myLogger = MyLogger.info();

    public void setMyLogger(MyLogger myLogger) {
        this.myLogger = myLogger;
    }
    // the logging part is delegated to the Logger implementation
    protected void operate(String message, boolean resault){
        myLogger.log(message+"::"+resault);

    }
}
