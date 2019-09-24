package com.note.mychannel;

import edu.princeton.cs.algs4.StdRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @Classname ZeroCopy
 * @Date 2019-08-16 17:18
 * @Created by chenpan
 * @Description 零拷贝技术
 */
public class ZeroCopy {

    private static Logger logger = LoggerFactory.getLogger(ZeroCopy.class);
    private static String path = "/Users/chenpan/OneDrive/note.txt";
    private static String src = "/Users/chenpan/OneDrive/263450.txt";
    private static String out = "/Users/chenpan/OneDrive/111.txt";
    static class OOMClass{
       static int a = 1;
        public static void addPoint(){
            a++;
//            addPoint();
        }
    }
    private final String str = "/Users/chenpan/Desktop/test.zip";
    public static void main(String[] args) throws IOException {
        double uniform = StdRandom.uniform();
        System.out.println(uniform);


//        OOMClass.addPoint();
//        zeroCopy(src,out);
    }

    public static void zeroCopy(String originPath, String path) throws IOException {

        try (FileChannel channel = new FileInputStream(originPath).getChannel();
            FileChannel outChanl = new FileOutputStream(path).getChannel();
        ) {
            long l = channel.transferFrom(channel, 0, channel.size());
            logger.info("%s : "+l,l);

        } catch (Exception e) {
            throw e;
        }
    }
}
