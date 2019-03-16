package com.note.myutil;

public interface Generator<T> {
/**
 * @program: javademo
 *
 * @description: 生成器负责生成新对象
 *
 * @author: chenp
 *
 * @create: 2018-08-30 15:28
 **/

    T next();
}
