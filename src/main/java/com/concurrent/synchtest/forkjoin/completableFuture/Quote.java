package com.concurrent.synchtest.forkjoin.completableFuture;

import lombok.Data;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-02-19 14:38
 **/
@Data

public class Quote {
    private String shopName;
    private Double price;
    private Discount.Code code;

    public Quote(String shopName, Double price, Discount.Code code) {
        this.shopName = shopName;
        this.price = price;
        this.code = code;
    }

    public static Quote parse(String s){
        String[] split = s.split(":");
        String name = split[0];
        Double price = Double.parseDouble(split[1]);
        Discount.Code code = Discount.Code.valueOf(split[2]);
        Quote quote = new Quote(name, price, code);
        return quote;
    }
}