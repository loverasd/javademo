package test1;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Base64;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-09-13 19:28
 **/
public class TestIO {
    @Test
    public void test1() throws IOException {
        String url = "";
        byte[] b = "bihao 啊是不是你,.,.".getBytes();
        byte[] buf = new byte[10];
        InputStream in = new ByteArrayInputStream(b);

        OutputStream out = new ByteArrayOutputStream(10);
        while (in.read(buf) != -1) {
            out.write(buf);

        }
        String s = new String(buf);
        String string = Base64.getEncoder().encodeToString(buf);
        System.out.println(s);
        System.out.println(string);
        byte[] decode = Base64.getDecoder().decode(string);
        String s1 = new String(decode);
        System.out.println(s1);
    }

    @Test
    public void test2() throws IOException {
        byte[] bytes = "你好啊，hello,world".getBytes();
        InputStream in = new ByteArrayInputStream(bytes);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int ch;
        while ((ch = in.read()) != -1) {
            out.write(ch);
        }
        byte[] bytes1 = out.toByteArray();
        String string = Base64.getEncoder().encodeToString(bytes1);
        System.out.println(string);
        byte[] decode = Base64.getDecoder().decode(string);
        System.out.println(new String(decode));
    }
    @Test
    public void test3(){
        File  file = new File("D:\\dev-idea\\tomcat-hx\\webapps\\artifacts\\print\\icons\\logo.png");
        try {
        FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int ch;
            while ( (ch = fileInputStream.read()) !=-1){
                byteArrayOutputStream.write(ch);
            }
            byte[] bytes = byteArrayOutputStream.toByteArray();
            String string = Base64.getEncoder().encodeToString(bytes);
            System.out.println(string);
            byte[] decode = Base64.getDecoder().decode(string);
            System.out.println("------------");
            System.out.println(new String(bytes));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}