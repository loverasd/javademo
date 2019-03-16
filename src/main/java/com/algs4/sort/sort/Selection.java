package com.algs4.sort.sort;

import com.note.arithmetic.Nums;
import com.note.myutil.MyTime;

import java.util.Arrays;

/**
 * @program: javademo
 * @description: 选择排序,选择数组中最小的元素，将它与数组的第一个元素交换位置,再从剩下的数组中选择最小的与第二个交换
 * @author: chenp
 * @create: 2018-09-10 09:40
 **/
public class Selection<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nms) {
        int len = nms.length;

        for (int j=1; j<len; j++){
            int min = j - 1;
            for (int i=j; i<len; i++){
                if (less(nms[i],nms[min])){
                    min = i;
                }
            }
            swap(nms,min,j-1);
        }
    }

    public static void main(String[] args) {
        MyTime.start();
        Integer[] a = Nums.getRandomObject(5000,10000);
        Selection selection = new Selection();
        Arrays.stream(a).forEach(s-> System.out.print(s+" "));
        System.out.println();
        selection.sort(a);
        Arrays.stream(a).forEach(s-> System.out.print(s+" "));
        System.out.println("\ntime:"+MyTime.elapsedTime());

    }
}