package com.note.myutil;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * @program: javademo
 * @description: 时间工具类
 * @author: chenp
 * @create: 2018-09-10 10:
 *
 **/
public class MyTime {
    /**
     * Instant  瞬间      时间线上的一个点
     * Duration 持续时间    两个瞬时间之间的时间
     * LocalDate 是一个带有年份，月份，当月天数的日期
     * LocalDateTime 没有时区信息
     * TemporalAdjuster 处理日历计算
     * ZonedDateTime 是指定某一时区的某一个时间点
     * 处理带时区的时间时，使用时段Period，已将夏时令的变化考虑在内
     * 使用DateTimeFormatter 格式化和解析日期时间
     */
    public MyTime() {
    }

    private static Instant start;
    public static Instant start(){
        start = Instant.now();
        return start;
    }

    /**
     *
     * @return millis
     */
    public static long elapsedTime(){
        Instant end = Instant.now();
        Duration duration = Duration.between(start,end);
        long millis = duration.toMillis();
        return millis;
    }

    public static void main(String[] args) {
        System.out.println(start());

        System.out.println(LocalTime.now());

        System.out.println(elapsedTime());
    //-----------------------------------
//        当前日期添加十天
        System.out.println(LocalDate.now().plusDays(10L));
//        当前日期减去十天
        System.out.println(LocalDate.now().minusDays(10L));
//        修改九月份的天数为15天
        LocalDate month = LocalDate.now().withDayOfMonth(10);
        System.out.println(month.getDayOfMonth());
        DayOfWeek dayOfWeek = month.getDayOfWeek();

//        所有时区
        Set<String> ids = ZoneId.getAvailableZoneIds();
        ids.stream().sorted().forEach(s ->System.out.print(s+" "));
//        当前时区
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println();
        System.out.println(" default"+zoneId);

        System.out.println(Instant.now());

        ZonedDateTime noe = ZonedDateTime.now();
        System.out.println("1111111");
        System.out.println(noe);
//        设置时区为日本
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Japan"));
        System.out.println(now);
        System.out.println("---------------");
        System.out.println(Instant.now());

    }

}