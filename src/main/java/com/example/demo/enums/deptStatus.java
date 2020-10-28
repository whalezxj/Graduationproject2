package com.example.demo.enums;

import java.util.Arrays;

public enum deptStatus {
    no("1", "停用状态"),
    yes("0", "使用状态");

    private String value;
    private String name;

    deptStatus(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public boolean toBoolean() {
        return this == deptStatus.yes ? true : false;
    }

    public static String booleanToString(boolean value) {
        return value ? deptStatus.yes.getValue() : deptStatus.no.getValue();
    }

    public static deptStatus getByValue(String value) {
        return Arrays.stream(deptStatus.values()).filter(c -> c.getValue().equals(value)).findFirst().orElse(null);
    }
}
