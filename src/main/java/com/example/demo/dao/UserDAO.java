package com.example.demo.dao;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * UserDAO
 */
public interface UserDAO {
    @Insert("INSERT INTO user(name, phone, create_time, age) VALUES(#{name}, #{phone}, #{createTime}, #{age})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn ="id")
    int insert(User user);
}