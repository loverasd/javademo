package com.concurrent.synchtest.forkjoin.completableFuture;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.Max;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @program: javademo
 * @description: 商店
 * @author: chenp
 * @create: 2019-02-19 08:42
 **/
public class Shop {
    @Getter
    private String name;
    public Shop() {

    }
    public Shop(String name) {
        this.name=name;
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }
    public static List<String> findPrice1(List<Shop> shops, String product) {
        return  shops.parallelStream().map(shop -> String.format("%s price is %.2f",shop.getName(),shop.getPrice(product)))
                .collect(Collectors.toList());

    }

    public static List<String> findPrice2(List<Shop> shops, String product) {
        List<CompletableFuture<String>> collect = shops.stream().map(shop -> CompletableFuture.supplyAsync(() ->
                String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))))
                .collect(Collectors.toList());
        //。注意
        //CompletableFuture类中的join方法和Future接口中的get有相同的含义，并且也声明在
        //Future接口中，它们唯一的不同是join不会抛出任何检测到的异常。使用它你不再需要使用
        //try/catch语句块让你传递给第二个map方法的Lambda表达式变得过于臃肿
        List<String> collect1 = collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
        return collect1;
    }
    private double calculatePrice(String product) {
        delay();
        return Math.random() * product.charAt(0) + product.charAt(1);
    }

    public Future<Double> getPriceAsync2(String product) {
        return CompletableFuture.supplyAsync(()->calculatePrice(product));
    }
        public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(() -> {
            try{
                double price = calculatePrice(product);
                future.complete(price);   //价格计算正常结束，完成Future 操作 并设置商品价格
            }catch (Exception ex){      //价格计算未正常结束，抛出异常
                future.completeExceptionally(ex);
            }
        }).start();
        return future;
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
        }
    }
    static void  doSomethingElse(){
        new Thread(()->{
            int i = 0;
            while (i<10){
                System.out.println(i+"1 do something else");
                System.out.println(i+"2 do something else");
                i++;
            }
        }).start();
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        long start = System.nanoTime();
        Future<Double> my_product = shop.getPriceAsync("my product");
        long invocationTime = ((System.nanoTime() - start)/ 1_000_000);
        System.out.println("Invocation returned after "+ invocationTime+ " msecs");
        doSomethingElse();
        try {
            double price = my_product.get();
            System.out.printf("Price is %.2f%n",price);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long retrievalTime = ((System.nanoTime()-start) / 1_000_000);
        System.out.println("Price return after "+retrievalTime+" msecs" );
        int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism();
        System.out.println(commonPoolParallelism);

        List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll"));

    }
}