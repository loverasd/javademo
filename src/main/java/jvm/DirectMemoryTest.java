package jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname DirectMemoryTest
 * @Date 2019-09-23 16:22
 * @Created by chenpan
 * @Description 直接内存测试类
 */
public class DirectMemoryTest {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        runtimeConstantPoolOOM();
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
}
