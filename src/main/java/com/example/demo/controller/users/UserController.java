package com.example.demo.controller.users;

import java.util.Date;
import com.example.demo.bean.JsonData;
import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
// @RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * user 保存接口
     */
    @GetMapping("/api/v1/user/add")
    public Object add() {
        User user = new User();
        user.setAge(11);
        user.setCreateTime(new Date());
        user.setName("tianyuan");
        user.setPhone("17717322222");
        int id = userService.add(user);
        return JsonData.buildSuccess(id);
    }
}