package com.note.design_patterns.singleton;

import java.util.HashMap;

/**
 * 单例模式 枚举模式
 */
public enum EnumSingleton {
    INSTANCE;
   private HashMap<String ,String> mapInstance;
   EnumSingleton(){
       mapInstance = new HashMap<>();
   }
   public HashMap<String,String> getMapInstance(){
       return mapInstance;
   }

    private Object readResolve() {
       // Return the one true Elvis and let the garbage collector
       // take care of the Elvis impersonator.
        return INSTANCE; }


    public static void main(String[] args) {
        HashMap<String, String> mapInstance = EnumSingleton.INSTANCE.getMapInstance();
    }
}

