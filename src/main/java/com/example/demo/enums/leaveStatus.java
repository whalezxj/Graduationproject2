package com.example.demo.enums;

import java.util.Arrays;

public enum leaveStatus {
    zero("0", "待审批"),
    one("1", "请假成功"),
    two("2", "请假失败");

    private String value;
    private String name;

    leaveStatus(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }


    public static leaveStatus getByValue(String value) {
        return Arrays.stream(leaveStatus.values()).filter(c -> c.getValue().equals(value)).findFirst().orElse(null);
    }
}
