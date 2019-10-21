package com.jdk11_13;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Optional;

/**
 * @program: javademo
 * @author: chenp
 * @create: 2018-10-19 16:43
 * @description:
 **/
public class TestVar {
    public static void main(String[] args) {
        String s = "mbzw4gCjAwMDEwOTMxNDAgMDAwMDAgbiAKMDAwMTA5MCg==</ElectronicPolicy>";
        String s1 = s.replaceAll("==(?=</ElectronicPolicy>)", s);
        System.out.println(s1);
        File file = new File("E:\\work\\模板修改\\PrintTemplate\\a");
        File[] files = file.listFiles();
        System.out.println("未完成清单");
        Arrays.stream(files).filter(f -> f.isFile()).map(w->w.getName()).forEach(System.out::println);

        System.out.println("已完成清单");
        Optional<File> b = Arrays.stream(file.listFiles()).filter(a1 -> a1.isDirectory()).filter(a2 -> a2.getName().equals("b1")).findFirst();
        Optional<File> first = Arrays.stream(b.get().listFiles()).filter(a -> a.isDirectory()).findFirst();
        Arrays.stream(first.get().listFiles()).filter(File::isFile).map(w->w.getName()).forEach(System.out::println);
    }

    @Test
    public void test(){
        String s="床前明月光，疑似地上霜。举头望明月，低头思故乡。";
        String a="";
    }

}