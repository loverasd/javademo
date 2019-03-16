package com.note.queue;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Queue;

/**
 * @program: javademo
 * @description: 队列概览
 * @author: chenp
 * @create: 2018-09-12 11:03
 **/
public class Summarize {
    Queue queue = new AbstractQueue() {
        @Override
        public Iterator iterator() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean offer(Object o) {
            return false;
        }

        @Override
        public Object poll() {
            return null;
        }

        @Override
        public Object peek() {
            return null;
        }
    };
}