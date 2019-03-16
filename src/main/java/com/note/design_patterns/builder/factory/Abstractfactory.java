package com.note.design_patterns.builder.factory;


import com.note.design_patterns.builder.factory.parts.*;

/**
 * @program: javademo
 * @description: 产品接口
 * @author: chenp
 * @create: 2019-01-03 16:07
 **/
public interface Abstractfactory {
    /**
     * 创建辔头
     * @return
     */
    BridleInterface createBridle();

    /**
     * 创建马
     * @return
     */
    HorseInterface createHorse();

    /**
     * 创建马鞍
     * @return
     */
    SaddleInterface createSaddle();

    /**
     * 创建马蹄铁
     * @return
     */
    HorseshoeInterface createHorseshoe();

}