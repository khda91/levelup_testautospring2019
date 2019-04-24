package ru.levelup.patterns.strategy.impl;

import ru.levelup.patterns.strategy.ReportAttachment;

public class NewReportSystem implements ReportAttachment {

    @Override
    public byte[] attachScreenshot() {
        return new byte[0];
    }

    @Override
    public byte[] attachScreenshot(String screenshot) {
        return new byte[0];
    }

    @Override
    public String attachSql(String query) {
        return null;
    }
}
