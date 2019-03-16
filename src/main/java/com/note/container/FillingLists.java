package com.note.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: javademo
 * @description: 集合填充
 * @author: chenp
 * @create: 2018-08-28 19:24
 **/
public class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> list= new ArrayList<>();
        /**
         * 为list填充数据
         *
         */
        List<StringAddress> list1 = new ArrayList<>(Collections.nCopies(4,new StringAddress("hello2")));
        System.out.println(list1);
        /**
         * 替换容器中已存在的元素，而不能创建新的元素
         */
        Collections.fill(list,new StringAddress("world2"));
        System.out.println(list);
        Collections.fill(list1,new StringAddress("world2"));
        System.out.println(list1);
    }
}
class  StringAddress{
    private  String s;
    public StringAddress(String s){
        this.s = s;
    }
    public String toString(){
        return super.toString()+" "+s;
    }
}