package com.concurrent.synchtest.forkjoin.completableFuture;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-02-19 10:52
 **/
public class MyExecutor {

    public static void main(String[] args) {
        List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll"));
        String product = "apple";
        Instant now = Instant.now();
        findPrice1(shops, product);
        Instant now1 = Instant.now();

        findPrice2(shops, product);
        Instant now2 = Instant.now();

        findPrice3(shops, product);
        Instant now3 = Instant.now();
        System.out.println("findPrice1 "+Duration.between(now, now1).toMillis());
        System.out.println("findPrice2 "+Duration.between(now1, now2).toMillis());
        System.out.println("findPrice3 "+Duration.between(now2, now3).toMillis());
        Discount discount = new Discount();
        System.out.println("-------------------------");
        discount.findPrice2(shops,product);

    }

    public static List<String> findPrice3(List<Shop> shops, String product) {
        List<String> collect = shops.stream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .filter(s -> {
                    System.out.println(s);
                    return true;
                })
                .collect(Collectors.toList());
        return collect;
    }

    public static List<String> findPrice2(List<Shop> shops, String product) {
        List<String> collect = shops.parallelStream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .filter(s -> {
                    System.out.println(s);
                    return true;
                })
                .collect(Collectors.toList());
        return collect;
    }

    public static List<String> findPrice1(List<Shop> shops, String product) {
        Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true); //设置守护线程 这种方式不会阻止程序的关停
                return t;
            }
        });
        List<CompletableFuture<String>> collect = shops.stream().map(shop -> CompletableFuture.supplyAsync(() ->
                String.format("%s price, %.2f", shop.getName(), shop.getPrice(product)), executor)).collect(Collectors.toList());
        List<String> collect1 = collect.stream().map(CompletableFuture::join)
                .filter(s -> {
                    System.out.println(s);
                    return true;
                })
                .collect(Collectors.toList());
        return collect1;
    }

}