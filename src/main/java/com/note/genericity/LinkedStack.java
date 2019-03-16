package com.note.genericity;

/**
 * @program: javademo
 * @description: 不用linkedList，来实现自内部的链式存储机制
 * @author: chenp
 * @create: 2018-08-30 09:46
 **/
public class LinkedStack<T> {
    private static class Node<U> {
        U item;
        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<>();
    public void push(T item){
        top = new Node<>(item, top);
    }

    public T pop(){
        T result = top.item;
        if (!top.end())
            top = top.next;
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<>();
        for (String s : "床前明月光，疑似地上霜，举头望明月，低头思故乡".split("，")){
            lss.push(s);
        }
        String s;
        while ( (s = lss.pop()) != null){
            System.out.println(s);
        }
    }

}