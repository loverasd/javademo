package com.note.myutil;

/**
 * @program: javademo
 * @description: 数字工具类
 * @author: chenp
 * @create: 2018-09-10 09:59
 **/
public class Nums {
    public static int[] getRandom(int size, int scope ){
        int[] a=new int[size];
        for (int i=0; i<size; i++){
            a[i] =(int) (Math.random()*scope);
        }
        return a;
    }

    public static void main(String[] args) {
        int a[]=getRandom(10,100);
        for (int b: a){
            System.out.print(b+" ");
        }
    }
}