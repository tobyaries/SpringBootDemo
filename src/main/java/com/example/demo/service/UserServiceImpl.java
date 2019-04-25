package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.dao.UserDAO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}