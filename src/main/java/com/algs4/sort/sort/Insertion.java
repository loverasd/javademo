package com.algs4.sort.sort;

/**
 * @program: javademo
 * @description: 插入排序
 * 主要用于已经趋于有状态的数组
 *  1.数组中每个元素距离他的最终位置都不远
 *  2.一个有序的大数组接一个小数组
 *  3.数组中只有几个元素的位置不正确
 *  原理
 *  从未排序的数组中选择
 *  worst: ~N^2/2 比较 和~N^2/2交换 次数与数组中的逆序数有关
 * @author: chenp
 * @create: 2018-09-30 15:09
 **/
public class Insertion<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nms) {
        for (int i =1; i<nms.length; i++ ){
            show(nms);
            for (int j=i; j>0 && less(nms[j],nms[j-1]); j--){
                swap(nms,j,j-1);
            }
            show(nms);
        }
    }

    public static void main(String[] args) {
        Insertion in = new Insertion();
        in.sort(ints);
    }
}