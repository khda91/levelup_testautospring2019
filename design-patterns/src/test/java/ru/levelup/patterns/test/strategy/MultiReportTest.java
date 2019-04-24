package ru.levelup.patterns.test.strategy;

import org.testng.annotations.Test;
import ru.levelup.patterns.strategy.ReportAttachmentProvider;

public class MultiReportTest {

    private ReportAttachmentProvider reportAttachmentProvider = new ReportAttachmentProvider();

    @Test
    public void test() {
        try {
            System.out.println("jdjd");
        } catch (Exception e) {
            e.printStackTrace();
            reportAttachmentProvider.attachScreenshot();
        }
    }
}
