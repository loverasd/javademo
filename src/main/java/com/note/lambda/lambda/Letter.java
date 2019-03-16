package com.note.lambda.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Letter {
    public static String addHeader(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }

    public static String addFooter(String text) {
        return text + " Kind regards";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }

    public static List<Persion> produce() {
        List<Persion> list = new ArrayList<>();


        Persion persion = new Persion();
        persion.setAge(10);
        persion.setBirthday(LocalDate.now());
        persion.setGender(Persion.Sex.MALE);
        persion.setName("libai");
        persion.setEmailAddress("11@qq.com");

        Supplier<Persion> persion2 = Persion::new;
        Persion persion1 = persion2.get(); //77
        persion1.setGender(Persion.Sex.MALE);
        persion1.setAge(9);

        Persion p = new Persion();
        p.setAge(11);
        p.setGender(Persion.Sex.FEMALE);

        Persion p1 = new Persion();
        p1.setAge(12);
        p1.setGender(Persion.Sex.MALE);

        list.add(persion1);
        list.add(p);
        list.add(p1);
        list.add(persion);
        return list;
    }

}