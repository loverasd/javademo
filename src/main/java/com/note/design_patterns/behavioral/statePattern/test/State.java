package com.note.design_patterns.behavioral.statePattern.test;

/**
 * @Author: cp
 * @Date: 2019/6/4 16:38
 * @Version 1.0
 * @Description 状态接口
 */
public interface State {
    /**
     * 投币
     */
    void insertQuarter();

    /**
     *退币
     */
    void ejectQuarter();

    /**
     * 转动曲柄
     */
    void turnCrank();

    /**
     * 发放糖果
     */
    void dispense();
}
