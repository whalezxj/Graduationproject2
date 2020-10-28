package com.example.demo.enums;

import java.util.Arrays;

public enum StaffStatus {
    no("1", "离职状态"),
    yes("0", "在职状态");

    private String value;
    private String name;

    StaffStatus(String value, String name) {
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
        return this == StaffStatus.yes ? true : false;
    }

    public static String booleanToString(boolean value) {
        return value ? StaffStatus.yes.getValue() : StaffStatus.no.getValue();
    }

    public static StaffStatus getByValue(String value) {
        return Arrays.stream(StaffStatus.values()).filter(c -> c.getValue().equals(value)).findFirst().orElse(null);
    }
}
