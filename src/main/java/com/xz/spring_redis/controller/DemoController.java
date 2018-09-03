package com.xz.spring_redis.controller;

import com.xz.spring_redis.model.ResponseModal;
import com.xz.spring_redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private RedisService redisService;


    @RequestMapping("/redis/set")
    public ResponseModal redisSet(@RequestParam("value")String value){
        redisService.set("name", value);
        return new ResponseModal(200, true, "success", null);
    }

    @RequestMapping("/redis/get")
    public ResponseModal redisGet(){
        String name = redisService.get("name");
        return new ResponseModal(200, true,"success",name);
    }


}