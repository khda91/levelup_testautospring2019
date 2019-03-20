package ru.levelup.test.auto.java.intro.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lists {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        ArrayList<String> list1 = new ArrayList<>();
        list.add("mama");
        list.add("papa");
        list.add(1, "dada");

        System.out.println(list);

        list.set(2, "baba");
        System.out.println(list);

        list.remove(0);
        System.out.println(list);
    }

}
