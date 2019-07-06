package test1.myio;

import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @Classname TestFileEncode
 * @Description TODO
 * @Date 2019/6/25 10:49
 * @Created by x1c
 */
public class TestFileEncode {
    public static String path="E:\\work\\需求\\随车险\\机动车驾驶员意外险投保单.pdf";
    public static String outPath = "E:\\";
    public static void main(String[] args) throws IOException {
        String fileStr = getFileStr(path);
        saveTxt(fileStr,outPath);

    }

    public static String  getFileStr(String path) throws IOException {
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] bytes = bis.readAllBytes();
        byte[] encodeBase64 = Base64.encodeBase64(bytes);
        String s = new String(encodeBase64, Charset.forName("UTF-8"));
        System.out.println(s);
        System.out.println(new String(bytes,"UTF-8"));
        fis.close();
        bis.close();
        return s;
    }
    public static void saveTxt(String data,String outPath) throws IOException {
        File file = new File(outPath+"/pdf.txt");

        if (file.exists()) {
            file.createNewFile();
        }else {
        }
        FileOutputStream fos  = new FileOutputStream(file);
        fos.write(data.getBytes(Charset.forName("UTF-8")));
        fos.close();
    }
}
