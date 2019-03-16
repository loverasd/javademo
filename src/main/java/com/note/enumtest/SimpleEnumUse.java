package com.note.enumtest;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-09-07 17:11
 **/
public class SimpleEnumUse {
    public static void main(String[] args) {
        Spiciness howHot = Spiciness.MEDIUM;
        System.out.println(howHot);
        for (Spiciness s : Spiciness.values()){
            System.out.println(s);
        }
        int a = Spiciness.HOT.ordinal();
        int b = Spiciness.NOT.ordinal();
        System.out.println(a);
        System.out.println(b);
    }
}
