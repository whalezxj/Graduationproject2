package com.example.demo.utils;

import com.example.demo.enums.ResultEnum;

/**
 * @author JSONResultVo
 * @date 2020/8/26
 **/
public class JSONResultVo<T> extends Result {

    protected T info;

    public static JSONResultVo setErrorMsg(int code, String msg) {
        JSONResultVo vo = new JSONResultVo();
        vo.setMsg(msg);
        vo.setCode(code);
        return vo;
    }

    public static JSONResultVo setErrorMsg(ResultEnum resultEnum) {
        JSONResultVo vo = new JSONResultVo();
        vo.setMsg(resultEnum.getName());
        vo.setCode(resultEnum.getValue());
        return vo;
    }

    public static JSONResultVo setErrorMsg(int code, String msg, Object obj) {
        JSONResultVo vo = new JSONResultVo();
        vo.setMsg(msg);
        vo.setCode(code);
        vo.setInfo(obj);
        return vo;
    }

    public static JSONResultVo setData(Object obj) {
        JSONResultVo vo = new JSONResultVo();
        vo.setInfo(obj);
        vo.setMsg("成功");
        vo.setCode(ResultEnum.SUCCESS.getValue());
        return vo;
    }

    public static JSONResultVo ok() {
        JSONResultVo vo = new JSONResultVo();
        vo.setMsg("成功");
        vo.setCode(ResultEnum.SUCCESS.getValue());
        return vo;
    }

    public static JSONResultVo ok(String msg) {
        JSONResultVo vo = new JSONResultVo();
        vo.setMsg(msg);
        vo.setCode(ResultEnum.SUCCESS.getValue());
        return vo;
    }

    public JSONResultVo(int code, String msg) {
    }

    public void setInfo(T info) {
        this.setCode(ResultEnum.SUCCESS.getValue());
        this.info = info;
    }

    public T getInfo() {
        return this.info;
    }

    public String toString() {
        return "JSONResultVo(info=" + this.getInfo() + ")";
    }

    public JSONResultVo() {
    }

    public JSONResultVo(T info) {
        this.info = info;
    }

}
