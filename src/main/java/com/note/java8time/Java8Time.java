package com.note.java8time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-12-31 19:43
 **/
public class Java8Time {
    public static void main(String[] args) {
        Instant now1 = Instant.now();
        LocalDate date = LocalDate.of(2019,2,20);
        int year = date.get(ChronoField.YEAR);



        ZoneId.getAvailableZoneIds().stream().forEach(s -> {
//            System.out.println(s);
            ZonedDateTime now = ZonedDateTime.now(ZoneId.of(s));
            String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.println(s+"   "+format);
        });
        Instant now = Instant.now();
        Duration between = Duration.between(now1, now);


        System.out.println("--------------");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Lima"));
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        String format = zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(format);
        System.out.println(zonedDateTime);

    }
}