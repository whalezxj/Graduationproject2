package com.example.demo.utils;

import com.example.demo.enums.ResultEnum;

import java.io.Serializable;

/**
 * @author Result
 * @date 2020/8/26
 **/
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private String msg;

    public Result() {
        this.code = ResultEnum.SUCCESS.getValue();
        this.msg = "成功";
    }

    public Result(ResultEnum re) {
        this.code = re.getValue();
        this.msg = re.getName();
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setException(String msg) {
        this.code = ResultEnum.SYSTEM_ERROR.getValue();
        this.msg = msg;
    }

    public void setCustomCodeWithMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setCustomCodeWithMsg(ResultEnum re) {
        this.code = re.getValue();
        this.msg = re.getName();
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
