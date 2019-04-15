package ru.levelup.test.auto.java.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoClass {

//    public static void main(String[] args) {
    public static void main(String... args) {
        DemoClass cd = new DemoClass();
        List<String> list = new ArrayList<>();
        list.add("jug");
        list.add("SOAP");
        list.add("Soa");
        list.add("sea");
        list.add("sad");
        list.add("mom");
        list.add("sugar");

        List<String> lst = Arrays.asList("jug", "SOAP", "Soa", "sea", "sad", "mom");

        List<String> res = cd.getStringWithSSymbol(lst);
        List<String> res1 = cd.getStringWithSSymbol(Arrays.asList("jug", "SOAP", "Soa", "sea", "sad", "mom"));
        System.out.println(res);
        System.out.println(res1);

        System.out.println(cd.getSomeData(true));
        System.out.println(cd.getSomeData(false));
        if (cd.getSomeData(false) instanceof Double) {
            double d = 0.256 + Double.valueOf(String.valueOf(cd.getSomeData(false)));
            System.out.println(d);
        }

        boolean b = true;
        if (b) {
            throw new IllegalArgumentException("Enter incorrect data");
        }

        cd.sum(0.9, 8);
    }

    public List<String> getStringWithSSymbol(List<String> list) {
        List<String> results = new ArrayList<>();
        for (String str : list) {
            if(str.contains("s") || str.contains("S")) {
                results.add(str);
            }
        }
        return results;
    }

    public Object getSomeData(boolean condition) {
        return condition ? "mama" : 0.25;
    }

    public int sum(int i, int j) {
        return i + j;
    }

    public double sum(double i, double j) {
        System.out.println(Math.abs(1));
        System.out.println(Math.abs(-1));
        System.out.println(Math.abs(-4));
        System.out.println(Math.abs(2));
        System.out.println(Math.abs(1L));
        return i + j;
    }

}
