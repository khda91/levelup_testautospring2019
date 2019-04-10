package ru.levelup.selenium.po.fluent.enums;

public enum AccountPageTabMenuItem {
    MY_ACCOUNT("My Account"),
    PREFERENCES("Preferences"),
    API_TOKENS("API Tokens");

    private String value;

    AccountPageTabMenuItem(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}