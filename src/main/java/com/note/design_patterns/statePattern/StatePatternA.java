package com.note.design_patterns.statePattern;

/**
 * @Classname StatePatternA
 * @Date 2019/7/4 20:20
 * @Created by x1c
 * @Description
 * State 接口 定义状态的行为规范
 *      其实现类实现具体的行为、并将状态置为下一个状态
 * StateContext 类   提供对外方法{内部调用只有State的方法}
 *      持有State ，提供setState(State state) 供State状态的字类调用
 */

/**
 * 定义状态接口
 */
interface State{
    void writeName(StateContext context, String name);
}

class LowerCaseState implements State {

    @Override
    public void writeName(StateContext context, String name) {
        System.out.println(name.toLowerCase());
        context.setState(new MultipleUpperCaseState());
    }
}

class MultipleUpperCaseState implements State{

    private int count = 0;


    @Override
    public void writeName(StateContext context, String name) {
        System.out.println(name.toUpperCase());
        if (++count > 1) {
            context.setState(new LowerCaseState());
        }
    }
}


class StateContext{
    private State state;

    public StateContext() {
        state = new LowerCaseState();
    }

    /**
     * Set the current state
     * Normally only called classes implementing the State interface
     * 通常由实现State 接口的类调用
     * @param newState
     */
    void setState(State newState){
        state = newState;
    }

    public void writeName(String name) {
        state.writeName(this,name);
    }
}

public class StatePatternA {
    public static void main(String[] args) {
        StateContext stateContext = new StateContext();
        stateContext.writeName("qwewqQQQ");
        stateContext.writeName("qwewqQQQ");
    }
}
