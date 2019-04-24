package ru.levelup.patterns.test.strategy;

import org.testng.annotations.Test;
import ru.levelup.patterns.strategy.ReportAttachment;
import ru.levelup.patterns.strategy.impl.AllureReportAttachmentImpl;
import ru.levelup.patterns.strategy.impl.NewReportSystem;

public class ReportTest {

//    private ReportAttachment report = new AllureReportAttachmentImpl();
    private ReportAttachment report = new NewReportSystem();

    @Test
    public void test() {
        try {
            System.out.println("asdhdjj");
        } catch (Exception e) {
            e.printStackTrace();
            report.attachScreenshot();
        }
    }
}
