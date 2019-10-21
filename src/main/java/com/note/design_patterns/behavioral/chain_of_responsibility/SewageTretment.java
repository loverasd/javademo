package com.note.design_patterns.behavioral.chain_of_responsibility;

/**
 * @Classname SewageTretment
 * @Date 2019/10/18 11:51 上午
 * @Created by chenpan
 * @Description 责任链模拟污水处理流程
 */
@FunctionalInterface
public interface SewageTretment {
    public enum Contaminant{ //定义污染物

    }
    void process();//污水处理方法

}
