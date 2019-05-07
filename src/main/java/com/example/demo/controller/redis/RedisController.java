package com.example.demo.controller.redis;

import com.example.demo.bean.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RedisController
 */
@RestController
@RequestMapping("/api/v1/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTpl; //jdbcTemplate

    @GetMapping(value = "add")
    public Object add() {
        redisTpl.opsForValue().set("name", "delia");
        return JsonData.buildSuccess("OK");
    }

    @GetMapping(value = "get")
    public Object get() {
        String value = redisTpl.opsForValue().get("name");
        return JsonData.buildSuccess(value);
    }
}