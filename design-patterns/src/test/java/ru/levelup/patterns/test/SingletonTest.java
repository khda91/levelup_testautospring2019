package ru.levelup.patterns.test;

import org.testng.annotations.Test;
import ru.levelup.patterns.singleton.SingletonExample;

public class SingletonTest {

    @Test
    public void test1() {
        System.out.println(SingletonExample.getInstance());
    }

    @Test
    public void test2() {
        SingletonExample.getInstance().setD(8);
        System.out.println(SingletonExample.getInstance());
    }

    @Test
    public void test3() {
        System.out.println(SingletonExample.getInstance());
    }


}
