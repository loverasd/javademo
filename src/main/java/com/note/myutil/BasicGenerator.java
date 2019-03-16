package com.note.myutil;

/**
 * @program: javademo
 * @description: 对象生成器
 * @author: chenp
 * @create: 2018-09-01 16:21
 **/
public class BasicGenerator<T> implements Generator<T> {
    public Class<T> type;
    public BasicGenerator(Class<T> type){
        this.type = type;
    }
    public T next(){
        try{
            return type.newInstance();
        }catch ( Exception e){
            throw new RuntimeException(e);
        }
    }

    public static <T> Generator<T> create(Class<T> type){
        return new BasicGenerator<>(type);
    }


}