package com.algs4.mystack;

import java.util.Stack;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-09-26 18:00
 **/
public class MyStackNote {
    public static void main(String[] args) {
        int N;
        int a= 10;
        /**
         * 创建字符串栈的数组
         * java 会在编译时检查类型的安全性，但会在运行时抛弃所有这些信息，
         * 因此在运行时语句右侧就变成Stack<Object>[] 或者只剩下Stack[]
         * 因此 我们必须将他们转化为stack<String>[]
         */
//        Stack<String>[] stacks = new Stack[a]; error!
        Stack<String>[] stacks =(Stack<String>[]) new Stack[a];
        stacks[0].push("bihao");

    }
}