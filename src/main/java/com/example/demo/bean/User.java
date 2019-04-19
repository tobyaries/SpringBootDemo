package com.example.demo.bean;

import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	private int age;

	@JsonIgnore
	private String pwd;

	@JsonProperty("account")
	private String phone;

	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss", locale = "zh", timezone = "GMT+8")
	private Date createTime;


	public User() {
	}

	
	public User(int age, String pwd, String phone, java.util.Date date) {
		this.age = age;
		this.pwd = pwd;
		this.phone = phone;
		this.createTime = date;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public User age(int age) {
		this.age = age;
		return this;
	}

	public User pwd(String pwd) {
		this.pwd = pwd;
		return this;
	}

	public User phone(String phone) {
		this.phone = phone;
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
		return age == user.age && Objects.equals(pwd, user.pwd) && Objects.equals(phone, user.phone) && Objects.equals(createTime, user.createTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, pwd, phone, createTime);
	}

	@Override
	public String toString() {
		return "{" +
			" age='" + getAge() + "'" +
			", pwd='" + getPwd() + "'" +
			", phone='" + getPhone() + "'" +
			", createTime='" + getCreateTime() + "'" +
			"}";
	}

	
}
