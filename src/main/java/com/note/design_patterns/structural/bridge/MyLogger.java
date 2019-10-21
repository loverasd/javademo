package com.note.design_patterns.structural.bridge;

import java.time.LocalDateTime;

/**
 * @Classname MyLogger
 * @Description TODO
 * @Date 2019/6/17 9:11
 * @Created by x1c
 */
@FunctionalInterface
public interface MyLogger {
    void log(String message);
    static MyLogger info(){
        return message -> System.out.println(LocalDateTime.now()+" info "+message);
    }
    static MyLogger warn(){
        return message -> System.out.println(LocalDateTime.now()+" warning "+ message);
    }
}
