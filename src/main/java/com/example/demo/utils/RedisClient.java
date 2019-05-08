package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * RedisClient
 */
@Component
public class RedisClient {

    @Autowired
    private StringRedisTemplate redisTpl;

    public Boolean set(String key, String value) {
        try {
            redisTpl.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    public String get(String key) {
        return redisTpl.opsForValue().get(key);
    }

}