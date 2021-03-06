package com.example.demo.controller.users;

import java.util.Date;
import java.util.List;
import com.example.demo.bean.JsonData;
import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * user 保存接口
     */
    @GetMapping("add")
    public Object add() {
        User user = new User();
        user.setAge(11);
        user.setCreateTime(new Date());
        user.setName("yestin");
        user.setPhone("17717322222");
        int id = userService.add(user);
        return JsonData.buildSuccess(id);
    }

    /**
     * user 查询接口
     */
    @GetMapping("getAll")
    public Object getAll() {
        List<User> list = userService.getAll();
        return JsonData.buildSuccess(list);
    }

     /**
     * user 查询指定用户
     */
    @GetMapping("findById")
    public Object findById(Long id) {
        User user = userService.findById(id);
        return JsonData.buildSuccess(user);
    }

    /**
     * user 删除指定用户
     */
    @GetMapping("deleteById")
    public Object deleteById(Long id) {
        userService.deleteById(id);
        return JsonData.buildSuccess();
    }

    /**
     * user 更新指定用户
     */
    @GetMapping("updateById")
    public Object updateById(Long id, String name) {
        userService.updateById(id, name);
        return JsonData.buildSuccess();
    }

    /**
     * 测试事务
     */
    @GetMapping("add_accout")
    public Object addAccount() {
        int id = userService.addAccount();
        return JsonData.buildSuccess(id);
    }
}