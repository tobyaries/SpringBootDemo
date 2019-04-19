package com.example.demo.bean;

import java.util.Objects;

import org.springframework.web.bind.annotation.RestController;

/**
 * MyException
 * 自定义异常类
 */
public class MyException extends RuntimeException{
    
    private String code;

    private String msg;


    public MyException() {
    }

    public MyException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MyException code(String code) {
        this.code = code;
        return this;
    }

    public MyException msg(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MyException)) {
            return false;
        }
        MyException myException = (MyException) o;
        return Objects.equals(code, myException.code) && Objects.equals(msg, myException.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, msg);
    }

    @Override
    public String toString() {
        return "{" +
            " code='" + getCode() + "'" +
            ", msg='" + getMsg() + "'" +
            "}";
    }

}