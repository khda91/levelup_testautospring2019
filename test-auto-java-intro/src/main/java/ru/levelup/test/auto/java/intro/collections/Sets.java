package ru.levelup.test.auto.java.intro.collections;

import ru.levelup.test.auto.java.intro.objects.equals.Human;

import java.util.HashSet;
import java.util.Set;

public class Sets {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
//        Set<String> set = new LinkedHashSet<>();
//        Set<String> set = new TreeSet<>();
        set.add("papa");
        set.add("mama");
        set.add("zzzzzzzz");
        set.add("papa");
        set.add("pele");
        set.add("mama");

        System.out.println(set);


        Human dave = new Human();
        dave.setName("Dave");
        dave.setAge(20);

        Human judith = new Human();
        judith.setName("Judith");
        judith.setAge(20);

        Human david = new Human();
        david.setName("Dave");
        david.setAge(21);

        Set<Human> humanSet = new HashSet<>();
        humanSet.add(dave);
        humanSet.add(judith);
        humanSet.add(david);

        System.out.println(humanSet);

    }
}
