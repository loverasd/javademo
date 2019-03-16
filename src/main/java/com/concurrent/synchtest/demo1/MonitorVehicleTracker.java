package com.concurrent.synchtest.demo1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: javademo
 * @description: 车辆监视器
 * 代码很简单，需要返回车辆位置时，通过deepCopy方法来复制正确的值，从而生成一个新的Map对象，可能对Collections.unmodifiableMap有一点疑问，科普一下
 * 1.MutablePoint 不是线程安全的
 * @author: chenp
 * @create: 2018-11-01 14:36
 **/
public class MonitorVehicleTracker {
    private final Map<String,MutablePoint> locations;
    public MonitorVehicleTracker(Map<String,MutablePoint> locations){
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String,MutablePoint> getLocations(){
        return deepCopy(locations);
    }
    public synchronized MutablePoint getLocation(String id){
        MutablePoint mutablePoint = locations.get(id);
        return mutablePoint == null ? null : new MutablePoint(mutablePoint);
    }

    private static Map<String,MutablePoint> deepCopy(Map<String, MutablePoint> m){
        Map<String,MutablePoint> map = new HashMap<>();
        for (String id : m.keySet()){
            map.put(id,new MutablePoint(m.get(id)));
        }
        return Collections.unmodifiableMap(map);
    }

}