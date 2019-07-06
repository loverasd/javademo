package test1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

/**
 * @Classname TestMoney
 * @Description TODO
 * @Date 2019/6/24 15:46
 * @Created by x1c
 */
public class TestMoney {
    static Map<String, String> map = new HashMap<>();
    static String path = "C:\\Users\\x1c\\Desktop\\30.txt";
    static ArrayList<Integer> a1 = new ArrayList<>(); // 11 00 00 00 00     00
    static ArrayList<Integer> a2 = new ArrayList<>();//  00 11 00 00 00     00
    static ArrayList<Integer> a3 = new ArrayList<>();//  00 00 11 00 00     00
    static ArrayList<Integer> a4 = new ArrayList<>();//  00 00 00 11 00     00
    static ArrayList<Integer> a5 = new ArrayList<>();//  00 00 00 00 11     00
    static ArrayList<Integer> a6 = new ArrayList<>();//  00 00 00 00 00     11
    static ArrayList<Integer> a7 = new ArrayList<>();
    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        getData(path);
//        System.out.println();
//        map.forEach((a,b)-> System.out.println(a+":"+b));
//        a1.stream().forEach(a1-> System.out.print(a1+" "));
//        System.out.println();
//        a2.stream().forEach(a2-> System.out.print(a2+" "));
//        System.out.println();
//        a3.stream().forEach(a3-> System.out.print(a3+" "));
//        System.out.println();
//        a4.stream().forEach(a4-> System.out.print(a4+" "));
//        System.out.println();
//        a5.stream().forEach(a5-> System.out.print(a5+" "));
//        System.out.println();
//        a6.stream().forEach(a6-> System.out.print(a6+" "));
        a7.addAll(a1);
        a7.addAll(a2);
        a7.addAll(a3);
        a7.addAll(a4);
        a7.addAll(a5);
        a7.addAll(a6);
        a7.parallelStream().forEach(a->{
            if (hashMap.containsKey(a)){
                Integer integer = hashMap.get(a);
                hashMap.put(a,++integer);
            }else {
                hashMap.put(a,1);
            }
        });
        hashMap.entrySet().stream()
                .sorted(Collections.reverseOrder(comparingByValue())).forEach(a-> System.out.println(a.getKey()+":"+a.getValue()));

    }

    public static void getData(String path) throws IOException {
        String line;
        File file = new File(path);
        FileReader reader = new FileReader(file);
        BufferedReader breader = new BufferedReader(reader);
        while ((line = breader.readLine()) != null) {
            map.put(line.substring(0, 7), line);
            String[] split = line.split("\t");
            a1.add(Integer.valueOf(split[1].substring(0,2)));
            a2.add(Integer.valueOf(split[1].substring(2,4)));
            a3.add(Integer.valueOf(split[1].substring(4,6)));
            a4.add(Integer.valueOf(split[1].substring(6,8)));
            a5.add(Integer.valueOf(split[1].substring(8,10)));
            a6.add(Integer.valueOf(split[2].substring(0,2)));

        }
        reader.close();
        breader.close();
    }
}
