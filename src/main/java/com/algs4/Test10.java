package com.algs4;


import java.io.*;
import java.util.*;

/**
 * @program: javademo
 * @author: chenp
 * @create: 2018-10-19 12:35
 * @description:
 **/
public class Test10 {
    public static void main(String[] args) {
//        Map<String, String> input = getInput();
        List<String> data = getData();
        List<String> a0 = new ArrayList<>();
        List<String> a2 = new ArrayList<>();
        List<String> a4 = new ArrayList<>();
        List<String> a6 = new ArrayList<>();
        List<String> a8 = new ArrayList<>();
        List<String> a10 = new ArrayList<>();
        int i=1;
        data.stream().forEach(s-> {
            a0.add(s.substring(0,2));
            a2.add(s.substring(2,4));
            a4.add(s.substring(4,6));
            a6.add(s.substring(6,8));
            a8.add(s.substring(8,10));
            a10.add(s.substring(10,12));
//            System.out.println(s);
        });
        a0.stream().forEach(s-> System.out.println(s));
//        Set<Map.Entry<String, String>> entries = input.entrySet();
//        entries.stream().forEach(s->{
//            String a ="";
//            if (!s.getValue().substring(0,2).contains("0")){
//                a ="\n";
//            }
//            System.out.print(s.getValue().substring(0,2)+" "+a);
//        });
    }
    public static Map<String,String> getInput(){
        Map<String,String> map=null;
        File file = new File("D:\\a.txt");
        try {
            FileReader reader = new FileReader(file);

            BufferedReader br = new BufferedReader(reader);
             map =  new HashMap<>();
            while (br.readLine() != null){
                String[] split = br.readLine().split("\\s");
//                System.out.println(br.readLine());
                System.out.print(split[0]);
                System.out.print(split[1]);
                System.out.print(split[2]);
                System.out.print(split[3]+"\n");
                map.put(split[0],split[2]+split[3]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
    public static List<String> getData(){
        List<String > list=null;
        File file = new File("D:\\a.txt");
        try {
            FileReader reader = new FileReader(file);

            BufferedReader br = new BufferedReader(reader);
            list = new ArrayList<>();
            while (br.readLine() != null){
                String[] split = br.readLine().split("\\s");
//                System.out.println(br.readLine());
//                System.out.print(split[0]);
//                System.out.print(split[1]);
//                System.out.print(split[2]);
//                System.out.print(split[3]+"\n");
                list.add(split[2]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}