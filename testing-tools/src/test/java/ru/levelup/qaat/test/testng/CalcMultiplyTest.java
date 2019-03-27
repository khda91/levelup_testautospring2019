package ru.levelup.qaat.test.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.level.qaat.test.Calc;

import static org.testng.Assert.assertEquals;

public class CalcMultiplyTest {

    private Calc calc;

    @BeforeMethod
    public void init() {
        System.out.println("Calc Init");
        calc = new Calc();
    }

    @DataProvider
    public Object[][] doubleMultliplyDataProvider() {
        return new Object[][]{
                {2.0, 4.0, 8.0},
                {-3.5, 0.0, 0.0},
                {2.0, 20.0, 40.0},
                {4.0, 4.0, 16.0},
                {2.0, 2.0, 4.0},
                {-5.0, -5.0, 25.0},
                {2.0, 8.0, 16.0},
                {1.0, 1.0, 1.0},
                {3.0, 3.0, 9.0},
                {0.5, 4.0, 2.0}
        };
    }

    @Test(dataProvider = "doubleMultliplyDataProvider")
    public void multiplyDoubleTest(double a, double b, double res) {
        assertEquals(res, calc.multiply(a, b));
    }

    @AfterMethod
    public void destroy() {
        System.out.println("Calc destroy");
        calc = null;
    }

}
