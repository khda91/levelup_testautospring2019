package ru.levelup.test.auto.java.intro;

import java.util.ArrayList;
import java.util.List;

public class MethodsExample {

    private List<String> initList() {
        List<String> list = new ArrayList<>();
        list.add("pepe");
        list.add("pele");
        list.add("kaka");
        list.add("pepe");
        return list;
    }

    List<String> changeListByLink(List<String> list) {

        list.add("mama");
        list.add("papa");
        list.add("baba");
        list.add("dada");
        list.add("dede");

        return list;
    }

    List<String> changeListNewList(List<String> list) {
        List<String> lst = new ArrayList<>(list);

        lst.add("mama");
        lst.add("papa");
        lst.add("baba");
        lst.add("dada");
        lst.add("dede");

        return lst;
    }

    List<String> changeListCopyList(List<String> list) {
        List<String> lst = list;

        lst.add("mama");
        lst.add("papa");
        lst.add("baba");
        lst.add("dada");
        lst.add("dede");

        return lst;
    }

    public static void main(String[] args) {
        MethodsExample me = new MethodsExample();
        List<String> initialList = me.initList();

        System.out.print("Initial List -> " + initialList);
        System.out.println();
        System.out.println("-------------------------");
        System.out.println();

        List<String> changedListByLink = me.changeListByLink(initialList);

        System.out.print("Changed List -> " + changedListByLink);
        System.out.println();

        System.out.print("Initial List -> " + initialList);
        System.out.println();
        System.out.println("==========");
        System.out.println();

        initialList = me.initList();
        List<String> changedListNewList = me.changeListNewList(initialList);

        System.out.print("Changed List -> " + changedListNewList);
        System.out.println();

        System.out.print("Initial List -> " + initialList);
        System.out.println();
        System.out.println("==========");
        System.out.println();

        initialList = me.initList();
        List<String> changedListCopyList = me.changeListCopyList(initialList);

        System.out.print("Changed List -> " + changedListCopyList);
        System.out.println();

        System.out.print("Initial List -> " + initialList);
        System.out.println();
    }
}
