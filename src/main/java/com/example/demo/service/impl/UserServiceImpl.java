package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;
import com.example.demo.bean.User;
import com.example.demo.dao.UserDAO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public int add(User user) {
        userDAO.insert(user);
        int id = user.getId();
        return id;
    }

    @Override
    public List<User> getAll() {
        List<User> list = userDAO.getAll();
        return list;
    }

    @Override
    public User findById(Long id) {
        User user = userDAO.findById(id);
        return user;
    }

    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }

    @Override
    public void updateById(Long id, String name) {
        userDAO.updateById(id, name);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addAccount() {
        User user = new User();
        user.setName("alan");
        user.setAge(88);
        user.setCreateTime(new Date());
        user.setPhone("18976253322");
        userDAO.insert(user);
        int i = 19/0;
        return 0;
    }
}