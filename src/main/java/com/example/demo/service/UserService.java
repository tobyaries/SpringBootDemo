package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.User;

/**
 * UserService
 */
public interface UserService {

    public int add(User user);

    public List<User> getAll();

    public User findById(Long userId);

    public void update(User user);

    public void delete(Long userId);
}