package com.note.design_patterns.singleton;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.management.ObjectInstance;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: javademo
 * @description: 单例模式管理器
 * @author: chenp
 * @create: 2019-03-25 13:11
 **/
public class SingleManager {
    private static Map<String,Object> objMap = new HashMap<>();
    private SingleManager(){

    }
    public static void registerSingleton(String key, Object instance){
        if (!objMap.containsKey(key)){
            objMap.put(key,instance);
        }
    }

    public static Object getInstance(String key){
        return objMap.get(key);

    }



}