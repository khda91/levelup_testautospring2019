package ru.levelup.selenium.po.voids.enums;

public enum MenuItem {

    MY_VIEW("My View"),
    MANAGE("Manage");

    private String value;

    MenuItem(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
