package com.algs4.mystack;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @program: javademo
 * @description: 链表实现 LIFO
 * @author: chenp
 * @create: 2018-09-26 10:54
 **/
public class MyStack<Item> implements Iterable<Item> {
    private Node first;
    int n = 0;
    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return n == 0;
    }
    public int size(){
        return n;
    }
    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }
    public  Item pop(){
        Item temp = first.item;
        first = first.next;
        n--;
        return temp;
    }
    @Override
    public Iterator<Item> iterator() {

        return new MyStackIterator();
    }
    private class MyStackIterator implements Iterator{

        @Override
        public boolean hasNext() {
            return n > 0;
        }

        @Override
        public Object next() {
            return first.item;
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer action) {

        }
    }

    @Override
    public void forEach(Consumer<? super Item> action) {

    }

    @Override
    public Spliterator<Item> spliterator() {
        return null;
    }

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        System.out.println(myStack.size());
        myStack.push("nihao");
        myStack.push(",wo hao");
        myStack.push("da jia hao");
        System.out.println(myStack.iterator().next());
        System.out.println(myStack.first.item);
        System.out.println(myStack.size());
    }
}