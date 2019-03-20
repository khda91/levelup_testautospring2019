package ru.levelup.test.auto.java.intro.classes.statics;

public class StaticMain {


    public static void main(String[] args) {
        StaticClassExample sce1 = new StaticClassExample();
        StaticClassExample sce2 = new StaticClassExample();
        StaticClassExample sce3 = new StaticClassExample();
        StaticClassExample sce4 = new StaticClassExample();
        StaticClassExample sce5 = new StaticClassExample();

        System.out.println(StaticClassExample.a);
        System.out.println(StaticClassExample.str);
        System.out.println(StaticClassExample.sum(10, 10));

        StaticClassExample.str = "mama";
        StaticClassExample.a = -1024;

        System.out.println();
        System.out.println(StaticClassExample.a);
        System.out.println(StaticClassExample.str);
    }


}
