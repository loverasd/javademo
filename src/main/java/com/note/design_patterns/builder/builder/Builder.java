package com.note.design_patterns.builder.builder;


import com.note.design_patterns.builder.builder.product.product.WarHorse;

public interface Builder {
    default void desc(){
        System.out.println("战马建造者接口");
    }
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
    void buildHorse();

    /**
     *  创建马鞍
     */
    void buildSaddle();

    /**创建辔头
     *
     */
    void buildBridle();
    /**
     *     创建马蹄铁
     */
    void buildHorseshoe();

    /**
     *     获取装备完成的战马
     */
    WarHorse getWarHorse();
}
