package ru.levelup.qaat.test.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.level.qaat.test.Calc;

import static org.junit.Assert.assertEquals;

public class CalcSumTest {

    private Calc calc;

    @Before
    public void setUp() {
        System.out.println("init calc");
        calc = new Calc();
    }

    @Test
    public void sumIntNegativeTest() {
        int result = calc.sum(2, 2);
        assertEquals(6, result);
    }

    @Test
    public void sumIntNegativeTestWithMessage() {
        int result = calc.sum(2, 2);
        assertEquals("Invalid result", 8, result);
    }

    @Test
    public void sumIntTest() {
        int result = calc.sum(2, 2);
        assertEquals(4, result);
    }

    @After
    public void tearDown() {
        System.out.println("kill calc");
        calc = null;
    }
}
