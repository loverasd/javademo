package com.note.design_patterns.adapter;

import java.util.stream.Stream;

/**
 * @program: demo
 * @description: 鸭子适配器
 * @author: chenp
 * @create: 2019-04-27 15:41
 * @company: sinosoft
 **/
public class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        Stream<Integer> limit = Stream.iterate(1, i -> i + 1).limit(10);
        for (int i = 0; i < limit.count(); i++) {
            turkey.fly();

        }
    }
}