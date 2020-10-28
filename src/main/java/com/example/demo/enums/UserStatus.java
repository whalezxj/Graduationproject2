package com.example.demo.enums;

import java.util.Arrays;

public enum UserStatus {
    no("1", "停用状态"),
    yes("0", "使用状态");

    private String value;
    private String name;

    UserStatus(String value, String name) {
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
        return this == UserStatus.yes ? true : false;
    }

    public static String booleanToString(boolean value) {
        return value ? UserStatus.yes.getValue() : UserStatus.no.getValue();
    }

    public static UserStatus getByValue(String value) {
        return Arrays.stream(UserStatus.values()).filter(c -> c.getValue().equals(value)).findFirst().orElse(null);
    }
}
