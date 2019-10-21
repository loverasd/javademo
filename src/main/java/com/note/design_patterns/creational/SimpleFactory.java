package com.note.design_patterns.creational;

/**
 * @Classname SimpleFactory
 * @Date 2019-09-16 13:59
 * @Created by chenpan
 * @Description 简单工厂模式
 */
public class SimpleFactory {
    enum Type {
        A, B
    }

    public AB create(Type type) {
        switch (type) {
            case A:
                return new A();
            case B:
                return new B();
            default:
                return () -> System.out.println("ab:ab");
        }
    }

    public static void main(String[] args) {
        AB a = new SimpleFactory().create(Type.A);
        AB b = new SimpleFactory().create(Type.B);
        a.ab();
        b.ab();

    }


}

interface AB {
    public void ab();
}

class A implements AB {
    @Override
    public void ab() {
        System.out.println("a:ab");
    }

    public void a() {
        System.out.println("AAAAA");
    }
}

class B implements AB {
    @Override
    public void ab() {
        System.out.println("b:ab");
    }

    public void b() {
        System.out.println("BBBBB");
    }
}