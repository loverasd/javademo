package com.note.myConcurrent;

import java.time.LocalDateTime;

/**
 * @Classname ClockSleep
 * @Date 2019-09-04 15:42
 * @Created by chenpan
 * @Description
 */
public class ClockSleep {
    private static String time = "16:10";
    private static int timeM = 16*60+10;

    public static void main(String[] args) {
        int day = 24;
        int dayM = 24*60;
        int hour = LocalDateTime.now().getHour();
        int minute = LocalDateTime.now().getMinute();
        int now = hour*60+minute;
        if (now > timeM) {
            System.out.format(">,%s\n",dayM-now+timeM);
            System.out.println(1310/60);
        }else {
            System.out.format("<=,%s", timeM - now);
        }
    }
}
