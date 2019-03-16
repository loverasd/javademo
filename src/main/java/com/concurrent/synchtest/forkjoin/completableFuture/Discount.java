package com.concurrent.synchtest.forkjoin.completableFuture;

import com.note.genericity.LinkedStack;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: javademo
 * @description: 折扣代码
 * @author: chenp
 * @create: 2019-02-19 14:09
 **/
public class Discount {
    static Random random = new Random();
static ThreadLocal<Instant> threadLocal = new ThreadLocal<>();

    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);
        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String getPrice(Shop shop, String product) {

        double price = calculatePrice(product);
        Code code = Code.values()[random.nextInt(Code.values().length)];
        System.out.println(shop.getName()+":"+Thread.currentThread().getId()+":获取价格的执行日期为："+ Instant.now());
        threadLocal.set(Instant.now());
        return String.format("%s:%.2f:%s", shop.getName(), price, code);
    }

    private static double calculatePrice(String product) {
        randomDelay();
        return Math.random() * product.charAt(0) + product.charAt(1);
    }

    public static String applyDiscount(Quote quote) {
        System.out.println(quote.getShopName() +":"+Thread.currentThread().getId()+":应用折扣执行：时间-----" + Instant.now());
        return quote.getShopName() + ":" + apply(quote.getPrice(), quote.getCode());
    }

    private static Double apply(Double price, Discount.Code code) {
//        delay(); //模拟延时
        randomDelay();
        Double diPrice = price * (100 - code.percentage);
        return diPrice;
    }
    public void getId(String id,int a){

    }

    /**
     * 延时1秒
     */
    private static void delay() {
        try {
            Thread.sleep(1000);
            System.out.println("sleep 1s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 随机延时0.5~~2.5秒
     */
    private static void randomDelay() { //
        int delay = 500 + random.nextInt(2000);
        try {
            Thread.sleep(delay);
            System.out.println("sleep 延时间为："+delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<String> findPrice1(List<Shop> shops, String product) {
        return shops.stream()
                .map((shop) -> Discount.getPrice(shop, product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    public List<String> findPrice2(List<Shop> shops, String product) {
        Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), r -> {
            Thread t = new Thread(r);
            t.setDaemon(true); //设置守护线程 这种方式不会阻止程序的关停
            return t;
        });
        Executor delayedExecutor = CompletableFuture.delayedExecutor(1L, TimeUnit.MINUTES, executor);
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> Discount.getPrice(shop, product)))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(() ->
                                Discount.applyDiscount(quote), delayedExecutor)
                ))
                .collect(Collectors.toList());
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
    public List<String> findPrice3(List<Shop> shops, String product) {
        Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), r -> {
            Thread t = new Thread(r);
            t.setDaemon(true); //设置守护线程 这种方式不会阻止程序的关停
            return t;
        });
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> Discount.getPrice(shop, product)))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(() ->
                                Discount.applyDiscount(quote), executor)
                ))
                .collect(Collectors.toList());
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public Stream<CompletableFuture<String>> findPricesStream(List<Shop> shops, String product) {
        return shops.stream().map(shop ->
                CompletableFuture.supplyAsync(() -> Discount.getPrice(shop, product)))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(
                        quote -> CompletableFuture.supplyAsync(
                                () -> Discount.applyDiscount(quote))
                ));
    }

}