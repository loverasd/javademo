package com.algs4.sort.sort;

import java.util.Arrays;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-09-10 09:31
 **/
public abstract class Sort<T extends Comparable<T>> {
    public static Integer[] ints = new Integer[]{5,2,8,4,12,6};
    public  abstract  void sort(T[] nums);

    protected boolean less(T v, T w){
        return v.compareTo(w) < 0;
    }
    protected void swap (T[] a , int i, int j){
        T t =a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public void  show(T[] a){
        Arrays.stream(a).forEach(s-> System.out.print(s+" "));
        System.out.println();
    }


}