package com.note.design_patterns.factory.abstractFactory.saddle;

import com.note.design_patterns.factory.abstractFactory.Saddle;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-01-02 15:15
 **/
public class XuanTieSaddle implements Saddle {
    @Override
    public void material() {
        System.out.println("精选玄铁，古法研制，重现三国时代马鞍");
    }

    @Override
    public void color() {
        System.out.println("纯黑色。。。。");
    }
}