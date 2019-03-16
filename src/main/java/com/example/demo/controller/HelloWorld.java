package com.example.demo.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController // @ResponseBody + @Controller
@EnableAutoConfiguration //
public class HelloWorld {
    @RequestMapping
    String home(){
        return "helloworld";
    }

}