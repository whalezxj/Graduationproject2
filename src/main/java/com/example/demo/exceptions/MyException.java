package com.example.demo.exceptions;

import com.example.demo.enums.ResultEnum;

/**
 * @author MyException
 * @date 2020/8/26
 **/
public class MyException extends RuntimeException {

    private int errorCode;

    public MyException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public MyException(ResultEnum re) {
        super(re.getName());
        this.errorCode = re.getValue();
    }

    public MyException(ResultEnum re, String message) {
        super(message);
        this.errorCode = re.getValue();
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
