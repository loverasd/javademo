package com.note.design_patterns.sexprinciple.srp;

public class ProduceJuice<T> {
/**
 * @program: javademo
 *
 * @description:
 *
 * @author: chenp
 *
 * @create: 2019-01-09 10:57
 **/
    void getConnection(){
        System.out.println("连接数据库");
    }

    T findApple(T t){
        System.out.println("找水果");
        return t;
    }
    void peeling(T t){
        System.out.println("去果皮");
    }
    void seeding(T t){
        System.out.println("去果籽");
    }
    void juice(T t){
        System.out.println("榨汁");
    }


}
