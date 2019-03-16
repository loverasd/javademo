package com.note.java8optional.model;

import lombok.Data;

import java.util.Optional;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2019-01-29 08:20
 **/
@Data
public class Persion {
    private Optional<Car> car;
}
@Data
class Car{
    String name;
}