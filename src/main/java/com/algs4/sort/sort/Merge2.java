package com.algs4.sort.sort;

import java.util.Arrays;

/**
 * @program: demo
 * @description: 归并排序
 * @author: chenp
 * @create: 2019-05-24 15:06
 **/
public  class  Merge2 {

    public static void main(String[] args) {
        int[] ints = {1,4,7,2,5,8};
        merge(ints,0,3,5);
        Arrays.stream(ints).forEach(System.out::println);

    }

    public static void merge(int[] a , int first, int mid, int last){
        int[] b = new int[last];
        int f = first, m = mid,bIndx=0;
        while (f < mid || m< last){
            if (a[f] > a[m]){
                b[bIndx++] = a[m++];
            }else {
                b[bIndx++] = a[f++];
            }
        }
        if (f<mid){
            for (;f<mid;f++) {
                b[bIndx++] = a[f];
            }
        }
        if (m<last){
            for (;m<last;m++){
                b[bIndx++]= a[m];
            }
        }
        for (int i=0;first<last;first++){
            a[first] = b[i++];
        }
    }
    public void mergeSort(int[] a,int low,int high){

    }




}