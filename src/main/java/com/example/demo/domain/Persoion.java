package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @program: javademo
 * @description: persion entity
 * @author: chenp
 * @create: 2018-08-25 18:20
 **/
@EntityScan
@Setter
@Getter
public class Persoion {
    private String name;
    private String age;
}