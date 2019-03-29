package ru.levelup.qaat.test.testng;

import org.testng.annotations.DataProvider;

public class SumDataProvider {


    @DataProvider
    public Object[][] doubleSumDataProvider() {
        return new Object[][]{
                {2.0, 4.0, 6.0},
                {-3.5, 0.0, -3.5},
                {2.0, 20.0, 22.0},
                {4.0, 4.0, 8.0},
                {2.0, 2.0, 4.0},
                {-5.0, -5.0, -10.0},
                {2.0, 8.0, 10.0},
                {1.0, 1.0, 2.0},
                {3.0, 3.0, 6.0},
                {0.5, 4.0, 4.5}
        };
    }
}
