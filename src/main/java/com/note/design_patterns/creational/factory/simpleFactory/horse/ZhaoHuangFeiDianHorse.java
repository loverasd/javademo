package com.note.design_patterns.creational.factory.simpleFactory.horse;

import com.note.design_patterns.creational.factory.simpleFactory.Horse;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-01-02 10:27
 **/
public class ZhaoHuangFeiDianHorse implements Horse {
    @Override
    public void desc() {
        System.out.println("爪黄飞电马，曹操所用");
    }
}