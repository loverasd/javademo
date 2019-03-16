package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * @program: javademo
 * @description: mongoDB操作类
 * @author: chenp
 * @create: 2018-08-25 18:43
 **/
@Repository //dao层注解
public class MongoTestDao {
    @Autowired
    private MongoTemplate mongoTemplate;
}