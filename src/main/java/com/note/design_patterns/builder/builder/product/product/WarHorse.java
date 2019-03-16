package com.note.design_patterns.builder.builder.product.product;

import com.note.design_patterns.builder.factory.parts.Bridle;
import com.note.design_patterns.builder.factory.parts.Horse;
import com.note.design_patterns.builder.factory.parts.Horseshoe;
import com.note.design_patterns.builder.factory.parts.Saddle;
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