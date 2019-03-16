package com.concurrent.synchtest.demo1;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: javademo
 * @description: 车辆位置信息
 * @author: chenp
 * @create: 2018-11-01 14:32
 **/
@Getter
@Setter
public class MutablePoint {
    private int x,y;

    public MutablePoint() {
    }
    public MutablePoint(MutablePoint point){
        this.x = point.x;
        this.y = point.y;
    }

    public MutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}