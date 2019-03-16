package com.note.lambda.lambda;

import lombok.Data;

import java.time.LocalDate;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-12-30 17:17
 **/
@Data
public class Persion {
    public enum Sex{
        MALE,FEMALE
    }
    String name;
    LocalDate birthday;
    Sex gender;
    int age;
    String emailAddress;
}