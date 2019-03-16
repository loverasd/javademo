package com.algs4.sort.sort;

import com.note.arithmetic.Nums;

import java.util.Arrays;

/**
 * @program: javademo
 * @author: chenp
 * @create: 2018-10-08 14:06
 * @description: 希尔排序
 **/
public class  Shell<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        int h = 1;
        while (h < N/3) h = 3*h+1;
        while (h >=1 ){
            for (int i = h; i<N; i++){
                for (int j = i; j>=h && less(nums[j],nums[j-h]) ; j-=h){
                    swap(nums,j,j-h);
                }
            }
            h = h/3;
        }
    }

    public static void main(String[] args) {
        Shell shell = new Shell();
        Integer[] a = new Integer[]{2,4,7,10,1,35,23,5};
        shell.sort(a);
        Arrays.stream(a).forEach(s -> System.out.print(s+" "));
    }
}