package com.example.demo.dao;

import java.util.List;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * UserDAO
 */
public interface UserDAO {
    @Insert("INSERT INTO user(name, phone, create_time, age) VALUES(#{name}, #{phone}, #{createTime}, #{age})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn ="id")
    int insert(User user);


    @Select("SELECT * FROM user")
    @Results({
        @Result(column = "create_time", property = "createTime")
    })
    List<User> getAll();
}