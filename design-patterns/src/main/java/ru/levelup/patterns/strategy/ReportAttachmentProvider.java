package ru.levelup.patterns.strategy;

import ru.levelup.patterns.strategy.impl.AllureReportAttachmentImpl;
import ru.levelup.patterns.strategy.impl.NewReportSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReportAttachmentProvider {

    private final List<ReportAttachment> reportAttachments;

    public ReportAttachmentProvider() {
        reportAttachments = new ArrayList<>();
        reportAttachments.add(new AllureReportAttachmentImpl());
        reportAttachments.add(new NewReportSystem());
    }

    public void attachScreenshot() {
        reportAttachments.forEach(reportAttachment -> reportAttachment.attachScreenshot());
    }

    public void attachScreenshot(String screenshot) {
        reportAttachments.forEach(reportAttachment -> reportAttachment.attachScreenshot(screenshot));
    }

    public void attachSql(String query) {
        reportAttachments.forEach(reportAttachment -> reportAttachment.attachSql(query));
    }
}
