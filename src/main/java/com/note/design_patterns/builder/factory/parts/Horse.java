package com.note.design_patterns.builder.factory.parts;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: javademo
 * @description: 马
 * @author: chenp
 * @create: 2019-01-03 15:14
 **/
@Data
public class Horse implements HorseInterface{

    /**
     * 马名
     */
    private String horseName; //
    /**
     * 马高
     */
    private String size;

    /**
     * 体重
     */
    private double weight;

    /**
     *
     */

    @Override
    public void horseName() {
        System.out.println(horseName);
    }
}