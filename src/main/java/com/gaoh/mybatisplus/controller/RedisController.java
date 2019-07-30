package com.gaoh.mybatisplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoh
 * @version 1.0
 * @date 2019/7/30 16:16
 */
@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    //添加
    @GetMapping(value="/redisAdd")
    public void saveRedis(){
        redisTemplate.opsForValue().set("a","test");
    }

    //获取
    @GetMapping(value="/redisGet")
    public String getRedis(){
        return redisTemplate.opsForValue().get("papers").toString();
    }
}
