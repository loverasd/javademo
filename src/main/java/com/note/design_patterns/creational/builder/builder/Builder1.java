package com.note.design_patterns.creational.builder.builder;


import com.note.design_patterns.creational.builder.builder.product.product.WarHorse;

public abstract class Builder1 {
/**
 * @program: javademo
 *
 * @description: 建造者
 *
 * @author: chenp
 *
 * @create: 2019-01-03 11:39
 **/
    /**创建马
     *
     */
    abstract void buildHorse();

    /**
     *  创建马鞍
     */
    abstract void buildSaddle();

    /**创建辔头
     *
     */
    abstract void buildBridle();
    /**
     *     创建马蹄铁
     */
    abstract void buildHorseshoe();

    /**
     *     获取装备完成的战马
     */
    abstract WarHorse getWarHorse();
}
