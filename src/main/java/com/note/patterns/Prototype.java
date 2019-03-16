package com.note.patterns;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: javademo
 * @description: 用原型实例指定创建对象的种类, 并且通过拷贝这些原型创建新的对象
 * @author: chenp
 * @create: 2018-09-06 15:46
 **/
public class Prototype {
    public static void main(String[] args) {
        AbstractSpoon spoon = new SoupSpoon();
        System.out.println(spoon.getSpoonName());
        spoon.setSpoonName("aha");
        System.out.println(spoon.getStr());
        AbstractSpoon spoon1 = (AbstractSpoon) spoon.clone();
        System.out.println(spoon1.getSpoonName());
    }

}

/**
 * 浅拷贝: 对值类型的成员变量进行值的复制,对引用类型的成员变量只复制引用,不复制引用的对象
 */
@Setter
@Getter
abstract class AbstractSpoon implements Cloneable{

    String spoonName;
    String str = new String("hello");
    public Object clone(){
        Object object  = null;
        try{
            object = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("AbstractSpoon is not Cloneable");
            e.printStackTrace();
        }
        return object;
    }
}

class SoupSpoon extends AbstractSpoon{
    public SoupSpoon(){
        setStr("ni , hao ");
        setSpoonName("Soup Spoon");
    }
}

/**
 * 深拷贝:将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。
 */
abstract class DeepCopy implements Cloneable{

    String spoonName;
    public Object clone(){
        Object object  = null;
//        ByteArrayInputStream inputStream = new ByteArrayInputStream();

        return null;
    }
}