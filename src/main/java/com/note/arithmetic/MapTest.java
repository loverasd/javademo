package com.note.arithmetic;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: javademo
 * @description: map集合测试
 * @author: chenp
 * @create: 2018-09-25 11:33
 **/
public class MapTest {

    public static void main(String[] args) {
        Map<String ,String> map = new ConcurrentHashMap<>();

        map.put("1","nihao");
    }
}