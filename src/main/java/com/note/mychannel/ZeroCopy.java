package com.note.mychannel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname ZeroCopy
 * @Date 2019-08-16 17:18
 * @Created by chenpan
 * @Description 零拷贝技术
 */
public class ZeroCopy {
    static class OOMClass{
       static int a = 1;
        public static void addPoint(){
            a++;
            addPoint();
        }
    }
    private final String str = "/Users/chenpan/Desktop/test.zip";
    public static void main(String[] args) {
        OOMClass.addPoint();
//        List<OOMClass> list = new ArrayList<>();
//        while (true) {
//            list.add(new OOMClass());
//        }
    }

    public static void zeroCopy(String originPath, String path) throws IOException {

        try (FileChannel channel = new FileInputStream(originPath).getChannel();
            FileChannel outChanl = new FileOutputStream(path).getChannel();

        ) {
        } catch (Exception e) {
            throw e;
        }
    }
}
