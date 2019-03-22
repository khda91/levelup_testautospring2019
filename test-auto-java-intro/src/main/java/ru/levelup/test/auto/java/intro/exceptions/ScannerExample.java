package ru.levelup.test.auto.java.intro.exceptions;

import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intA;
        long longA;

    }

    private int sum(int a, int b) {
        return a + b;
    }

    private long sum(long a, long b) {
        return a + b;
    }


    private void a() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input int: ");
        int a = sc.nextInt();
        Price one = new Price(a);
        System.out.println("one (int) -> " + one.one);
        System.out.println();

        System.out.println("Input double: ");
        double b = sc.nextDouble();
        Price two = new Price(b);
        System.out.println("two (double) -> " + two.two);
        System.out.println();

        System.out.println("Input long: ");
        long c = sc.nextLong();
        Price three = new Price(c);
        System.out.println("three (long) -> " + three.three);
        System.out.println();
    }

}
