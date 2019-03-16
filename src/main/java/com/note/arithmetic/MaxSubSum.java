package com.note.arithmetic;

/**
 * @program: javademo
 * @description: 最大子序列
 * @author: chenp
 * @create: 2018-09-21 13:55
 **/
public class MaxSubSum {
    /**
     * Linear-time maxinum contiguous subsequence sum algorithm
     */
    public static int maxSubSum4(int[] a){
        int maxSum = 0, thisSum = 0;
        for (int j =0; j<a.length; j++){
            thisSum+=a[j];
            if (thisSum > maxSum){
                maxSum = thisSum;
            }else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }
}