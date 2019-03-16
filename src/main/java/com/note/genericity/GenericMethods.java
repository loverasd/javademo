package com.note.genericity;

/**
 * @program: javademo
 * @description: 泛型方法
 * @author: chenp
 * @create: 2018-09-01 15:56
 **/
public class GenericMethods {
    public <T> void f(T t){
        System.out.println(t.getClass().getName());
    }
    public <A,B,C> void f(A a,B b, C c){

    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f('c');
        gm.f(gm);
    }
}