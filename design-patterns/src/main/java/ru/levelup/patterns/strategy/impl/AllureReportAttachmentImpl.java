package ru.levelup.patterns.strategy.impl;

import io.qameta.allure.Attachment;
import ru.levelup.patterns.strategy.ReportAttachment;

public class AllureReportAttachmentImpl implements ReportAttachment {

    @Override
    @Attachment(value = "screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        return new byte[0];
    }

    @Override
    @Attachment(value = "{0}", type = "image/png")
    public byte[] attachScreenshot(String screenshot) {
        return new byte[0];
    }

    @Override
    @Attachment(value = "SQL Query", type = "text/html")
    public String attachSql(String query) {
        return String.format("<p>%s</p>", query);
    }
}
