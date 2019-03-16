package com.concurrent.synchtest.forkjoin;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-01-21 10:45
 **/
public class ForkJoinSumCalculator extends java.util.concurrent.RecursiveTask<Long> {
    private long nums[];
    private int start;
    private int end;
    public final long THRESHOLD = 10_000;

    private ForkJoinSumCalculator(long[] nums) {
        this(nums, 0, nums.length);
    }

    public ForkJoinSumCalculator(long[] nums, int start, int end) {
        this.nums = nums;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) return computeSequentially();
        ForkJoinSumCalculator leftFork = new ForkJoinSumCalculator(nums, 0, start + length / 2);
        ForkJoinSumCalculator rightFork = new ForkJoinSumCalculator(nums, start + length / 2, end);
        leftFork.fork();
        Long rightResult = rightFork.compute();
        Long leftResult = leftFork.join();
        return rightResult+leftResult;
    }

    private long computeSequentially() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        //可用内核的数量包括超线程生成的虚拟内核
        int i = runtime.availableProcessors();
        System.out.println(i);
    }

}