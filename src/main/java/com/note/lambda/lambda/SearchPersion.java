package com.note.lambda.lambda;

import com.note.java8function.myInterfaces.FunctionTest;
import com.note.lambda.lambda.apple.Apple;

import java.util.*;
import java.util.function.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.stream.Collectors.*;

import static com.note.lambda.lambda.Letter.produce;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-12-30 17:23
 **/
public class SearchPersion {

    public static void printPersionOlderThan(List<Persion> roster, int age){
        for (Persion p: roster){
            if (p.getAge() >= age) {
                p.toString();
            }
        }
    }
    public static <T> List<T>  printPersionWithPredicate(List<T> roster, Predicate<T> p){
        ArrayList<T> ts = new ArrayList<>();
        for (T t: roster){
            if (p.test(t)){
                ts.add(t);
            }
        }
        return ts;
    }
    public static <T> void printEveryOne(List<T> list, Consumer<T> c){
        for (T t: list){
            c.accept(t);
        }
    }

    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();
        for (T t: list){
            result.add(f.apply(t));
        }
        return result;
    }
    public static void main(String[] args) {
        //lambda 表达式
        FunctionTest niahoa = () -> System.out.println("niahoa");
        BiConsumer<Integer,Integer> biConsumer = (Integer a, Integer b) -> System.out.println(a+b);
        Supplier<Apple> supplierApple = ()-> new Apple();
        Runnable runnable = ()-> System.out.println("this is a runable");
        Thread thread = new Thread(() -> System.out.println("this is a thread"));

        List<Persion> list = produce();

        String s="0000";
        Function<Integer,Integer> f = x->x+1;
        Function<Integer,Integer> g = x->x*2;

        Supplier<String> supplier = String::new;
        String s1 = supplier.get();

        Consumer<String> consumer = System.out::println;
        consumer.accept(s);

        Predicate<String> predicate = String::isEmpty;
        boolean test = predicate.test(s);

        Function<Integer, Integer> compose = f.compose(g);//f(g)
        Function<Integer, Integer> andThen = f.andThen(g); // g(f)

        Supplier<Apple> appleSupplier = Apple::new;
        Function<String,Apple> appleFunction = Apple::new;
        BiFunction<Integer,String,Apple> biFunction = Apple::new;



        Integer apply = compose.apply(1);
        Integer apply1 = andThen.apply(1);
        System.out.println(apply);
        System.out.println(apply1);


        List<Integer> map = map(list,persion -> persion.getAge());
        System.out.println("map length"+ map.get(0)+":"+ map.get(1)+":" +map.get(2)+":"+map.get(3));

        Function<String,String> addHeader = Letter::addHeader;
        addHeader.andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);

        List<Persion> list1 = printPersionWithPredicate(list, x -> x.getAge() > 10);
        System.out.println(list1.size());
        printEveryOne(list1,x -> System.out.println(x));
        String sss = Base64.getEncoder().encodeToString("0000".getBytes()).toString();
        System.out.println(s);
        Predicate<Persion> persionPredicate = persion ->persion.getAge() >10;
        Predicate<Persion> and = persionPredicate.and(persion -> persion.getGender().equals(Persion.Sex.MALE))
                .and(p -> p.getEmailAddress() != null);
        printPersionWithPredicate(list,and);
        //-------------
        IntSummaryStatistics collect = list.stream().collect(summarizingInt(Persion::getAge));

        double average = collect.getAverage();
        long count = collect.getCount();
        int max = collect.getMax();
        int min = collect.getMin();
        long sum = collect.getSum();
        System.out.println(average+","+count+","+max+","+min+","+sum+",");
        //连字符
        String collect1 = list.stream().map(Persion::getName).collect(joining("-"));
        System.out.println(collect1);

        Logger log = Logger.getLogger("SearchPersion");
        if (log.isLoggable(Level.INFO)){
            log.finer("Problem: " + "hahah ");
        }
        //有条件的延迟执行
        log.log(Level.INFO,()->"ni hao a ");

    }

}