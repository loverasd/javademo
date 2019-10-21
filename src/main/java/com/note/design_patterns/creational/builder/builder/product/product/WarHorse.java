package com.note.design_patterns.creational.builder.builder.product.product;

import com.note.design_patterns.creational.abstractFactory.parts.Bridle;
import com.note.design_patterns.creational.abstractFactory.parts.Horse;
import com.note.design_patterns.creational.abstractFactory.parts.Horseshoe;
import com.note.design_patterns.creational.abstractFactory.parts.Saddle;
import lombok.Data;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-01-03 16:03
 **/
@Data
public class WarHorse {
    //缰绳
    private Bridle bridle;
    //马
    private Horse horse;
    //马蹄铁
    private Horseshoe horseshoe;
    //马鞍
    private Saddle saddle;
}