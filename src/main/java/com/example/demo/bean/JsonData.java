package com.example.demo.bean;

import java.io.Serializable;
import java.util.Objects;

public class JsonData implements Serializable {

    private static final long serialVersionUID = 6171340881451879529L;

    // 状态: 0-成果 -1-失败
    private int code;

    // 结果
    private Object data;

    private String errMsg;

    public JsonData() {
    }

    /**
     * @return the errMsg
     */
    public String getErrMsg() {
        return errMsg;
    }

    /**
     * @param errMsg the errMsg to set
     */
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public JsonData(int code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }

    public JsonData(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonData code(int code) {
        this.code = code;
        return this;
    }

    public JsonData data(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof JsonData)) {
            return false;
        }
        JsonData jsonData = (JsonData) o;
        return code == jsonData.code && Objects.equals(data, jsonData.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, data);
    }

    @Override
    public String toString() {
        return "{" + " code='" + getCode() + "'" + ", data='" + getData() + "'" + "}";
    }

}