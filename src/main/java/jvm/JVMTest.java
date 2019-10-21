package jvm;

import sun.misc.Unsafe;

import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @Classname JVMTest
 * @Date 2019-09-23 16:22
 * @Created by chenpan
 * @Description 直接内存测试类
 */
public class JVMTest {
    private static final int _1MB = 1024 * 1024;
    private Object instance;
    byte[] bigSize = new byte[2 * _1MB];
    public static void main(String[] args) throws IllegalAccessException {
//        runtimeConstantPoolOOM();
        testAllocation();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();


    }

    /**
     * 方法区和运行时常量溢出
     */
    public static void runtimeConstantPoolOOM() {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }

    }

    /**
     * 循环引用测试
     */
    public static void referenceCountingGC() {
        JVMTest objA = new JVMTest();
        JVMTest objB = new JVMTest();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        System.gc();
    }

    /**
     * 软引用测试
     */
    public static void softReference() {
        ArrayList<Integer> integers = new ArrayList<>();

        SoftReference<ArrayList<Integer>> softReference = new SoftReference<>(integers);
    }


    /**
     * VM参数:-verbose:gc-Xms20M-Xmx20M-Xmn10M-XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];//出现一次Minor GC
    }
    public static void testChar(){
        char a='A';
        System.out.println(String.valueOf(a));
    }
}
