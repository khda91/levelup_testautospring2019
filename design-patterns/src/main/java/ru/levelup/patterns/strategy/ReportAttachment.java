package ru.levelup.patterns.strategy;

public interface ReportAttachment {

    byte[] attachScreenshot();

    byte[] attachScreenshot(String screenshot);

    String attachSql(String query);

}
