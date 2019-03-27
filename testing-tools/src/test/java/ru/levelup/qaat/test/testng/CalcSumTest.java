package ru.levelup.qaat.test.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.level.qaat.test.Calc;

import static org.testng.Assert.assertEquals;

public class CalcSumTest {

    private Calc calc;

    @BeforeMethod
    public void init() {
        System.out.println("Calc Init");
        calc = new Calc();
    }

    @Test(dataProvider = "doubleSumDataProvider", dataProviderClass = SumDataProvider.class)
    public void sumDoubleTest(double a, double b, double res) {
        assertEquals(res, calc.sum(a, b));
    }

    @AfterMethod
    public void destroy() {
        System.out.println("Calc destroy");
        calc = null;
    }

}
