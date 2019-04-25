package com.example.demo.bean;

import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

	private int age;

	@JsonIgnore
	private String pwd;

	@JsonProperty("account")
	private String phone;

	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "zh", timezone = "GMT+8")
	private Date createTime;

	public Person() {
	}

	public Person(int age, String pwd, String phone, java.util.Date date) {
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

	public Person age(int age) {
		this.age = age;
		return this;
	}

	public Person pwd(String pwd) {
		this.pwd = pwd;
		return this;
	}

	public Person phone(String phone) {
		this.phone = phone;
		return this;
	}

	public Person createTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Person)) {
			return false;
		}
		Person user = (Person) o;
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
