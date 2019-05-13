package com.example.demo.controller.redis;

import java.util.Date;

import com.example.demo.bean.JsonData;
import com.example.demo.bean.User;
import com.example.demo.utils.JsonUtils;
import com.example.demo.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RedisController
 */
@RestController
@RequestMapping("/api/v1/redis")
public class RedisController {

    // @Autowired
    // private StringRedisTemplate redisTpl; //jdbcTemplate

    @Autowired
    private RedisClient redis;

    @GetMapping(value = "add")
    public Object add() {
        // redisTpl.opsForValue().set("name", "delia");
        redis.set("username", "yestin");
        return JsonData.buildSuccess("OK");
    }

    @GetMapping(value = "save_user")
    public Object saveUser() {
        User user = new User(1, "abc", "13872112211", 21, new Date());
        Boolean result = redis.set("base:user:111", JsonUtils.obj2String(user));
        return JsonData.buildSuccess(result);
    }


    @GetMapping(value = "get_user")
    public Object getUser() {
        String str = redis.get("base:user:111");
        return JsonData.buildSuccess(JsonUtils.string2Obj(str, User.class));
    }

    @GetMapping(value = "get")
    public Object get() {
        // String value = redisTpl.opsForValue().get("name");
        String value = redis.get("username");
        return JsonData.buildSuccess(value);
    }
}