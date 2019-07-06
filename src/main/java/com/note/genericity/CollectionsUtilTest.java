package com.note.genericity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Classname CollectionsUtilTest
 * @Description TODO
 * @Date 2019/6/12 14:39
 * @Created by x1c
 */
public class CollectionsUtilTest {
    public static void main(String[] args) {
        //List<T> list, Comparator<? super T> c
        ArrayList<B> bs = new ArrayList<>();
        B b = new B(1);
        B b2 = new B(2);
        B b3 = new B(3);
        B b4 = new B(4);
        bs.add(b);
        bs.add(b4);
        bs.add(b3);
        bs.add(b2);
        bs.forEach(s-> System.out.println(s.vb));
        Collections.sort(bs,Comparator.comparing(x->x.vb));
        System.out.println("----");
        bs.forEach(s-> System.out.println(s.vb));

    }
}
class A extends B{
    int va;
}
class B  {
    public B() {
    }

    public B(int vb) {
        this.vb = vb;
    }

    int vb;

}
