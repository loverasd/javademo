package com.algs4.sort.sort;

import java.util.Arrays;
import java.util.HashMap;


/**
 * @program: javademo
 * @author: chenp
 * @create: 2018-10-09 20:44
 * @description:
 **/
public class Merge<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        T[] temp = nums.clone();
        Up2DownSort(temp,nums,0,N-1);
    }
    private void Up2DownSort(T[] temp, T[] nums, int low, int hi){
        if ( low >= hi) return;
        int mid = low + (hi-low)/2;
//        Up2DownSort(temp,nums,low,mid);
//        Up2DownSort(temp,nums,mid+1,hi);
        Down2UpSort(temp,nums,mid+1,hi);
        merge(temp,nums,low,mid,hi);
    }

    /**
     * 自下而上的归并，每个元素看作单独的数组，两两归并
     * @param temp
     * @param nums
     * @param low
     * @param hi
     */
    private void Down2UpSort(T[] temp, T[] nums, int low, int hi){
        //进行lgN次来两两归并
        int N = nums.length;
        for (int sz = 1; sz < N; sz = sz +sz) {  //sz：子数组的大小, sz成2的幂次方增长
            for(int lo = 0; lo < N-sz; lo += sz+sz){//lo:子数组的索引，  sz=1时，子数组有2个数，sz=2时，子数组有4个数，sz=4时，子数组有8个数
                merge(temp,nums, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }

    }
    private void merge(T[] a,T[] nums,int low, int mid,int hi){

        for (int i = 0; i < hi; i++) {
            a[i] = nums[i];
        }
        int i = low; //左边数据起始位置
        int j = mid+1; //右边数据起始位置
        for (int k= low; k<=hi; k++){
            if (i>mid){ //左边数据用光，直接把右边的数据复制过去
                nums[k] = a[j++]; //先计算啊a[j]
            }else if (j > hi){ //右边的数据用光,把左边的数据复制过去
                nums[k] = a[i++];
            }else if (less(a[j],a[i])){//a[j] < a[i]
                nums[k] = a[j++];
            }else {
                nums[k] = a[i++];
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap(27,(float) 0.75);
        hashMap.put("1","a");
        Character[] b = new Character[]{'x','b','c','d','e','f'};
        Merge<Character> merge = new Merge<>();
        Arrays.stream(b).forEach(s-> System.out.print(s+" "));
//        edu.princeton.cs.algs4.Merge.Up2DownSort(b);
        System.out.println();
        merge.sort(b);
        merge.show(b);
    }
}