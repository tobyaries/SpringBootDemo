package com.example.demo.dao;

import java.util.List;

import com.example.demo.bean.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * UserDAO
 */
public interface UserDAO {
    @Insert("INSERT INTO USER(name, phone, create_time, age) VALUES(#{name}, #{phone}, #{createTime}, #{age})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn ="id")
    int insert(User user);

    @Select("SELECT * FROM USER")
    @Results({
        @Result(column = "create_time", property = "createTime")
    })
    List<User> getAll();

    @Select("SELECT * FROM USER WHERE id = #{id}")
    @Results({
        @Result(column = "create_time", property = "createTime")
    })
    User findById(long id);

    @Delete("DELETE FROM USER WHERE id = #{id}")
    @Results({
        @Result(column = "create_time", property = "createTime")
    })
    void deleteById(long id);

    @Update("UPDATE USER SET name = #{name} WHERE id = #{id}")
    @Results({
        @Result(column = "create_time", property = "createTime")
    })
    User updateById(Long id, String name);
}