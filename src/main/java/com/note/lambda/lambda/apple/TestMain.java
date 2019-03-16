package com.note.lambda.lambda.apple;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.note.lambda.lambda.apple.MyMethod.filterApples;
import static com.note.lambda.lambda.apple.MyMethod.print;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-01-16 17:21
 **/
public class TestMain {


    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));


        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }

            @Override
            public boolean test(Apple apple, Apple a) {
                return false;
            }
        });

        inventory.sort(comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getCountry));
        Predicate<Apple> redApple = apple -> apple.getColor().equals("red");
        Predicate<Apple> negate = redApple.negate(); //非
        Predicate<Apple> or = redApple.or(s -> s.getColor().equals("blue"));
        Predicate<Apple> redAndHeavyApple =
                redApple.and(a -> a.getWeight() > 150);

        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.compose(g);//f(g)
        int result = h.apply(1);

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        String collect = menu.stream().map(Dish::getName).collect(Collectors.joining(","));
        Integer collect1 = menu.stream().collect(reducing(0, Dish::getCalories, (x, y) -> x + y));
        String collect2 = menu.stream().map(Dish::getName).collect(Collectors.joining(","));
        menu.stream().map(Dish::getName).collect(reducing("",(x,y)->x+y));
        //多级分组
        System.out.println("--------------");
        print("0",s->s.equals("0"),s-> System.out.println("你好"));
    }

}