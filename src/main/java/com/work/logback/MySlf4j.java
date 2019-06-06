package com.work.logback;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE})
public @interface MySlf4j {
/**
 * @program: demo
 *
 * @description: slf4j注解类
 *
 * @author: chenp
 *
 * @create: 2019-04-27 15:00
 * @company: sinosoft
 **/
String topic() default "";
}
