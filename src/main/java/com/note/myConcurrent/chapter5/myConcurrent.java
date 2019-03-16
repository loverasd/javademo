package com.note.myConcurrent.chapter5;

import java.io.File;
import java.io.FileFilter;
import java.util.function.Function;

/**
 * @program: javademo
 * @description: 第五章
 * @author: chenp
 * @create: 2019-01-04 10:51
 **/
public class myConcurrent {
    public static void main(String[] args) {
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
    }
}