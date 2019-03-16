package com.note.container;

import com.example.demo.domain.Persoion;
import org.hibernate.validator.internal.util.CollectionHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program: javademo
 * @description: 容器填充解决方案
 * @author: chenp
 * @create: 2018-08-28 19:50
 **/
public class CollectionData<T> extends ArrayList<T> {
    static TwoPuple<String,Integer> f(){
        return new TwoPuple<String,Integer>("hi",47);
    }
    static  ForTuple<String,String,String,Persoion> g(){
        return new ForTuple<>("ni","shi","一个人",new Persoion());
    }

    public static void main(String[] args) {
        f();
        g();
    }

HashMap<String,String > map = CollectionHelper.newHashMap();
}

class TwoPuple<A,B>{

    public final A a;
    public final B b;

    public TwoPuple(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "TestPuple{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
class  ForTuple<A,B,C,D> extends TwoPuple<A,B>{
    public final C c;
    public final D d;

    public ForTuple(A a,B b,C c, D d) {
        super(a,b);
        this.c = c;
        this.d = d;
    }
}


