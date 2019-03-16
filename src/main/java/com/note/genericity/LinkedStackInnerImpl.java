package com.note.genericity;


/**
 * @program: javademo
 * @description: 栈实现用内部类实现
 * @author: chenp
 * @create: 2018-08-30 10:31
 **/
public class LinkedStackInnerImpl<T> {
    private class Node {
        T item;
        Node next;

        Node() {
            this.item = null;
            this.next = null;
        }

        Node(T item, Node next) {

            this.item = item;
            this.next = next;
        }

        boolean end() {
            return next == null && item == null;
        }

    }

    Node top = new Node();//哨兵

    public void push(T item) {
        top = new Node(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStackInnerImpl<String> linkedStackInner = new LinkedStackInnerImpl<>();
        LinkedStack<String> linkedStack = new LinkedStack<>();
        for (String s : "123 1231 312 qwe ad z cxza sd zcd sdfse r ".split(" ")){
            linkedStackInner.push(s);
            linkedStack.push(s);
            System.out.print(s+" " );
        }
        System.out.println();
        while ( linkedStackInner.pop() != null){
            System.out.print(linkedStackInner.pop()+" ");
        }
        System.out.println("---------------------");
        while ( linkedStack.pop() != null){
            System.out.print(linkedStack.pop()+" ");
        }
    }

}