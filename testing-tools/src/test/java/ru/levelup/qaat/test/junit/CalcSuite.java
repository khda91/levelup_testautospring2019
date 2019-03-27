package ru.levelup.qaat.test.junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CalcSumTest.class, CalcMultyTest.class})
public class CalcSuite {

    @BeforeClass
    public static void setUp() {
        System.out.println("Init Class");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Close Class");
    }
}
