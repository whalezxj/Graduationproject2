package com.example.demo.enums;

public enum ResultEnum {
    SUCCESS(10000, "成功"),
    HTTP_CODE_401(401, "认证失败"),
    HTTP_CODE_404(404, "接口地址不存在"),
    PARAMETER_ERROR(1001, "参数验证错误"),
    SYSTEM_ERROR(1002, "系统异常"),
    LOGIN_ERROR(1003, "账户或者密码错误"),
    DELETE_ERROR(1004, "删除失败"),
    TOKEN_ERROR(1005, "token验证失败"),
    PHONE_ERROR(1006, "手机号码错误"),
    UPDATE_ERROR(1007, "修改失败"),
    INSERT_ERROR(1008, "添加失败"),
    VCODE_ERROR(1009, "验证码错误"),
    OUT_ERROR(1010, "退出错误"),
    ACCOUNT_ABNORMALITY(1011, "账户已锁定，请找管理员或技术支持解锁"),
    PHONE_VCODE_ERROR(1012, "手机验证码错误"),
    USER_NOT_EXISTS_ERROR(1013, "用户不存在"),
    PERMISSION_ERROR(1014, "没有权限访问"),
    NOT_LOGIN_ERROR(1015, "用户未登录，请先登录"),
    PARAM_NULL(1016, "参数为空"),
    DATA_REPETITION(1017, "数据已存在"),
    QUEYR_ERROR(1018, "无数据"),
    CALL_INTERFACE_ERROR(1019, "第三方接口调用异常"),
    STATUS_ERROR(1020, "状态异常"),
    DATA_ERROR(1021, "数据异常"),
    TYPE_PARAMETER_ERROR(1027, "监测要素错误"),
    NO_ROLE(1022, "用户未分配任何角色"),
    CAMERA_NO_OPEN(1023, "摄像头未开启"),
    REPEAT_CLOCKIN(1024, "今天已签到"),
    LOCUS_END(1025, "轨迹已结束"),
    SQL_ERROR(1026, "SQL执行异常"),
    PASSWORD_ERROR(1027, "密码不一致"),
    CAMERA_NO_BUSY(1027, "摄像头已经停止"),
    CALL_BUSY_ERROR(1026, "摄像头正忙"),
    VERSION_ERROR(1028, "版本文件格式不正确");

    private Integer code;
    private String msg;

    private ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getValue() {
        return this.code;
    }

    public String getName() {
        return this.msg;
    }
}
