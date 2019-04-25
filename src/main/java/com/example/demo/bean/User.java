package com.example.demo.bean;

import java.util.Date;
import java.util.Objects;

/**
 * User
 */
public class User {

    private int id;

    private String name;

    private String phone;

    private int age;

    private Date createTime;


    public User() {
    }

    public User(int id, String name, String phone, int age, Date createTime) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.createTime = createTime;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User id(int id) {
        this.id = id;
        return this;
    }

    public User name(String name) {
        this.name = name;
        return this;
    }

    public User phone(String phone) {
        this.phone = phone;
        return this;
    }

    public User age(int age) {
        this.age = age;
        return this;
    }

    public User createTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(phone, user.phone) && age == user.age && Objects.equals(createTime, user.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, age, createTime);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", phone='" + getPhone() + "'" +
            ", age='" + getAge() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            "}";
    }
    
}