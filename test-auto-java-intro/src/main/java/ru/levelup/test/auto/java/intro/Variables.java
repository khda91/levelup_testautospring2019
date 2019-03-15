package ru.levelup.test.auto.java.intro;

public class Variables {

    static Object obj1;

    public static void main(String[] args) {
        // simple variables
        int num1 = 3;
        int num2 = 5;
        int res = num1 + num2;
        System.out.println(res);
        System.out.println();

        // Classes

        System.out.println("Null obj " + obj1);
        System.out.println();

        Object obj2 = new Object();
        System.out.println("Some obj " + obj2);
        System.out.println();

        String baba = "baba";
        String dada = baba;

        System.out.println("baba -> " + baba);
        System.out.println("dada -> " + dada);
        System.out.println();

        dada = "dada";

        System.out.println("baba -> " + baba);
        System.out.println("dada -> " + dada);
        System.out.println();

        // Final
        final int a = 4;
//        a = 3;

        // Final object
        final String s = "mama";
        String ss = s;

        System.out.println("s -> " + s);
        System.out.println("ss -> " + ss);
    }
}
