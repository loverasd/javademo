package com.note.design_patterns.creational.factory.simpleFactory;

import com.note.design_patterns.creational.factory.simpleFactory.horse.JueYingHorse;
import com.note.design_patterns.creational.factory.simpleFactory.horse.ZhaoHuangFeiDianHorse;

public class SimpleHorseFactory {
    public enum HorseType {
        TYPE_JueYing, TYPE_ZhaoHuangFeiDian
    }

    /**
     * @program: javademo
     * @description: 生产具体的马
     * @author: chenp
     * @create: 2019-01-02 10:30
     **/
    public static final int TYPE_JueYing = 1; //绝影
    public static final int TYPE_ZhaoHuangFeiDian = 2; //

    public static Horse createHorse(HorseType type) {
        switch (type) {
            case TYPE_JueYing:
                return new JueYingHorse();
            case TYPE_ZhaoHuangFeiDian:
                return new ZhaoHuangFeiDianHorse();
            default:
                new Exception("the horse is not exit");
        }
        return null;
    }
}
