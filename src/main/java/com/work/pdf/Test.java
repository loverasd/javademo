package com.work.pdf;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-02-22 08:47
 **/
public class Test {
    public enum JS {
        ENDORSEMENT, ENDORSEMENTINFO,
        POLICY, POLICYINFO
    }

    public static void main(String[] args) {
//        System.out.println(JS.ENDORSEMENT);
//        System.out.println(JS.ENDORSEMENT.equals(JS.ENDORSEMENT));
//        ZoneId of = ZoneId.of("shanghai");
//        System.out.println( of.getId());
//        int now = LocalDateTime.now().getHour();
//        String a = "P303224001231312310";
//        if (a.matches("P(32)|(44)|(41)\\d*")) {
//            System.out.println("河南 广东 江苏");
//        }
//        System.out.println(now);
//        String s = "";
//        switch (s) {
//            case "1":
//                System.out.println("ni hoa");
//                break;
//            default:
//                System.out.println("gun");
//                break;
//        }
        System.out.println("policy".equalsIgnoreCase(JS.POLICY.toString()));

    }

}