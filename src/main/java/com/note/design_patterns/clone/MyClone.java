package com.note.design_patterns.clone;

import com.note.lambda.lambda.apple.Apple;
import lombok.Data;

import java.io.*;
import java.util.Date;

/**
 * @program: javademo
 * @description: 克隆模式  浅克隆，深克隆
 * @author: chenp
 * @create: 2019-03-26 08:53
 **/
@Data
public class MyClone implements Cloneable, Serializable{
    private String name;
    private transient Integer age; //对基本数据类型无效
    private Date date;
    private transient Apple apple; //Apple 对象不进行克隆

    /**
     * 浅克隆
     * @return
     */
    public Object clone() {
        Object o = null;
        try {
            o = (MyClone)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }

    /**
     * 深克隆
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Object deepClone() throws IOException, ClassNotFoundException {
        //将对象写入流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        //将对象从流中读取出来
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        MyClone myClone = new MyClone();
        myClone.setName("chen");
        myClone.setDate(new Date());
        myClone.setAge(20);
        myClone.setApple(new Apple());
        MyClone o = (MyClone)myClone.deepClone();
        o.setAge(10);
        System.out.println(myClone);
        System.out.println(o);
    }
}